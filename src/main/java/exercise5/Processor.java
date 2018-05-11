package exercise5;

public class Processor{
    public void wordCounter(String content) throws InterruptedException {
        Thread thread = new Thread(() -> printResult(content));
        thread.start();
    }

    private void printResult(String content){
        System.out.println("Количество слов: " + content.split(" ").length);
        System.out.println("Содержимое файла: " + content);
    }
}