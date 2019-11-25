package com.vincent.springbootredis;

import com.vincent.springbootredis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("username", "xiaoming");
        Assert.assertEquals("xiaoming", stringRedisTemplate.opsForValue().get("username"));
    }

    @Test
    public void testObj() throws Exception {
        User user = new User("123456", "xiaoli", "10086");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("user", user);
        operations.set("xxx", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
//        redisTemplate.delete("xxx");
        boolean exists = redisTemplate.hasKey("xxx");
        System.out.println("是否存在=" + exists);
//        System.out.println(operations.get("xxx").getUserName());
//        Assert.assertEquals("xiaoli", operations.get("xxx").getUserName());
    }
}
