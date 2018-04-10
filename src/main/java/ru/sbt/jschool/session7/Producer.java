package ru.sbt.jschool.session7;

import java.util.List;

/**
 */
public class Producer implements Runnable {
    public static final int JOB_PRODUCE_TIME = 250;

    private List<Job> jobs;

    private int i = 0;

    public Producer(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override public void run() {
        try {
            while (true) {

                if (jobs.size() >= Main.CONSUMER_CNT) {
                    System.out.println("Skip generating jobs! Consumer is bad!");
                } else {
                    System.out.println("Generating job - " + ++i);
                    jobs.add(new Job(i));
                }

                Thread.sleep(JOB_PRODUCE_TIME);
            }
        }
        catch (InterruptedException e) {
            System.out.println("e = " + e);
        }
    }
}
