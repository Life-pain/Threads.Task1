import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private static int nameNumber = 0;

    @Override
    public Integer call() {
        int result = 0;
        Thread.currentThread().setName(String.valueOf(++nameNumber));
        try {
            while (result < 2 + (int) (Math.random() * 6)) {
                Thread.sleep(2000);
                System.out.printf("Я поток %s. Всем привет!\n", Thread.currentThread().getName());
                result++;
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.printf("Поток %s завершен\n", Thread.currentThread().getName());
        }
        return result;
    }

    public static void resetNumber() {
        nameNumber = 0;
    }
}
