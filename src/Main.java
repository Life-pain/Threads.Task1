public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup mainGroup = new ThreadGroup("main group");
        Thread thread1 = new MyThread(mainGroup, "1");
        Thread thread2 = new MyThread(mainGroup, "2");
        Thread thread3 = new MyThread(mainGroup, "3");
        Thread thread4 = new MyThread(mainGroup, "4");
        System.out.println("Создаю потоки...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        Thread.sleep(15000);
        System.out.println("Завершаю все потоки.");
        mainGroup.interrupt();
    }
}
