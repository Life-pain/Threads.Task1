import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> myCallable1 = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();
        Callable<Integer> myCallable4 = new MyCallable();
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Callable<Integer>> callableList =
                new ArrayList<>(Arrays.asList(myCallable1, myCallable2, myCallable3, myCallable4));

        System.out.println(threadPool.invokeAny(callableList));
        threadPool.shutdown();
    }
}
