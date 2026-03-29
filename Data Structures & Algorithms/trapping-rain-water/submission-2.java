class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxHeightLeft = 0;
        int maxHeightRight = 0;
        int totalWater = 0;

        while(start<end){
            int startHeight = height[start];
            int endHeight = height[end];

            if(startHeight <= endHeight){
                maxHeightLeft = Math.max(maxHeightLeft, startHeight);
                totalWater += maxHeightLeft - startHeight;
                start++;
            }else{
                maxHeightRight = Math.max(maxHeightRight, endHeight);
                totalWater += maxHeightRight - endHeight;
                end--;
            }
        }

        return totalWater;

    }
}
