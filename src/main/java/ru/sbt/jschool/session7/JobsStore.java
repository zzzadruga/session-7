package ru.sbt.jschool.session7;

/**
 * @author NIzhikov
 */
public class JobsStore {
    public static final int JOB_STORE_SIZE = 20;

    public Job[] store = new Job[JOB_STORE_SIZE];

    public volatile int cnt = 0;
}
