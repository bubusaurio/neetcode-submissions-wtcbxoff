class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int maxWater = 0;

        while(start < end){
            int startHeight = heights[start];
            int endHeight = heights[end];
            int boundHeight = Math.min(startHeight, endHeight);
            int width = end - start;
            int water = boundHeight * width;
            maxWater = Math.max(maxWater, water);


            if(startHeight >= endHeight){
                end--;
            }else if(startHeight < endHeight){
                start++;
            }
        }

        return maxWater;
    }
}
