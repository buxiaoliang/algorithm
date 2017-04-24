package sorting;

/**
 * Created by bu on 4/10/2017.
 */
public class Sorting {

    /**
     * 直接插入排序
     * 思想：每次将一个待排序的记录，按其关键字大小插入到前面已经排好序的子序列中，直到全部记录插入完成。
     * 性能：时间复杂度：最好o(n)：有序，最坏o(n^2)：逆序,平均o(n^2)；空间复杂度o(1)；稳定
     *
     * @param array
     * @return
     */
    public int[] straightInsertSort(int array[]) {
        int temp;
        for (int i = 1; i < array.length; i++) { //依次对1到array.length-1个元素进行处理
            temp = array[i];
            for (int j = 0; j < i; j++) {  //已排好序的0到i-1个元素
                if (temp < array[j]) {  //插入位置j
                    for (int k = i - 1; k >= j; k--) {  //将j到i-1个元素向后移一个位置
                        array[k + 1] = array[k];  //此时array[i]为已排好序的子数组中的最大值
                    }
                    array[j] = temp;  //将第i个元素插入到位置j上
                    break;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序
     * 思想：对于待排序表，从前往后两两比较相邻元素的值，若为逆序，则交换，直到序列比较完成。如此，每次冒泡即可得到当前待排表中的最大元素，并已放置在相应的位置。
     * 性能：时间复杂度：最好o(n)有序，最坏o(n^2)逆序,平均o(n^2)，空间复杂度o(1)，稳定
     *
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {
        boolean flag = false; //用来标记该序列是否已是有序
        for (int i = 0; i < array.length - 1; i++) { //做n-1趟冒泡
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;  //有元素交换，则该序列初始状况不是有序的
                }
            }
            if (flag == false) {  //本趟遍历后没有发生交换，说明表已经有序
                return array;
            }
        }
        return array;
    }

    // 快速排序
    public static void quickSort(int[] arr) {
        qsort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     * 思想：基于分治的思想：在待排序表中任取一个元素pivot作为基准，通过一趟排序将待排序表划分为独立的两部分，使得一部分中所有元素小于等于pivot，另一部分中所有元素大于pivot，则pivot放在了其最终位置上，这个过程称为一趟快速排序。而后递归地对两个子表重复上述过程，直到每部分内只有一个元素或空为止。
     * 性能： 空间复杂度：需要递归工作栈：最坏o(n)，平均o(logn)
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static void qsort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }

    /**
     * 简单选择排序
     * 思想：假设排序表array[0,...,n-1]，第 i 趟排序即从array[0,...,n-1]中选择关键字最小的元素与array[i]交换，每一趟排序可以确定一个元素的最终位置，这样经过n-1趟派克就可以使整个序列有序。
     * 性能：时间复杂度：o(n^2)，空间复杂度o(1)，不稳定
     *
     * @param array
     * @return
     */
    public int[] simpleSelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {  //一共进行n-1趟
            int min = i;  //记录最小元素位置
            for (int j = i + 1; j < array.length; j++) { //在array[i，...，n-1]中选择最小的元素
                if (array[j] < array[min]) {
                    min = j;   //更新最小元素的位置
                }
            }
            int temp = array[i];  //将最小元素与第i个位置交换
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
