package DSA.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(arr);
        check(0,arr,8,ans,ds);
        System.out.println(ans);
    }
    private static void check(int index,int[] arr, int target,List<List<Integer>> ans , List<Integer> ds ){
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for ( int i = index; i < arr.length; i++){
            if ( i > index && arr[i] == arr[i-1]){
                continue;
            }
            if (arr[i] > target) break;
            ds.add(arr[i]);
            check(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }

}
