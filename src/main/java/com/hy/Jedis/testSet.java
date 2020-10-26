package com.hy.Jedis;

import redis.clients.jedis.Jedis;

public class testSet {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        jedis.auth("huayu");  //开启密码验证（配置文件中为 requirepass helloworld）的时候需要执行该方法

        // 清空数据
        System.out.println(jedis.flushDB());
        String key = "myset";
        String key2 = "myset2";

        // 集合添加元素
        jedis.sadd(key, "aaa", "bbb", "ccc");
        jedis.sadd(key2, "bbb", "ccc", "ddd");

        // 获取集合里面的元素数量
        System.out.println(jedis.scard(key));

        // 获得两个集合的交集，并存储在一个关键的结果集
        jedis.sinterstore("destination", key, key2);
        System.out.println(jedis.smembers("destination"));

        // 获得两个集合的并集，并存储在一个关键的结果集
        jedis.sunionstore("destination", key, key2);
        System.out.println(jedis.smembers("destination"));

        // key集合中，key2集合没有的元素，并存储在一个关键的结果集
        jedis.sdiffstore("destination", key, key2);
        System.out.println(jedis.smembers("destination"));

        // 确定某个元素是一个集合的成员
        System.out.println(jedis.sismember(key, "aaa"));

        // 从key集合里面随机获取一个元素
        System.out.println(jedis.srandmember(key));

        // aaa从key移动到key2集合
        jedis.smove(key, key2, "aaa");
        System.out.println(jedis.smembers(key));
        System.out.println(jedis.smembers(key2));

        // 删除并获取一个集合里面的元素
        System.out.println(jedis.spop(key));

        // 从集合里删除一个或多个元素
        jedis.srem(key2, "ccc", "ddd");
        System.out.println(jedis.smembers(key2));
    }

}