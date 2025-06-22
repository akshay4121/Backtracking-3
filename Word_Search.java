/*
 * TC: O(N*(3^L)) ,N: no. of cells in board, L: length of the word
 * SC: O(L), L:length of the word worst case for the recursive stack
 * 
 * Approach: Implement recursion using backtracking, recursive call on each matching char from board as well the index on word.
 * At each recursion i will do bound check for row and col. base case would be if the idx become equals length of word. 
 */

class Solution {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        this.dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int m = board.length;
        int n = board[0].length;

        for(int i =0 ;i < m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                     if(helper(board, word, 0, i, j)) return true;
                }
            }
        }
     return false;   
    }

    private boolean helper(char[][] board,String word, int idx, int r, int c){
        //base
        if(idx == word.length()) return true;

        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;

        if(board[r][c] == word.charAt(idx)){
            board[r][c] = '#';
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(helper(board, word, idx +1, nr, nc)) return true;
            }
        board[r][c] = word.charAt(idx);
        }
    return false;
    }
}