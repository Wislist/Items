package com.wilsit.schedule.test.多线程;

import java.util.concurrent.*;

class FibTask implements Callable<Integer> {
    private final int n;

    public FibTask(int n) {
        this.n = n;
    }

    @Override
    public Integer call() {
        if (n <= 1) {
            return n;
        } else {
            FibTask fibTask1 = new FibTask(n - 1);
            Future<Integer> future1 = FibExecutor.executor.submit(fibTask1);

            FibTask fibTask2 = new FibTask(n - 2);
            Future<Integer> future2 = FibExecutor.executor.submit(fibTask2);

            int result1, result2;
            try {
                result1 = future1.get();
                result2 = future2.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error while executing fib task", e);
            }

            return result1 + result2;
        }
    }
}

class FibExecutor {
    public static ExecutorService executor = Executors.newFixedThreadPool(8);
}

public class Demo01 {
    public static void main(String[] args) throws Exception {
        int n = 10;
        FibTask fibTask = new FibTask(n);
        Future<Integer> result = FibExecutor.executor.submit(fibTask);

        System.out.println("Calculating the " + n + "-th Fibonacci number...");
        int fibNumber = result.get();
        System.out.println("The " + n + "-th Fibonacci number is: " + fibNumber);
        FibExecutor.executor.shutdown();
    }
}