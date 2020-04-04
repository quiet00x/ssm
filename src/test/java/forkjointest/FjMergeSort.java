package forkjointest;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
/**
 * 利用ForkJoin实现数组
 * 并行排序
 * @author Preciousness
 *
 */
public class FjMergeSort {

    private static class SortAction extends RecursiveAction {

		private static final long serialVersionUID = 601416474878460487L;
		
		private int[] arr;
        private int left;
        private int mid;
        private int right;

        public SortAction(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left < right) {
                mid = (left + right) / 2;
                SortAction leftAction = new SortAction(arr, left, mid);
                SortAction rightAction = new SortAction(arr, mid + 1, right);
                // 调用两个
                invokeAll(leftAction, rightAction);
                mergetArr(arr, left, mid, right);
            }
        }

        private void mergetArr(int[] arr, int left, int mid, int right) {
            int[] temp = new int[arr.length];
            int p1 = left, p2 = mid + 1, index = left;

            while (p1 <= mid && p2 <= right) {
                if (arr[p1] <= arr[p2]) {
                    temp[index++] = arr[p1++];
                } else {
                    temp[index++] = arr[p2++];
                }
            }

            while (p1 <= mid) temp[index++] = arr[p1++];
            while (p2 <= right) temp[index++] = arr[p2++];

            for (int i = left; i <= right ; i++) {
                arr[i] = temp[i];
            }
        }
    }


    public static void main(String[] args) {

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SortAction sortAction = new SortAction(arr, 0, arr.length - 1);
        forkJoinPool.submit(sortAction);

        sortAction.join();  //阻塞

        System.out.println(Arrays.toString(arr));
    }
}
