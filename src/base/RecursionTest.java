package base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bur on 2018/11/16.
 */
public class RecursionTest {
    public static void main(String[] args) {
        // there is a list [1, 2, 3, 4, 5]
        // print it as reverse order that don't use for loop
        int[] array = new int[] {1, 2, 3, 4, 5};
        printArray(array, 5);
        // user Collection.sort
        Integer[] array1 = new Integer[] {1, 2, 3, 4, 5};
        List<Integer> arrayList = Arrays.asList(array1);
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(arrayList);
    }

    public static void printArray(int[] array, int index) {
        if (index > 0) {
            System.out.println(array[index - 1]);
            printArray(array, index - 1);
        }
    }
}
