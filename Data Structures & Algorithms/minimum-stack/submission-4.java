class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if(this.minStack.isEmpty()){
            this.minStack.push(val);
        }else
        if(val <= this.minStack.peek()){
            this.minStack.push(val);
        }
    }
    
    public void pop() {
        int value = this.stack.pop();

        if(value == this.minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
