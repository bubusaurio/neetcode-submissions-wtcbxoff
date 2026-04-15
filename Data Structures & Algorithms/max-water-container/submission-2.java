class Solution {
    public int maxArea(int[] height) {

        if(height == null || height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while(left<right){
            int boundHeight = Math.min(height[left], height[right]);
            int area = boundHeight * (right - left);

            maxArea = Math.max(maxArea, area);

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}