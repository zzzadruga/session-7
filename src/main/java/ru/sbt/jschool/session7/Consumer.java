package ru.sbt.jschool.session7;

import java.util.List;
import java.util.Set;

/**
 * @author NIzhikov
 */
public class Consumer implements Runnable {
    public static final int JOB_EXECUTE_TIME = 1000;
    private List<Job> jobs;

    private Set<Integer> doneJobs;

    public Consumer(List<Job> jobs, Set<Integer> doneJobs) {
        this.jobs = jobs;
        this.doneJobs = doneJobs;
    }

    @Override public void run() {
        System.out.println("Consumer Thread[" + Thread.currentThread().getId() + "] started.");
        try {
            while (true) {
                if (!jobs.isEmpty()) {
                    Job job = jobs.remove(0);

                    System.out.println("Consumer Thread[" + Thread.currentThread().getId() + "] - execute a job - " + job.getI());

                    if (!doneJobs.add(job.getI()))
                        throw new RuntimeException("Job " + job.getI() + " are executed twice!");

                    Thread.sleep(JOB_EXECUTE_TIME);
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println("e = " + e);
        }
    }
}
