package exercise5;

import java.io.*;
import java.nio.file.Paths;
import java.util.Objects;

public class ReadFilesThread extends Thread{
    private String path;
    private Processor processor;

    public ReadFilesThread(String path, Processor processor) throws Exception {
        this.path = path;
        if (processor == null){
            throw new Exception("Обработчик не задан");
        } else{
            this.processor = processor;
        }
    }

    @Override
    public void run() {
        File directory  = Paths.get(this.path).toFile();
        StringBuilder fileContent;
        String line;
        if (!directory.isDirectory()){
            try {
                throw new IOException("Неверный путь!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                    fileContent = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        fileContent.append(line);
                    }
                    processor.wordCounter(fileContent.toString());
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
