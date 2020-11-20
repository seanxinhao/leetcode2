/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
class MyCircularDeque {

    private int[] element;
    private int length;
    private int front;
    private int end;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        element = new int[k + 1];
        length = k + 1;
        front = 0;
        end = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (length + front - 1) % length;
        element[front] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        element[end] = value;
        end = (end + 1) % length;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % length;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        end = (end + length - 1) % length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return element[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return element[(end + length - 1) % length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == end;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (end + 1) % length == front;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
