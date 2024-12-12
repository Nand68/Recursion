
class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        
        ArrayList<String> list = new ArrayList<>();
        boolean [][]visited = new boolean [mat.size()][mat.size()];
        helper(0, 0, mat, list, visited, "");
        return list;
        
    }
    
    private void helper(int row, int col, ArrayList<ArrayList<Integer>> board, ArrayList<String> list, boolean [][]visited, String psf){
        
        if(row < 0 || row == board.size() || col < 0 || col == board.size() || board.get(row).get(col) == 0 || visited[row][col]){
            return;
        }
        
        if(row == board.size() - 1 && col == board.size() - 1){
            list.add(psf);
        }
        
        visited[row][col] = true;
        
        // down
        helper(row + 1, col, board, list, visited, psf + "D");
        
        // left
        helper(row, col - 1, board, list, visited, psf + "L");
        
        // right
        helper(row, col + 1, board, list, visited, psf + "R");
        
        // up
        helper(row - 1, col, board, list, visited, psf + "U");
        
        visited[row][col] = false;
        
    }
    
}
