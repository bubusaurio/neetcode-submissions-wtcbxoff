class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check rows & columns
        for(int i = 0; i < 9; i++){
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();

            for(int j = 0; j < 9; j++){
                // Row check
                char r = board[i][j];
                if(r != '.'){
                    if(rows.contains(r)) return false;
                    rows.add(r);
                }

                // Column check
                char c = board[j][i];
                if(c != '.'){
                    if(cols.contains(c)) return false;
                    cols.add(c);
                }
            }
        }

        // Check 3x3 boxes
        for(int boxRow = 0; boxRow < 3; boxRow++){
            for(int boxCol = 0; boxCol < 3; boxCol++){
                Set<Character> box = new HashSet<>();

                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char val = board[boxRow * 3 + i][boxCol * 3 + j];
                        if(val != '.'){
                            if(box.contains(val)) return false;
                            box.add(val);
                        }
                    }
                }
            }
        }

        return true;
    }
}