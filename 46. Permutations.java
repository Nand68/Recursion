// approach - 1
class Solution {
    private void recurPermute(List<Integer> ds, int[] nums, List<List<Integer>> ans, int[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == 0) {
                ds.add(nums[i]);
                freq[i] = 1;
                recurPermute(ds, nums, ans, freq);
                freq[i] = 0;
                ds.remove(ds.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int[] freq = new int[nums.length];
        for (int i = 0; i < nums.length; i++) freq[i] = 0;
        recurPermute(ds, nums, ans, freq);
        return ans;
    }
}

// approach - 2

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List < List < Integer >> ans = new ArrayList < > ();
        check(0,nums,ans);
        return ans;
    }
    private void check(int ind, int[] nums,List<List<Integer>> ans){
        if ( ind == nums.length){
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
        for ( int i = ind; i < nums.length; i++){
            swap(i,ind,nums);
            check(ind+1,nums,ans);
            swap(i,ind,nums);  
        }
    }
    public void swap(int i , int ind,int[] nums){
            int temp = nums[i];
            nums[i] = nums[ind];
            nums[ind] = temp;
    }
}
