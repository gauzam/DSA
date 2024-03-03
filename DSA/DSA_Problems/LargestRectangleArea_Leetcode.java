class Solution {
    public int largestRectangleArea(int[] heights) {

        //array containing indexes of nearest smaller elem to the left
        int nsl[] = new int[heights.length];

        //array containing indexes of nearest smaller elem to the right
        int nsr[] = new int[heights.length];

        Stack<Pair> stack = new Stack<>();

        for(int i = 0; i < heights.length; i++){
            if(stack.isEmpty()){
                nsl[i] = -1;
                stack.push(new Pair(heights[i], i));
                continue;
            }
            if(stack.peek().elem < heights[i]){
                nsl[i] = stack.peek().index;
            }
            else if(stack.peek().elem >= heights[i]){
                while(!stack.isEmpty() && stack.peek().elem >= heights[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    nsl[i] = -1;
                }
                else{
                    nsl[i] = stack.peek().index;
                }
            }

            stack.push(new Pair(heights[i], i));
        }

        //nsl array is ready

        stack.clear();

        for(int i = heights.length - 1; i >= 0; i--){
            if(stack.isEmpty()){
                nsr[i] = heights.length;
                stack.push(new Pair(heights[i], i));
                continue;
            }

            if(stack.peek().elem < heights[i]){
                nsr[i] = stack.peek().index;
            }
            else if(stack.peek().elem >= heights[i]){
                while(!stack.isEmpty() && stack.peek().elem >= heights[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    nsr[i] = heights.length;
                }
                else{
                    nsr[i] = stack.peek().index;
                }
            }

            stack.push(new Pair(heights[i], i));
        }

        //nsr array is ready

        int maxarea = Integer.MIN_VALUE;

        //to calculate area of max recatngle formed by an index
        for(int i = 0; i < heights.length; i++){
            int nslindex = nsl[i];
            int nsrindex = nsr[i];

            int width = (nsrindex - 1) - (nslindex + 1) + 1;
            int area = width * heights[i];

            maxarea = Math.max(area, maxarea);
        }

        return maxarea;

    }
}

class Pair{
    int elem;
    int index;

    public Pair(int elem, int index){
        this.elem = elem;
        this.index = index;
    }
}