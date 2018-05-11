package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise3 {
    static AtomicInteger count = new AtomicInteger(1);
    static int threadCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Количество потоков: ");
        threadCount = Integer.parseInt(reader.readLine());
        for (int i = 1; i < threadCount + 1; i++) {
            Thread thread = new NumThread(i);
            thread.start();
        }
    }
}
