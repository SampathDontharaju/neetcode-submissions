class MedianFinder {

    List<Double> nums;
    public MedianFinder() {
       nums = new ArrayList<Double>();
    }
    
    public void addNum(int num) {
        nums.add(Double.valueOf(num));
        Collections.sort(nums);
    }
    
    public double findMedian() {

        if(nums.size()%2==1){
            int v = nums.size()/2;
            return v>0?  nums.get(nums.size()/2) : nums.get(0);
        }else{
            return (nums.get(nums.size()/2-1) + nums.get(nums.size()/2))/2;
        }
    }
}
