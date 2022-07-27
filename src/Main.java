import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Callable<Integer>> callableListForInvokeAny = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            callableListForInvokeAny.add(new MyCallable());
        }
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println("Результат самой быстрой = "
                + threadPool.invokeAny(callableListForInvokeAny));

        System.out.println("\nТеперь запускаем все задачи");
        MyCallable.resetNumber();       //обновляем счетчик потоков
        List<Future<Integer>> futureList = threadPool.invokeAll(callableListForInvokeAny);

        for (int i = 0; i < futureList.size(); i++) {
            System.out.printf("Поток №%d отработал %d раз\n", i + 1, futureList.get(i).get());
        }
        threadPool.shutdown();
    }
}
