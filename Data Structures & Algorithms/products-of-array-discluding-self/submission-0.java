class Solution {
    public int[] productExceptSelf(int[] nums) {
        int res = 1;
        int resNoZero = 1;
        int[] products = new int[nums.length];
        int zeroes = 0;

        for(int num : nums){
            res *= num;
            if(num != 0) resNoZero *= num;
            else{
                zeroes++;
            }
        }

        if(zeroes >= 2){
            return products;
        }

        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != 0) products[i] = res / nums[i];
            else{
                products[i] = resNoZero;
            }
        }

        return products;
    }
}  
