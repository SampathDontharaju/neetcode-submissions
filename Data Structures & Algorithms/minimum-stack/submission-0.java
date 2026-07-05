class MinStack {
   List<Integer> stack;
    public MinStack() {
        stack = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        
        if(stack.size()==0){
            stack.add(val);
            stack.add(val);
        }else{
            int size = stack.size();
            int min = Math.min(stack.get(size-1), val);
            stack.add(val);
            stack.add(min);
        }

    }
    
    public void pop() {
        
        int size = stack.size();
        stack.remove(size-1);
        stack.remove(size-2);
    }
    
    public int top() {
        int size = stack.size();
        return stack.get(size-2);
    }
    
    public int getMin() {
        int size = stack.size();
        return stack.get(size-1);
    }
}
