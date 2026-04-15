class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;

        for(int i = 0 ; i<matrix.length ; i++){
            if(target >= matrix[i][0]){
                row = i;
            }

            if(target < matrix[i][0]){
                break;
            }
        }

        int left = 0;
        int right = matrix[row].length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] < target) left = mid + 1;
            else if(matrix[row][mid] > target) right = mid - 1;
            else{
                return true;
            }
        }

        return false;
    }
}
