class CustomStack {
    int[] eles; //用一个数组保存基本元素,右边为栈顶，最左端为栈底
    int top; //栈顶指针

    public CustomStack(int maxSize) {
        eles = new int[maxSize];
        top = 0;
    }

    public void push(int x) {
        if( top<eles.length ) eles[top++] = x;
    }

    public int pop() {
        if( top-1<0 ) return -1;
        int popEle = eles[top-1];
        top--;
        return popEle;
    }

    public void increment(int k, int val) {
        int length = k;
        if( top < k ) length=top; // 判断k是否大于当前栈容量
        for( int i=0; i<length; i++ ){
            eles[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */