package com.gaurav.learnandgrow.list;

import java.util.List;

public class ListNode {
    private int val;
    private  ListNode next;

    ListNode(){
        super();
    }

    ListNode(int val) {
        super();
        this.val=val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
