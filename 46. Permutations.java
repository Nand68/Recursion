
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
