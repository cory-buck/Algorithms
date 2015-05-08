/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Set;

/**
 *
 * @author Cory Buck
 */
public class StringOperator {
    
    public static String reverse(String s){
        String temp = "";
        for(int i = s.length()-1; i >= 0; i--){
            temp += s.charAt(i);
        }
        return temp;
    }
    
    public static String reverseWords(String s){
        String temp = "";
        String temp2 = "";
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                if(temp2.length() > 0) temp += temp2 + " ";
                temp2 = "";
            }else{
                temp2 = s.charAt(i) + temp2;
            }
        }
        temp+= temp2;
        if(temp.length() > 0 && temp.charAt(temp.length()-1) == ' ') temp = temp.substring(0,temp.length()-1);
        return temp;
    }
    
    public static boolean allUniqueCharacters(String s){
        int l = s.length();
        for(int i = 0; i < l; i++){
            for(int j = 0; j < i; j++){
                if(s.charAt(j) == s.charAt(i) && i != j) return false;
            }
        }
        return true;
    }
    
    public static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        String t2 = s2;
        int l = s1.length();
        for(int i = 0; i < l; i++){
            for(int j = 0; j < t2.length(); j++){
                if(s1.charAt(i) == t2.charAt(j)){
                    if(t2.length() > 1 ){
                        t2 = t2.substring(0,j) + t2.substring(j+1,t2.length());
                    }else t2 = "";
                    break;
                }
            }
        }
        return t2.length() == 0;
    }
    
    public static boolean isPalindrome(String s){
        int l = s.length();
        for(int i = 0; i < l/2; i++){
            if(s.charAt(i) != s.charAt(l-1-i)) return false;
        }
        return true;        
    }
    
    public static boolean validPalindrome(String s){
        //leet code Accepted
        int start = 0;
        int end = s.length()-1;
        String alpha_num = "[a-zA-Z0-9]";
        
        while(start < end){
            while(!s.substring(start,start+1).matches(alpha_num) && start < end){
                start++;
            }
            while(!s.substring(end,end+1).matches(alpha_num) && end > start){
                end--;
            }
            if(!s.substring(start,start+1).equalsIgnoreCase(s.substring(end,end+1))){
                return false;
            }else{
                start ++;
                end--;
            }
        }
        
        return true;
    }
    
    public static int lengthOfLastWord(String s){
        //leet code accepted
        String temp = s;
        if(temp.length() == 0) return 0;
        while(!temp.substring(temp.length()-1,temp.length()).matches("[a-zA-Z]")){
            temp = temp.substring(0,temp.length()-1);
            if(temp.length()==0)return 0;
        }        
        int i = temp.length()-1;
        while(i != 0 && temp.substring(i-1,i).matches("[a-zA-Z]")){
            i--;
        }
        return temp.length() - i;
    }
    
    public static int titleToNumber(String s){
        //leet code accepted
        int num = 0;
        for(int i = 0; i < s.length();i++){
            int val = Character.getNumericValue(s.charAt(i))-9;
            num += val * Math.pow(26,s.length()-i-1);
        }
        return num;
    }
    
    public static int compareVersion(String version1, String version2){
        //leet code accepted
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < Math.max(v1.length,v2.length); i++){
            
            if(i < v1.length && i < v2.length){
                //full comparison
                if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                    return -1;
                }else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                    return 1;
                }
            }else if(i < v1.length){
                //v1 still going, just check for non-zeros
                if(Integer.parseInt(v1[i]) > 0) return 1;
            }else{
                //v2 still going, just check for non-zeros
                if(Integer.parseInt(v2[i]) > 0) return -1;
            }
        }
        return 0;
    }
    
}
