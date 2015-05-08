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
public class LinkedListOperator {
    
    //listnode class used in algorithmns
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }
    
    public static ListNode removeNthLastNode(ListNode head, int n){
        //n must always be valid
        ListNode temp = head;
        ListNode temp2 = temp;
        ListNode temp3;
        boolean found = false;
        while(temp2 != null){
            temp3 = temp2;
            for(int i = 0; i < n; i++){
                System.out.println("i:"+i);
                if(temp3 != null) temp3 = temp3.next;
                else{
                    
                    found = true;
                    break;
                }
            }
            if(found){
                temp2.next = temp2.next.next;
                break;
            }else{
                temp2 = temp2.next;
            }
            
        }
        return temp;
        
    }
    
    public static ListNode removeDuplicates(ListNode head){
        //leet code approved
        //Given a sorted linked list, 
        //delete all duplicates such that 
        //each element appear only once.
        ListNode temp = head;
        while(temp != null){
            while(temp.next != null && temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
    
    
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp1 = head;
        ListNode temp2, temp3 = null;
        while(temp1 != null){
            temp2 = new ListNode(temp1.val);
            temp2.next = temp3;
            temp3 = temp2;
            temp1 = temp1.next;
        } 
        return temp3;
    }
    
    public static ListNode removeElement(ListNode head, int val){
        if(head == null ) return head;
        ListNode temp1 = head;
        while(temp1.val == val){
            temp1 = temp1.next;
            if(temp1 == null) return temp1;
        }
        ListNode temp2 = temp1;
        
        while(temp2 != null && temp2.next != null){
            while(temp2.next.val == val ){
                temp2.next = temp2.next.next;
                if(temp2.next == null) break;
            }
            temp2 = temp2.next;
        }
        return temp1;
    }
    

    
    public static void printList(ListNode head){
        System.out.println("---------List Node Log--------");
        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("---------End List Node Log------");
    }
    
    
}
