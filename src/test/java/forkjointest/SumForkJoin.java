package forkjointest;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumForkJoin {


    private static class SumTask extends RecursiveTask<Integer> {

		private static final long serialVersionUID = 1868394883503437989L;

		private int threshold = 10;

        private int[] arr;
        private int start;
        private int end;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if ( end - start < threshold) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {
                SumTask left = new SumTask(arr, start, (start + end) / 2);
                SumTask right = new SumTask(arr,  (start + end) / 2 +1, end);
                invokeAll(left, right);
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 初始化一个数组
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }


        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask sumTask = new SumTask(arr, 0, arr.length-1);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(sumTask);
        Integer integer = submit.get();
        long end = System.currentTimeMillis();
        System.out.println("多线程版本计算结果：" +integer + ",计算耗时:" + (end - start) + "ms")  ;

        start = System.currentTimeMillis();
        int result = Arrays.stream(arr).reduce((a, b) -> a + b).getAsInt();
        end = System.currentTimeMillis();
        System.out.println("单线程版本计算结果：" + +result + ",计算耗时:" + (end - start) + "ms");
    }

}
