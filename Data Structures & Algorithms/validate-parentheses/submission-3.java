class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        if(s.length() == 0){
            return true;
        }

        if(s.length() % 2 != 0){
            return false;
        }

        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        for(char c : s.toCharArray()){
            if(!stack.isEmpty()){
                switch(c){
                    case ')':
                        if(stack.pop() != '(') return false;
                        break;
                    
                    case ']':
                        if(stack.pop() != '[') return false;
                        break;

                    case '}':
                        if(stack.pop() != '{') return false;
                        break;
                }
            }

            if(c == '(' || c == '[' || c == '{') stack.push(c);
        }

        return stack.isEmpty();
    }
}
