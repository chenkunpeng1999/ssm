package com.hy.Jedis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class stringTest{

    public static void main(String[]args){

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        jedis.auth("huayu");  //开启密码验证（配置文件中为 requirepass helloworld）的时候需要执行该方法

        jedis.set("hello", "hello");
        System.out.println(jedis.get("hello"));

        // 使用append 向字符串后面添加
//        jedis.append("hello", " world");
//        System.out.println(jedis.get("hello"));

        // set覆盖字符串
//        jedis.set("hello", "123");
//        System.out.println(jedis.get("hello"));

        // 设置过期时间
//        jedis.setex("hello2", 2, "world2");
//        System.out.println(jedis.get("hello2"));
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//        }
//        System.out.println(jedis.get("hello2"));

        // 一次添加多个key-value对
//        jedis.mset("a", "1", "b", "2");

        // 获取a和b的value
//        List<String> valus = jedis.mget("a", "b");
//        System.out.println(valus);

        // 批量删除
//        jedis.del("a", "b");
//        System.out.println(jedis.exists("a"));
//        System.out.println(jedis.exists("b"));
    }
}

