package exercise5;

import java.io.*;

public class Exercise5 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите директорию: ");
        String filePath = reader.readLine();
        Processor processor = new Processor();
        Thread thread1 = new ReadFilesThread(filePath, processor);
        Thread thread2 = new ReadFilesThread(filePath, processor);
        thread1.start();
        thread2.start();
    }
}
