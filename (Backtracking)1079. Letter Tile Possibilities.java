class Solution {
    int n;
    public int numTilePossibilities(String tiles) {
        n = tiles.length();
        boolean[] used = new boolean[n];
        HashSet<String> set = new HashSet<>();
        backtrack(tiles,set,used,"");
        return set.size() - 1;
    }
    public void backtrack(String tiles, HashSet<String> set, boolean[] used, String cur){
        if (set.contains(cur)) return;
        set.add(cur);
        for(int i = 0; i < n; i++){
            if(used[i] == true){
                continue;
            }
            used[i] = true;
            backtrack(tiles,set,used,cur+tiles.charAt(i));
            used[i] = false;
        }
    }
}

// since we don't need to find string we just need count we can maintian freq array to solve

class Solution {
    int n;
    public int numTilePossibilities(String tiles) {
        n = tiles.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++){
            freq[tiles.charAt(i)-'A']++;
        }
        int count = backtrack(freq);
        return count;
    }
    public int backtrack(int[] freq){
        int count = 0;
        for ( int i = 0; i < 26; i++){
            if ( freq[i] == 0){
                continue;
            }
            count++;
            freq[i]--;
            count += backtrack(freq);
            freq[i]++;
        }
        return count;
    }
}

