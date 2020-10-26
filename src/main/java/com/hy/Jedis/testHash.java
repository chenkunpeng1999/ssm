package com.hy.Jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class testHash {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        jedis.auth("huayu");  //开启密码验证（配置文件中为 requirepass helloworld）的时候需要执行该方法

        // 清空数据
        System.out.println(jedis.flushDB());
        String key = "myhash";
        Map<String, String> hash = new HashMap<String, String>();
        hash.put("aaa", "11");
        hash.put("bbb", "22");
        hash.put("ccc", "33");

        // 添加数据
        jedis.hmset(key, hash);
        jedis.hset(key, "ddd", "44");

        // 获取hash的所有元素(key值)
        System.out.println(jedis.hkeys(key));

        // 获取hash中所有的key对应的value值
        System.out.println(jedis.hvals(key));

        // 获取hash里所有元素的数量
        System.out.println(jedis.hlen(key));

        // 获取hash中全部的域和值,以Map<String, String> 的形式返回

        Map<String, String> elements = jedis.hgetAll(key);
        System.out.println(elements);

        // 判断给定key值是否存在于哈希集中
        System.out.println(jedis.hexists(key, "bbb"));

        // 获取hash里面指定字段对应的值
        System.out.println(jedis.hmget(key, "aaa", "bbb"));

        // 获取指定的值
        System.out.println(jedis.hget(key, "aaa"));

        // 删除指定的值
        System.out.println(jedis.hdel(key, "aaa"));
        System.out.println(jedis.hgetAll(key));

        // 为key中的域 field 的值加上增量 increment
        System.out.println(jedis.hincrBy(key, "bbb", 100));
        System.out.println(jedis.hgetAll(key));

    }

}
