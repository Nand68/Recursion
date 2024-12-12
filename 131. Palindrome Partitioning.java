class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        check(0,s,ans,ds);
        return ans;
    }

    public void check(int ind,String s, List<List<String>> ans , List<String> ds ){
        if ( ind == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for( int i = ind; i < s.length(); i++){
            if( pal(s,ind,i)){
                ds.add(s.substring(ind, i + 1));
                check(i+1,s,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    boolean pal(String s, int i, int ind){
        while ( i <= ind){
            if(s.charAt(i) == s.charAt(ind)){
                i++;
                ind--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
