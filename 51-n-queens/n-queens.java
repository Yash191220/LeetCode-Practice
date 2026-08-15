class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        nQueens(board,0,allBoard);
        return allBoard;
    }

    public static void nQueens(char[][] board, int row, List<List<String>> allBoard){
        if(row == board.length){
            allBoard.add(construct(board));
            return;
        }

        for(int j=0; j<board.length; j++){
            if(isSafe(board,row, j)){
                board[row][j] = 'Q';
                nQueens(board,row+1,allBoard);
                board[row][j] = '.';
            }
        }
    }
    public static boolean isSafe(char[][] board, int row, int col){
        //verticle up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //diag left-up
        for(int i=row-1, j=col-1; i>=0&&j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //diag right-up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}