package exercise2;

public class Exercice2{
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread thread1 = new Thread(() -> {
            synchronized (obj){
                while(true) {
                    obj.notify();
                    System.out.println("Поток 2");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (obj){
                while (true) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Поток 1");
                    obj.notify();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
