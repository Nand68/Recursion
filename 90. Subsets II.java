class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        check(0,nums,ds,ans);
        return ans;
    }
    public void check(int ind, int[] nums, List<Integer> ds , List<List<Integer>> ans ){

        ans.add(new ArrayList<>(ds)); 
        for(int i = ind;i<nums.length;i++) {
            if(i > ind && nums[i] == nums[i-1]) continue; 
            ds.add(nums[i]); 
            check(i+1, nums, ds, ans); 
            ds.remove(ds.size() - 1);
        }
    }
}
