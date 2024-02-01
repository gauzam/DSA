class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        //sorting the given array of arrays
        Arrays.sort(intervals, new Comparator<int[]> () {
            public int compare(int a[], int b[]){
                return a[0] - b[0];
            }

        });

        //initialising answer arraylist
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){

            //if the current interval doesn't lie in the last interval
            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)){

                //add interval to answer arraylist
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }

            //current interval lies in the last interval
            else{

                //accommodate current interval in the last interval by checking
                //max of second indices of both
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size()-1).get(1), intervals[i][1]));
            }

        }


        //creating a 2d array from the list of list
        int[][] intArray = new int[ans.size()][];

        for (int i = 0; i < ans.size(); i++) {
            intArray[i] = new int[ans.get(i).size()];
            for (int j = 0; j < ans.get(i).size(); j++) {
                intArray[i][j] = ans.get(i).get(j);
            }
        }

        return intArray;

    }
}