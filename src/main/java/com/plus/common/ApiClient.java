package com.plus.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author： dongyi
 * @Description : http请求封装
 * @Date : 2022年11月15日11:37:49
 */
public class ApiClient {
    static String url;
    static CloseableHttpClient client = null;
    static HttpGet get = null;
    static HttpPost post = null;
    static HttpResponse response = null;

    // form表单
    public static String doPostForm(String URL, Object params, Map<String, Object> head, Object body) {
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        DataSet.setParams(post, url, params);
        DataSet.setHead(post, head);
        DataSet.setForm(post, body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    // json格式
    public static String doPostJson(String URL, Object params, Map<String, Object> head, Object body, Object tokenValue,
                                    String path) {
        if (body == null){
            Map<String , Object> newBody = new LinkedHashMap<>();
            newBody.put("1" , "1");
            body = newBody;
        }

        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        DataSet.setParams(post, url, params);
        DataSet.setHead(post, head);
        DataSet.setJson(post, body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    // xml格式
    public static String doPostXml(String URL, Object params, Map<String, Object> head, Object body) {
        url = URL;
        client = HttpClients.createDefault();
        post = new HttpPost(url);
        String responseStr = null;

        post = DataSet.setParams(post, url, params);
        DataSet.setHead(post, head);
        DataSet.setXml(post, body);

        try {
            response = client.execute(post);
            responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseStr;
    }

    // get请求
    public static String doGetUrl(String URL) throws IOException {
        url = URL;
        get = new HttpGet(url);
        String responseStr = null;

        get.setHeader("Content-Type", "application/x-www-form-urlencoded");
        response = client.execute(get);

        responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
//        System.out.println(responseStr);
        return responseStr;
    }

}
