class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i = 0; i<temperatures.length; i++){
            int currentValue = temperatures[i];
            
            while(!stack.isEmpty() && temperatures[stack.peek()] < currentValue){
                int prevValueIndex = stack.pop();
                result[prevValueIndex] = i - prevValueIndex;
            }
            stack.push(i);
        }

        return result;

    }
}
