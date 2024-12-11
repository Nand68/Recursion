// approach - 1
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List < List < String >> res = new ArrayList < > ();
        dfs(0, board, res);
        return res;
    }
    static boolean validate(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }

    static void dfs(int col, char[][] board, List < List < String >> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }



    static List < String > construct(char[][] board) {
        List < String > res = new LinkedList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}


// approach - 2

class Solution {

    public void NQueens(int col,String[][] board,int n, int[] leftRow, int[] upDia, int[] downDia, List<List<String>> ans)
    {
        
        if(col == n)
        {
            List<String> li = new ArrayList<>();
            
            for(int i=0;i<n;i++) {
                StringBuilder row = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    row.append(board[i][j]);
                }
                li.add(row.toString());
            }
            
            ans.add(new ArrayList<>(li));
            return;
        }

        for(int row=0;row<n;row++)
        {
            if(leftRow[row]==0 && upDia[(n-1)+(col-row)]==0 && downDia[row+col]==0)
            {
                board[row][col] = "Q";
                leftRow[row]=1;
                upDia[(n-1)+(col-row)]=1;
                downDia[row+col]=1;
                NQueens(col+1,board,n,leftRow,upDia,downDia,ans);
                board[row][col] = ".";
                leftRow[row]=0;
                upDia[(n-1)+(col-row)]=0;
                downDia[row+col]=0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        String [][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        List<List<String>> ans = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upDia = new int[2*n-1];
        int[] downDia = new int[2*n-1];
        NQueens(0,board,n,leftRow,upDia,downDia,ans);
        return ans;
    }
}
