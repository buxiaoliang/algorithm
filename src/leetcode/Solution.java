package leetcode;

import java.util.*;

/**
 * Created by bur on 2018/9/20.
 */
public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        // use quick sort to sort arrays
        Arrays.sort(A);
        // give max difference
        int result = A[N - 1] - A[0];
        return result;
    }

    public static void main(String[] args) {
        int[] a = {-1, 2, 8, 0, 2, 1};
        Solution sl = new Solution();
        System.out.println(sl.solution(a));
    }

}
