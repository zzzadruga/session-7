package ru.sbt.jschool.session7;

import java.util.Set;

/**
 * @author NIzhikov
 */
public class Consumer implements Runnable {
    public static final int JOB_EXECUTE_TIME = 2000;

    private final JobsStore store;

    private Set<Integer> doneJobs;

    public Consumer(JobsStore store, Set<Integer> doneJobs) {
        this.store = store;

        this.doneJobs = doneJobs;
    }

    @Override public void run() {
        System.out.println("Consumer Thread[" + Thread.currentThread().getId() + "] started.");
        try {
            while (true) {
                Job job = getJob();

                executeJob(job);
            }
        }
        catch (InterruptedException e) {
            System.out.println("e = " + e);
        }
    }

    private Job getJob() throws InterruptedException {
        Job job = null;

        synchronized (store) {
            if (store.cnt > 0) {
                job = store.store[store.cnt-1];

                store.store[--store.cnt] = null;
            } else
                store.wait();
        }

        return job;
    }

    private void executeJob(Job job) throws InterruptedException {
        if (job != null) {
            System.out.println("Consumer Thread[" + Thread.currentThread().getId() + "] - execute a job - " + job.getI());

            if (!doneJobs.add(job.getI()))
                throw new RuntimeException("Job " + job.getI() + " are executed twice!");

            Thread.sleep(JOB_EXECUTE_TIME);
        }
    }
}
