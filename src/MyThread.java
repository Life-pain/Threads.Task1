public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.printf("Я поток %s. Всем привет!\n", getName());
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.printf("Поток %s завершен\n", getName());
        }
    }
}
