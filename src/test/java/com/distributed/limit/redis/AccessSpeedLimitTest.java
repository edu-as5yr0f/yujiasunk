package com.distributed.limit.redis;

import com.distributed.lock.redis.RedisDistributedLockTemplate;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunyujia@aliyun.com on 2016/2/27.
 */
public class AccessSpeedLimitTest {
    @Test
    public void test1() throws InterruptedException {
        JedisPool jp=new JedisPool("127.0.0.1",6379);
        AccessSpeedLimit accessSpeedLimit=new AccessSpeedLimit(jp);
        SimpleDateFormat sdf=new SimpleDateFormat(" mm:ss");
        while(true){
            //10.0.0.1���ipÿ1����������5�α�����.
            if(accessSpeedLimit.tryAccess("10.0.0.1", 1,5)){
                System.out.println("yes"+sdf.format(new Date()));
            }else{
                System.out.println("no"+sdf.format(new Date()));
            }
            Thread.sleep(100);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        JedisPool jp=new JedisPool("127.0.0.1",6379);
        final RedisDistributedLockTemplate template=new RedisDistributedLockTemplate(jp);
        LimitRule limitRule=new LimitRule();
        limitRule.setSeconds(1);
        limitRule.setLimitCount(5);
        limitRule.setLockCount(7);
        limitRule.setLockTime(2);
        AccessSpeedLimit accessSpeedLimit=new AccessSpeedLimit(jp);
        SimpleDateFormat sdf=new SimpleDateFormat(" mm:ss");
        while(true){
            //10.0.0.1���ipÿ1����������5�α�����.1�볬��10�κ�,����2��.
            if(accessSpeedLimit.tryAccess("10.0.0.1",limitRule)){
                System.out.println("yes"+sdf.format(new Date()));
            }else{
                System.out.println("no"+sdf.format(new Date()));
            }
            Thread.sleep(100);
        }
    }
}
