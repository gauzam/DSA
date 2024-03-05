class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++){
            if(stack.isEmpty()){
                stack.push(asteroids[i]);
                continue;
            }

            if(stack.peek() > 0 && asteroids[i] < 0){

                //collision will happen

                //stack top wins the collision
                if(stack.peek() > Math.abs(asteroids[i])){
                    continue;
                }

                //new asteroid wins the collision so we pop the stack top and check again
                else if(stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();
                    i--;
                }

                //both are same and both are destroyed
                else{
                    stack.pop();
                    //we wont push the current asteroid and remove the stack top asteroid
                }

            }
            else{
                stack.push(asteroids[i]);
            }

        }

        int ans[] = new int[stack.size()];

        for(int i = stack.size() - 1; i >= 0; i--){
            ans[i] = stack.pop();
        }

        return ans;
    }
}