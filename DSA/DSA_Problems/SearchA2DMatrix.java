class Solution {

    public boolean binarySearch(int[][] matrix, int target, int row, int start, int end){

        while(start<=end){
            int mid = (start+end)/2;

            if(matrix[row][mid] == target){
                return true;
            }
            else if(target < matrix[row][mid]){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return false;


    }
    public boolean searchMatrix(int[][] matrix, int target) {

        //no. of rows
        int m = matrix.length;

        //no. of columns
        int n = matrix[0].length;

        //starting row
        int startR = 0;
        //end row
        int endR = m - 1;

        //starting col
        int startC = 0;
        //end col
        int endC = n - 1;

        while(startR <= endR){
            int midR = (startR + endR)/2;

            if(matrix[midR][0] == target){
                return true;
            }
            else if(target > matrix[midR][0]){
                //target can be in this row
                if(binarySearch(matrix, target, midR, startC, endC)){
                    return true;
                }

                //or in lower rows
                startR = midR+1;
            }
            else{
                //target is in upper rows
                endR = midR-1;
            }
        }

        return false;

    }
}