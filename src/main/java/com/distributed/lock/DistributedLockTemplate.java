package com.distributed.lock;

/**
 * �ֲ�ʽ��ģ����
 * Created by sunyujia@aliyun.com on 2016/2/23.
 */
public interface DistributedLockTemplate {

    /**
     *
     * @param lockId ��id(��Ӧҵ��ΨһID)
     * @param timeout ��λ����
     * @param callback �ص�����
     * @return
     */
    public Object execute(String lockId,int timeout,Callback callback);
}
