package MuliThread;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    boolean[] used ;
    List<List<Integer>> res;
    void generatePermutation(int[] nums, int index, List<Integer> p) {
        List<Integer> resList = new LinkedList<>();

        if (index == nums.length) {
        resList.addAll(p);
            res.add(resList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutation(nums, index + 1, p);
                used[i] = false;
                p.remove(p.size()-1);
            }
        }
    }
    List<List<Integer>> permute(int[] nums){
        res= new LinkedList<>();
        if(nums.length == 0)
            return res;
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        List<Integer> saveNums = new LinkedList<>();
        generatePermutation(nums,0,saveNums);
        return res;
    }
    @Test
    public void test(){
        Main main = new Main();
        main.permute(new int[]{1,2,3}).forEach(System.out::println);

    }
}
