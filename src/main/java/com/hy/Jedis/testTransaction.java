package com.hy.Jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Set;

public class testTransaction {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口

        jedis.auth("huayu");  //开启密码验证（配置文件中为 requirepass helloworld）的时候需要执行该方法

        Transaction t = jedis.multi();

        t.set("hello", "world");

        Response<String> response = t.get("hello");

        t.zadd("foo", 1, "barowitch");

        t.zadd("foo", 0, "barinsky");

        t.zadd("foo", 0, "barikoviev");

        Response<Set<String>> sose = t.zrange("foo", 0, -1); //  返回全部相应并以有序集合的方式返回

        System.out.println(response);

        System.out.println(sose);

        t.exec(); // 此行注意，不能缺少


        String foolbar = response.get(); // Response.get() 可以从响应中获取数据

        int soseSize = sose.get().size(); // sose.get() 会立即调用set方法

        System.out.println(foolbar);

        System.out.println(sose.get());

    }

}
