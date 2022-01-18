package com.gaurav.learnandgrow.list;

import java.util.List;

/**
 * Source: https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.setNext(new ListNode(4));
        l1.getNext().setNext(new ListNode(3));

        ListNode l2 = new ListNode(5);
        l2.setNext(new ListNode(6));
        l2.getNext().setNext(new ListNode(4));

        ListNode r = addTwoNumbers(l1,l2);
        while (r!=null) {
            System.out.println(r.getVal());
            r=r.getNext();
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rNode = new ListNode();
        ListNode cNode = rNode;
        int carry = 0;

        while(l1!=null || l2!=null) {

            int sum = 0;
            if(l1!=null) {
                sum = sum+l1.getVal();
                l1=l1.getNext();
            }
            if(l2!=null) {
                sum = sum+l2.getVal();
                l2=l2.getNext();
            }
            sum = sum+carry;
            int unitDigit = sum % 10;
            carry = sum/10;

            cNode.setNext(new ListNode(unitDigit));
            cNode = cNode.getNext();

        }
        if (carry > 0) {
            cNode.setNext(new ListNode(carry));
        }
        return rNode.getNext();
    }
}
