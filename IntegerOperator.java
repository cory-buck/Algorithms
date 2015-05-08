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
public class IntegerOperator {

    
    public static int countPrimes(int n){
        //leet code accepted
        if(n == 0 || n == 1 || n == 2) return 0;
        int count = 1;
        boolean prime;
        int ub;
        for(int i = 3; i < n; i += 2){
            ub = (int)Math.sqrt(i);
            prime = true;
            for(int j = 3; j <= ub; j+=2){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime)count++;
        }
        return count;
    }
    
    public static int reverse(int x) {
        //leet code accepted
        if(x > -10 && x < 10) return x;
        else{
            String temp = "";
            String temp2 = Integer.toString(x);
            if(x < 0){
                for(int i = temp2.length()-1; i >0; i--){
                    temp += temp2.charAt(i);
                }
                temp = "-" + temp;
            }else{
                for(int i = temp2.length()-1; i >= 0; i--){
                    temp += temp2.charAt(i);
                }
            }
            try{
                return Integer.parseInt(temp);
            }catch(NumberFormatException e){ return 0;}
        }
    }
    
    public static boolean isPalindrome(int x){
        //leet code accepted
        if(x < 0) return false;
        for(int i = 0; i < Integer.toString(x).length();i++){
            if(Integer.toString(x).charAt(i) != Integer.toString(x).charAt(Integer.toString(x).length() - 1 -i)){
                return false;
            }
        }        
        return true;
    }
    
    public static boolean isHappy(int n){
        //leet code accepted
        if(n < 0) return false;
        int num = n;
        int loop_count = 0;
        String temp;
        while(loop_count != 1000){
            temp = Integer.toString(num);
            num = 0;
            for(int i = 0; i < temp.length(); i++){
                num += Math.pow(Integer.parseInt(temp.substring(i,i+1)), 2);
            }
            if(num == 1) return true;
            loop_count++;
        }
        return false;
    }
    
    
    
    public static String countAndSay(int n){
        // leet code accepted
        if(n == 1) return "1";
        String temp = "1";
        String temp2;
        int curr_num;
        int curr_count;
        for(int j = 0; j < n - 1; j++){
            temp2 = "";
            curr_num = -1;
            curr_count = 1;
            for(int i = 0; i < temp.length(); i++){
                if(curr_num == -1){
                    curr_num = Integer.parseInt(temp.substring(i,i+1));
                }else if(Integer.parseInt(temp.substring(i,i+1)) != curr_num){
                    temp2 += Integer.toString(curr_count) + Integer.toString(curr_num);
                    curr_num = Integer.parseInt(temp.substring(i,i+1));
                    curr_count = 1;
                }else{
                    curr_count++;
                }
            }
            temp = temp2 + Integer.toString(curr_count) + Integer.toString(curr_num);
        }
        return temp;
    }
    
    public static String convertToTitle(int n){
        //incorrect output
        //Given a positive integer, 
        //return its corresponding column 
        //title as appear in an Excel sheet.
        if(n == 1) return "A";
        String conversion = "";
        int next_char;
        int i = n / 26;
        while(i > 0){
            next_char = n % 26;
            if(next_char == 0) conversion = ((char)(90)) + conversion;
            else conversion = ((char)(next_char + 64)) + conversion;
            
            n  = n / 26;
            System.out.println(next_char + " : " + n);
            i--;
        }
        return conversion;
    }


}
