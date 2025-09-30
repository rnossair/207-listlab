package edu.grinnell.csc207.listlab;



/**
 * A linked implementation of the list ADT.
 */
public class LinkedList {

    private static class Node{
        public int val;
        public Node next;
        public Node(int value, Node next){
            this.val = value;
            this.next = next;
        }

        public Node(int value){
            this(value, null);
        }
    }

    private Node first;
    private int length = 0;

    public LinkedList(){
        first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list
     * 
     * @param value the value to add to the end of the list
     */
    public void add(int value) {
        if (first == null){
            first = new Node(value, null);
        }
        else{
            Node currNode = first;
            Node nextNode = first.next;
            while(nextNode != null){
                currNode = nextNode;
                nextNode = nextNode.next;
            }

            currNode.next = new Node(value, null);
        }
        length++;
    }

    /**
     * @return the number of elements in the list
     */
    public int size() {
        if (first == null){
            return 0;
        }
        int count = 0;
        Node currNode = first;
        Node nextNode = first.next;
        while(nextNode != null){
            currNode = nextNode;
            nextNode = nextNode.next;
            count++;
        }
        return count;
    }

    /**
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public int get(int index) {
        if(first == null){
            return -1;
        }
        if(first.next == null){
            if(index == 0){
                return first.val;
            }
            return -1;
        }

        if(index < 0 || index >= this.size()){
            return -1;
        }

        int i = 0;
        Node currNode = first;
        Node nextNode = first.next;
        while(i < index){
            currNode = nextNode;
            nextNode = nextNode.next;
            i++;
        }
        return currNode.val;
    }

    /**
     * Removes the value at <code>index</code> from the list
     * 
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public int remove(int index) {
        int result = -1;
        if(first == null){
            return -1;
        }
        if(first.next == null){
            if(index == 0){
                result = first.val;
                first = null;
                return result;
            }
            return -1;
        }

        if(index < 0 || index >= this.size()){
            return -1;
        }

        int i = 0;
        Node prevNode = null;
        Node currNode = first;
        Node nextNode = first.next;
        while(i < index){
            prevNode = currNode;
            currNode = nextNode;
            if(nextNode != null){
                nextNode = nextNode.next;
            }
            i++;
        }
        prevNode.next = nextNode;
        result = currNode.val;
        currNode = null;
        length--;
        return result;
    }

    // boolean isEmpty(): returns true if and only if the list has no elements.
    // void clear(): removes all the elements from the list.
    // int indexOf(int value): returns the index of the first occurrence of value in the list or -1 if value is not in the list.
    // boolean contains(int value): returns true if and only if value is found in the list.
    // void add(int index, int value): adds value to the list at index, throwing an IndexOutOfBoundsException if index is out of range (index < 0 || index > size()).

    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
    }

    public void clear(){
        first = null;
        length = 0;
    }

    public int indexOf(int value){
        Node currNode = first;
        Node nextNode = first.next;
        int i = 0;
        while(nextNode != null){
            i++;
            currNode = nextNode;
            nextNode = nextNode.next;
            if(currNode.val == value){
                return i;
            }
        }

        if(currNode.val == value){
            return i;
        }
        return -1;
    }

    public boolean contains(int value){
        Node currNode = first;
        Node nextNode = first.next;
        while(nextNode != null){
            currNode = nextNode;
            nextNode = nextNode.next;
            if(currNode.val == value){
                return true;
            }
        }

        if(currNode.val == value){
            return true;
        }
        return true;
    }
    public void add(int index, int value){
        Node currNode = first;
        Node nextNode = first.next;
        int i = 0;
        if(index >= length || index < 0){
            throw new IndexOutOfBoundsException();
        }
        while(nextNode != null){
            i++;
            currNode = nextNode;
            nextNode = nextNode.next;
            if(i == index){
                Node newNode = new Node(value);
                newNode.next = nextNode;
                currNode.next = newNode;
            }
        }
    }
}
