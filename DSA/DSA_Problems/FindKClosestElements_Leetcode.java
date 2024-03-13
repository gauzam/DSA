class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        //getting the floor index
        int floorIndex = getFloorIndex(arr, x);

        List<Integer> ans = new ArrayList<>();

        //using two pointers to get the k closest elements
        int i = floorIndex;
        int j = floorIndex + 1;

        //while i and j are inbounds and k isnt exhausted
        while(k>0 && i>=0 && j < arr.length){

            //whoever has the lower diff means is closer to x and is added
            if(Math.abs(x-arr[i]) <= Math.abs(x-arr[j])){
                ans.add(arr[i]);
                k--;
                i--;
            }
            else{
                ans.add(arr[j]);
                k--;
                j++;
            }
        }

        //for cases when k hasn't exhausted but i or j have gone out of bounds
        while(k>0 && i>=0){
            ans.add(arr[i]);
            k--;
            i--;
        }

        while(k>0 && j<arr.length){
            ans.add(arr[j]);
            k--;
            j++;
        }

        //sort the arraylist
        Collections.sort(ans);

        return ans;
    }



    private int getFloorIndex(int arr[], int x){

        int start = 0;
        int end = arr.length - 1;

        int floorIndex = 0;

        while(start <= end){
            int mid = (start + end)/2;

            //we return either the index where the exact elem is kept
            if(arr[mid] == x){
                return mid;
            }
            else if(x < arr[mid]){
                end = mid-1;
            }

            //or the index where the elem lower to x is kept
            else{
                floorIndex = mid;
                start = mid+1;
            }
        }

        return floorIndex;
    }
}