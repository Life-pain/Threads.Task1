public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = new ThreadGroup("main group");
        System.out.println("Создаю потоки...");
        for (int i = 1; i < 5; i++) {
            new MyThread(mainGroup, String.valueOf(i)).start();
        }
        Thread.sleep(15000);
        System.out.println("Завершаю все потоки.");
        mainGroup.interrupt();
    }
}
