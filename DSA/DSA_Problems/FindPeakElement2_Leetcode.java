class Solution {

    public int findMax(int[][] mat, int m, int n, int midCol){

        int maxRow = -1;
        int maxElem = -1;

        for(int i = 0; i<m; i++){
            if(mat[i][midCol] > maxElem){
                maxElem = mat[i][midCol];
                maxRow = i;
            }
        }

        return maxRow;

    }



    public int[] findPeakGrid(int[][] mat) {

        //no. of rows
        int m = mat.length;

        //no. of columns 
        int n = mat[0].length;

        int start = 0;
        int end = n - 1;

        while(start <= end){
            int midCol = (start+end)/2;

            int maxElemRow = findMax(mat, m, n, midCol);

            int left = -1;
            int right = -1;

            if(midCol > 0){
                //if left exists, find it's value
                left = mat[maxElemRow][midCol-1];
            }
            if(midCol < n-1){
                //if right exists, find it's value
                right = mat[maxElemRow][midCol+1];
            }

            if(mat[maxElemRow][midCol] > left && mat[maxElemRow][midCol] > right){
                //if current elem is greater than both left and right
                //its a peak element
                int ans[] = {maxElemRow, midCol};
                return ans;
            }
            else if (mat[maxElemRow][midCol] < left){
                //if left is greater, we move towards that half
                end = midCol - 1;
            }
            else{
                //for all other cases, we move towards right half
                start = midCol + 1;
            }
        }

        //dummy return statement
        int ans[] = {-1,-1};
        return ans;

    }
}