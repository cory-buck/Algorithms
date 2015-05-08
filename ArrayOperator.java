/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Cory Buck
 */
public class ArrayOperator {
    public static int[] rotate(int[] nums, int k){
        //leet code accepted
        if(nums.length < 2) return nums;
        int temp;
        int size = nums.length;
        int rotations = k % size;
        for(int i = 0; i < rotations; i++){
            temp = nums[size-1];
            System.arraycopy(nums,0,nums,1,size-1);
            nums[0] = temp;
        }
        return nums;
    }
    
    public static int[] plusOne(int[] digits){
        //leet code accepted
        int num = 1;
        for(int i = digits.length-1; i >= 0; i--){
            int temp = digits[i];
            digits[i] = (temp + num) % 10;
            num = (temp + num) / 10;
        }
        if(num != 0){
            int[] temp = new int[digits.length + 1];
            temp[0] = num;
            for(int i = 0; i < digits.length; i++){
                temp[i+1] = digits[i];
            }
            return temp;
        }
        return digits;
    }
    
    
    public static int[] twoSum(int[] nums, int target){
        //leet code accepted
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{(i + 1), (j + 1)};
                }
            }
        }
        return new int[]{};
    }
    
    public static int majorityElement(int[] nums){
        //too slow
        int majority_element;
        int occurences;
        int length = nums.length;
        int max = length/2;
        for(int i = 0; i < length; i++){
            majority_element = nums[i];
            occurences = 0;
            for(int j = 0; j < length; j++){
                if(nums[j] == majority_element) occurences++;
                if(occurences > max) return majority_element;
            }            
        }
        return 0;
    }
    
    public static void print(int[] nums){
        for(int i = 0; i < nums.length; i ++){
            System.out.println(nums[i]);
        }
        System.out.println("\n");
    }
}
