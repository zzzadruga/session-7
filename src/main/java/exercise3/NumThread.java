package exercise3;

import static exercise3.Exercise3.threadCount;
import static exercise3.Exercise3.count;

public class NumThread extends Thread{
    private int index;

    public NumThread(int index){
        this.index = index;
    }

    @Override
    public void run() {
        while (true) {
            if (count.get() == index){
                System.out.println("Поток " + index);
                if (count.get() == threadCount){
                    count.set(1);
                } else {
                    count.incrementAndGet();
                }
            }
        }
    }
}