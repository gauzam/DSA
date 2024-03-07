class Solution {
    public int romanToInt(String s) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            //getting the char at i
            char c = s.charAt(i);

            //if stack is empty, get the number and simply push in the stack
            if(stack.isEmpty()){
                int x = getChar(c);
                stack.push(x);
                continue;
            }

            else{
                //stack isnt empty

                //check for all 6 cases where number can change 
                //this is mentioned in the ques
                if(c == 'V' && stack.peek() == 1){
                    stack.pop();
                    stack.push(4);
                    continue;
                }
                if(c == 'X' && stack.peek() == 1){
                    stack.pop();
                    stack.push(9);
                    continue;
                }
                if(c == 'L' && stack.peek() == 10){
                    stack.pop();
                    stack.push(40);
                    continue;
                }
                if(c == 'C' && stack.peek() == 10){
                    stack.pop();
                    stack.push(90);
                    continue;
                }
                if(c == 'D' && stack.peek() == 100){
                    stack.pop();
                    stack.push(400);
                    continue;
                }
                if(c == 'M' && stack.peek() == 100){
                    stack.pop();
                    stack.push(900);
                    continue;
                }

                //if it is not for the 6 cases,
                //simply get the number and push it into the stack
                stack.push(getChar(c));
            }

        }

        int sum = 0;

        //all the numbers are popped out and added to answer variable
        while(!stack.isEmpty()){
            sum = sum + stack.pop();
        }

        return sum;

    }

    public int getChar(char c){

        //this is given in the ques 
        if(c == 'I'){
            return 1;
        }
        if(c == 'V'){
            return 5;
        }
        if(c == 'X'){
            return 10;
        }
        if(c == 'L'){
            return 50;
        }
        if(c == 'C'){
            return 100;
        }
        if(c == 'D'){
            return 500;
        }
        if(c == 'M'){
            return 1000;
        }

        return -1;

    }
}