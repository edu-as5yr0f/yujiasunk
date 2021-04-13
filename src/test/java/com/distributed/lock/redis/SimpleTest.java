package com.distributed.lock.redis;

import com.distributed.lock.Callback;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyujia@aliyun.com on 2016/2/24.
 */
public class SimpleTest {

    public static void main(String[] args) throws Exception {
        JedisPool jedisPool=new JedisPool("127.0.0.1",6379);//ʵ��Ӧ��ʱ��ͨ��springע��
        RedisReentrantLock lock=new RedisReentrantLock(jedisPool,"������ˮ��");
        try {
            if (lock.tryLock(5000L, TimeUnit.MILLISECONDS)) {
                //TODO �������Ҫ������
            }else{
                //TODO �������ʱ��Ҫ������
            }
        }finally {
            lock.unlock();
        }
    }

    public static void test1(){
        JedisPool jedisPool=new JedisPool("127.0.0.1",6379);//ʵ��Ӧ��ʱ��ͨ��springע��
        final RedisDistributedLockTemplate template=new RedisDistributedLockTemplate(jedisPool);//������̰߳�ȫ,��ͨ��springע��
        template.execute("������ˮ��", 5000, new Callback() {
            @Override
            public Object onGetLock() throws InterruptedException {
                //TODO �������Ҫ������
                return null;
            }

            @Override
            public Object onTimeout() throws InterruptedException {
                //TODO �������ʱ��Ҫ������
                return null;
            }
        });
    }
}
