class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

        //answer array
        int ans[] = new int[2];

        int repeating = -1;
        int missing  = -1;

        long arraySum = 0;

        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                //repeating element is found
                repeating = arr[i];
                //placing repeat elem
                ans[0] = repeating;
            }
            else{
                map.put(arr[i], 1);
            }

            //calculating array sum
            arraySum = arraySum + arr[i];
        }

        //sum of n natural numbers
        long correctSum = ((n)*(n+1))/2;

        //subtracting repeating element from arraySum
        arraySum = arraySum - repeating;

        //RHS gives missing element but in 'long', so typecasting to int
        missing = (int)(correctSum - arraySum);

        //placing missing elem
        ans[1] = missing;

        return ans;

    }
}