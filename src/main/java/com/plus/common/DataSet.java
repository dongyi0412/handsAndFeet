package com.plus.common;

import com.alibaba.fastjson.JSON;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import javax.xml.bind.Marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/2/19 9:24
 */
public class DataSet {

    public static void setXml(HttpPost post,Object body){
        //组装body参数(xml格式)
        if (body != null){
            System.out.println(objToXml(body));
            //组装xml参数
            HttpEntity entity2 = new StringEntity(objToXml(body),"utf-8");// 解决中文乱码问题
            post.addHeader("Context-Type","text/xml;charset=UTF-8");
            post.setEntity(entity2);
        }
    }

    public static void setJson(HttpPost post,Object body){
        if(body!=null){
            System.out.println("请求数据："+ JSON.toJSON(body).toString());
            StringEntity entity = new StringEntity(JSON.toJSON(body).toString(), "utf-8");// 解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            post.setEntity(entity);
        }
    }

    public static void setForm(HttpPost post,Object body){
        if(body!=null){
            try{
                System.out.println(body);
                post.setHeader("Content-Type", "application/x-www-form-urlencoded");
                Map<String,Object> map = JavaBeanUtils.convertBeanToMap(body);
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : map.keySet()) {
                    paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                post.setEntity(entity);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static HttpPost setParams(HttpPost post,String url,Object params){
        //组装params参数
        String str = "";
        if(params!=null){
            Map<String,Object> map = null;
            try {
                map = JavaBeanUtils.convertBeanToMap(params);
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (String key : map.keySet()) {
                    paramList.add(new BasicNameValuePair(key, map.get(key).toString()));
                }
                str = EntityUtils.toString(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
                post = new HttpPost(url+"?"+str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(url+"?"+str);
        return post;
    }

    public static HttpPost setHead(HttpPost post,Map<String,Object> head){
        //组装head参数
        if(head!=null) {
            for (String key : head.keySet()) {
                post.addHeader(key,head.get(key).toString());
            }
        }
        return post;
    }

    public static String objToXml(Object object){
        StringWriter stringWriter = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(object,stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

}
