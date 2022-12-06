package mystack;

import java.util.NoSuchElementException;

public class Stack<T extends Comparable<T>> {

    private Element<T> root;
    int counter = 0;

    Element<T> maxElement;
    Stack<T> sortedStack;

    public void add(T data) {
        Element<T> newElement = new Element<>(data);
        counter++;

        if (root != null) {
            root.add(newElement);
        } else {
            root = newElement;
        }
    }

    public T peek() {
        if (root == null) {
            throw new NoSuchElementException("There are no elements in the stack!");
        } else if (root.next == null) {
            return root.data;
        } else {
            return root.peek();
        }
    }

    public T pop() {
        if (root == null) {
            throw new NoSuchElementException("There are no elements in the stack!");
        } else if (root.next == null) {
            counter--;
            T temp = root.data;
            root = null;
            return temp;
        } else {
            counter--;
            return root.pop();
        }
    }

    public int size() {
        return counter;
    }

    public Stack<T> getSortedStack() {
        sortedStack = new Stack<>();
        Stack<T> remainderStack = new Stack<>();

        while (this.size() != 0) {
            stackSorting(this, remainderStack);
            stackSorting(remainderStack, this);
        }
        return sortedStack;
    }

    private void stackSorting(Stack<T> tStack, Stack<T> remainderStack) {
        Element<T> temp = new Element<>();
        maxElement = tStack.root;
        while (tStack.size() != 0) {
            temp.data = tStack.peek();
            if (sortedStack.size() > 0) {
                if (temp.data.compareTo(sortedStack.peek()) == 0) {
                    tStack.pop();
                    continue;
                }
            }
            if (temp.data.compareTo(maxElement.data) > 0) {
                maxElement = new Element<>(temp.data);
            }
            remainderStack.add(tStack.pop());
        }
        if (tStack.size() != 0 || remainderStack.size() != 0) {
            sortedStack.add(maxElement.data);
        }
    }

    @Override
    public String toString() {
        return this.root + "";
    }

}
