class Solution {
    public void setZeroes(int[][] matrix) {

        //first queue to store index i's where zero occurs
        Queue<Integer> queuei = new LinkedList<>();
        //second queue to store index j's where zero occurs
        Queue<Integer> queuej = new LinkedList<>();

        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queuei.add(i);
                    queuej.add(j);
                }
            }
        }

        //for all noted rows to be zero, we keep i constant 
        //and iterate over its columns to make them zero
        while(!queuei.isEmpty()){
            int i = queuei.remove();
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = 0;
            }
        }

        //for all noted columns to be zero, we keep j constant 
        //and iterate over its rows to make them zero
        while(!queuej.isEmpty()){
            int j = queuej.remove();
            for(int i = 0; i<matrix.length; i++){
                matrix[i][j] = 0;
            }
        }

        return;
    }
}