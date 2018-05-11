package exercise1;

public class NumThread extends Thread{
    private int index;

    public NumThread(int index){
        this.index = index;
    }

    @Override
    public void run() {
        if (index < 50) {
            NumThread numThread = new NumThread(index + 1);
            numThread.start();
            try {
                numThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hello from Thread-" + index);
    }
}