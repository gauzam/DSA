class Solution {
    public int removeDuplicates(int[] arr) {

        if(arr.length == 1){
            return 1;
        }

        //where next unique element will go
        int k = 1;

        //current unique element
        int elem = arr[0];

        for(int j = 1; j < arr.length; j++){

            //if we find next unique element
            if(arr[j] != elem){
                arr[k] = arr[j];
                elem = arr[j];
                k++;
            }
        }

        //no. of unique elements in the array
        return k;

    }
}