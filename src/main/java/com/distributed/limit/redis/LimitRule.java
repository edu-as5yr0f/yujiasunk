package com.distributed.limit.redis;

import java.util.concurrent.TimeUnit;

/**
 * ���ƹ���
 * Created by sunyujia@aliyun.com on 2015/9/30.
 */
public class LimitRule {

    /**
     * ��λʱ��
     */
    private int seconds;

    /**
     * ��λʱ�������Ƶķ��ʴ���
     */
    private int limitCount;

    private int lockCount;

    private int lockTime;


    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(int limitCount) {
        this.limitCount = limitCount;
    }

    public int getLockCount() {
        return lockCount;
    }

    public void setLockCount(int lockCount) {
        this.lockCount = lockCount;
    }

    public int getLockTime() {
        return lockTime;
    }

    public void setLockTime(int lockTime) {
        this.lockTime = lockTime;
    }

    public boolean enableLimitLock(){
        return getLockTime()>0&&getLockCount()>0;
    }
}
