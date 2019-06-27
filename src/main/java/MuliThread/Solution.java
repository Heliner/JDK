package MuliThread;

import java.util.*;

public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[]{0, 0};
        int i = 0;

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.replace(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    res[i++] = num;
                }
                map.remove(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( Arrays.toString(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));;
    }
}