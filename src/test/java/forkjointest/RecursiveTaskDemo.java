package forkjointest;
import java.util.concurrent.*;

public class RecursiveTaskDemo {

    private static class Fibonacci extends RecursiveTask<Integer> {

		private static final long serialVersionUID = 630834576702783702L;
		
		final int n;

        public Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }else {
                Fibonacci f1 = new Fibonacci(n - 1);
                f1.fork();
                Fibonacci f2 = new Fibonacci(n - 1);
                return f2.compute() + f1.join();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new Fibonacci(10));
        System.out.println(future.get());
        pool.shutdown();
    }

}