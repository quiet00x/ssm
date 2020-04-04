package forkjointest;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskDemo {

    private class SumTask extends RecursiveTask<Integer> {

		private static final long serialVersionUID = 7417172129335860493L;

		// 临界值
		private static final int THRESHOLD = 20;

        private int arr[];
        private int start;
        private int end;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        /**
         * 小计
         */
        private Integer subtotal() {
            Integer sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            System.out.println(Thread.currentThread().getName() + ": ∑(" + start + "~" + end + ")=" + sum);
            return sum;
        }

        @Override
        protected Integer compute() {

            if ((end - start) <= THRESHOLD) {
                return subtotal();
            }else {
                int middle = (start + end) / 2;
                SumTask left = new SumTask(arr, start, middle);
                SumTask right = new SumTask(arr, middle, end);
                left.fork();
                right.fork();

                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[5000];
        for (int i = 0; i < 5000; i++) {
            arr[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> result = pool.submit(new ForkJoinTaskDemo().new SumTask(arr, 0, arr.length));
        System.out.println("最终计算结果: " + result.invoke());
        pool.shutdown();
    }

}