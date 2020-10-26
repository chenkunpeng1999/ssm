package com.hy.Jedis;

import redis.clients.jedis.Jedis;

public class listTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        jedis.auth("huayu");  //开启密码验证（配置文件中为 requirepass helloworld）的时候需要执行该方法

        String key = "mylist";
        jedis.del(key);

        // 队列添加元素
        jedis.rpush(key, "aaaa");
        jedis.rpush(key, "aaaa");
        jedis.rpush(key, "bbbb");
        jedis.rpush(key, "cccc");
        jedis.rpush(key, "cccc");

        // 队列长度
        System.out.println("lenth: " + jedis.llen(key));

        // 打印队列，从索引0开始，到倒数第1个（全部元素）
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 索引为1的元素
        System.out.println("index of 1: " + jedis.lindex(key, 1));

        // 设置队列里面一个元素的值，当index超出范围时会返回一个error。
        jedis.lset(key, 1, "aa22");
        System.out.println("index of 1: " + jedis.lindex(key, 1));

        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 从队列的右边入队一个元素
        jedis.rpush(key, "-2", "-1");// 先-2，后-1入队列
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 从队列的左边入队一个或多个元素
        jedis.lpush(key, "second element", "first element");// 先second
        // element，后first
        // elementF入队列
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 从队列的右边出队一个元素
        System.out.println(jedis.rpop(key));

        // 从队列的左边出队一个元素
        System.out.println(jedis.lpop(key));

        // count > 0: 从头往尾移除值为 value 的元素，count为移除的个数。
        // count < 0: 从尾往头移除值为 value 的元素，count为移除的个数。
        // count = 0: 移除所有值为 value 的元素。
        jedis.lrem(key, 1, "cccc");
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

        // 即最右边的那个元素也会被包含在内。 如果start比list的尾部下标大的时候，会返回一个空列表。
        // 如果stop比list的实际尾部大的时候，Redis会当它是最后一个元素的下标。
        System.out.println(jedis.lrange(key, 0, 2));

        // 删除区间以外的元素
        System.out.println(jedis.ltrim(key, 0, 2));
        System.out.println("all elements: " + jedis.lrange(key, 0, -1));

    }

}
