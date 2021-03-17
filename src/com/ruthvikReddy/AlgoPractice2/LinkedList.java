package com.ruthvikReddy.AlgoPractice2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void addLast(int item){
        var node = new Node(item);

        if(last == null && first == null)
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item){
        var node = new Node(item);

        if(last == null && first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;

    }

    public int indexOf(int item){
        var current = first;
        int index = 0;
        while(current != null){
            if(current.value == item){
                return index;
            }
            current = current.next;
            index++;
        }
            return -1;
    }

    public boolean contains(int item){
        var current = first;
        while(current != null){
            if(current.value == item) return true;
            current = current.next;
        }
        return false;
    }
    public void removeFirst(){

        if(isEmpty()) throw  new NoSuchElementException();

        if(first.next == null){
            first = last = null;
        }

        var current = first;
        first = first.next;
        current.next = null;
        size--;
    }

    public void removeLast(){

        if(isEmpty()) throw new NoSuchElementException();

        if(first == last || first.next == null) {
            first = last = null;
            size--;
            return;
        }

        var current = first.next;
        var lastButOne = first;

        while(current.next != null){
            current = current.next;
            lastButOne = lastButOne.next;
        }

        last = lastButOne;
        last.next = null;
        size--;

    }

    public void reverse(){

        if(isEmpty()) return;

        var current = first.next;
        var previous = first;
        Node next;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        Node temp = first;
        first = last;
        last = temp;
        last.next = null;
    }

    public int getKthFromTheEnd(int kthnode){

        if(isEmpty()) throw new IllegalStateException() ;


        Node current = first;
        Node follow = first;
        int i = 0;

        while(i++ < kthnode) {
            current = current.next;

            if(current == null)
                throw  new IllegalStateException();
        }

        while(current.next != null){
            current = current.next;
            follow = follow.next;
        }

        return follow.value;
    }

    public int[] toArray(){
        int index = 0;
        int array[] = new int[size];
        var current = first;

        while(index < size ){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public boolean isEmpty(){
        return first == null && last == null;
    }

    public int size(){
        return size;
    }






}
