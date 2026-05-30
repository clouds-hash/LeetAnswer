import java.util.Arrays;

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        MaxHeap215 heap=new MaxHeap215(nums);
        //传入nums就改变了 引用传参
        //我建立的是大顶堆 那么arr[0] 就是最大的
        int max=nums[0];
        for(int i=0;i<k;i++){
            max=heap.pop();
        }
        return max;
    }
    
    public int findKthLargest2(int[] nums, int k) {
        //方法二
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

class MaxHeap215{
    private int[] arr;
    private int size;
    private int count;

    public MaxHeap215(int size){
        arr = new int[size];
        this.size = size;
        count = 0;
    }

    public MaxHeap215(int[] arr){
        this.arr=arr;
        size=arr.length;
        count=arr.length;
        //建堆 heapify
        heapify();
    }
    public void heapify(){
        //佛洛依德建堆法
        //最后一个非叶子节点
        int last=count/2 -1;
        for(int i=last;i>=0;i--){
            down(i);
        }
        return;
    }
    public void down(int i){
        //下沉操作 对下标为i的元素进行下沉
        int max=i;//假设i是最大的
        //比较左右孩子
        int left=i*2+1;
        int right=left+1;
        if(left<count && arr[left]>arr[max]) max=left;
        if(right<count && arr[right]>arr[max]) max=right;
        if(max==i) return;
        swap(i,max);
        down(max);
    }
    private void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void push(int value){
        if(isFull()) return;
        arr[count] =value;
        count++;
        up(count-1);
        return;
    }
    public int pop(){
        if(isEmpty()) return -1;
        int removed=arr[0];
        swap(0,count-1);
        count--;
        down(0);
        return removed;
    }
    public int peek(){
        if(isEmpty()) return -1;
        return arr[0];
    }

    public void up(int i){
        int parent = (i-1)/2;
        if(parent<0) return;
        if(arr[i] > arr[parent]){
            swap(i, parent);
            up(parent);
        }
        return;
    }

    public boolean isEmpty(){
        return count == 0;
    }
    public boolean isFull(){
        return count == size;
    }
}