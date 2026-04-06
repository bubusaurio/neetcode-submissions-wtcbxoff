class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i<tokens.length; i++){
            try{
                int n = Integer.parseInt(tokens[i]);
                stack.push(n);
            }catch(NumberFormatException e){
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch(tokens[i]){

                    case "*":
                        stack.push(n2*n1);
                        break;
                    
                    case "/":
                        stack.push(n2/n1);
                        break;

                    case "+":
                        stack.push(n2+n1);
                        break;
                    
                    case "-":
                        stack.push(n2-n1);
                        break;
                }
            }
        }

        return stack.pop();

    }
}
