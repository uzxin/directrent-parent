package com.directrent.common.utils;

/**
 * @description:
 * @author: YX
 * @date: 2020/09/02 20:31
 */
public class WorkerUtil {
    private static final SnowflakeIdWorker worker = SnowflakeIdWorker.getInstance();

    public static long nextId(){
        return worker.nextId();
    }
}
