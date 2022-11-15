package com.plus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PlusApplication.class)
class PlusApplicationTests {

    /**
     * QueryWrapper : allEq(=),eq(=),ne(<>),gt(>),ge(>=),lt(<),le(<=)
     */
    @Test
    void contextLoads() {
        welcome();
//        QueryWrapper<Actor> queryWrapper = new QueryWrapper<>();
//        Map params = new HashMap();
//        params.put("type", 1);
//        params.put("actor_name", null);
//        List<Actor> list = actorMapper.selectList(queryWrapper.allEq(params,false));
//        list.forEach(n -> {
//            System.out.println(n.toString());
//        });
    }

    /**
     * 输出引导语
     */
    public void welcome() {
        System.out.println();
        System.out.println("   .  ._______.______. _____._______.__ _ _   ");
        System.out.println("  /\\\\ |__   __|  ____|/ ____|__   __|\\ \\ \\ \\  ");
        System.out.println(" ( ( )   | |  | |____/ /____   | |    \\ \\ \\ \\ ");
        System.out.println("  \\\\/    | |  |  ____| '___ \\  | |     ) ) ) )");
        System.out.println("   '     | |  | |____._____) | | |    / / / / ");
        System.out.println("  =======|_|==|______.\\_____/==|_|===/_/ /_/  ");
        System.out.println("  :: Spring Test ::            (v2.1.3.RELEASE)");
        System.out.println();
    }
}
