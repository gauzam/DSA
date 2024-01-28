class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int ans[] = new int[nums.length-k+1];

        //deque storing indices in decreasing order
        Deque<Integer> deque = new ArrayDeque<>();

        //to iterate over answer array
        int j = 0;

        for(int i = 0; i < nums.length; i++){

            //removing index that is out of bound
            if(!deque.isEmpty() && deque.peek() == i-k){
                deque.removeFirst();
            }

            //removing smaller numbers from our window as they are useless
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.removeLast();
            }

            //pushing current index into the last of deque
            deque.addLast(i);

            //when window size is reached, we start filling the answer array
            if(i >= k-1){
                ans[j] = nums[deque.peek()];
                j++;
            }

        }

        return ans;
    }
}