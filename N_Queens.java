/*
 * TC: O(n!) n: no. of rows.
 * SC: O(n*n) n" no. of rows. to store the boards and for recursive stack it would be linear.
 * 
 * Approach: Here i am checking at each place of the board if its safe to put the Q or not by checking its columns and diagonals for
 * presense of Q if it is , then return false and we cant place the queen at the particular place. perform backtracking. 
 * to store result, each time i reach the end of board i iterate through the board and build my list.
 */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(board,0,result);
        return result;
    }

    private void helper(boolean[][] board, int r,List<List<String>> result){
        //base
        if(r == board.length){
            List<String> li = new ArrayList<>();
            for(int i = 0; i < board.length ; i++){
             StringBuilder sb = new StringBuilder();
                for(int j =0; j< board.length ; j++){
                    if(board[i][j]) sb.append('Q');
                    else sb.append('.');
                }
             li.add(sb.toString());
            }   
        result.add(li);
        }

        //logic
        for(int c = 0; c < board.length; c++){
        if(isSafe(board, r, c)){
                    //action
                    board[r][c] = true;
                    //recurse
                    helper(board, r + 1,result);
                    //backtrack
                    board[r][c] = false;
                }
        }
        
    }


    private boolean isSafe(boolean[][] board, int r, int c){

        //column check
        for(int i = 0; i < r; i++){
            if(board[i][c]) return false;
        }

        //up left
        int i = r,j=c;
        while(i >=0 && j >=0){
            if(board[i][j]) return false;
            i--;j--;
        }

        //up right
        i = r-1;
        j = c+1;
        while(i>= 0 && j < board.length){
            if(board[i][j]) return false;
            i--;
            j++;
        }
    return true;
    }
}