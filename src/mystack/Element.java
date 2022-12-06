package mystack;

public class Element<T extends Comparable<T>> {

    Element<T> next = null;
    T data;

    public Element() {
    }

    public Element(T d) {
        data = d;
    }

    public void add(Element<T> newElement) {
        if (next != null) {
            next.add(newElement);
        } else {
            next = newElement;
        }
    }

    public T peek() {
        if (next != null) {
            return next.peek();
        } else {
            return this.data;
        }
    }

    public T pop() {
        if (next.next != null) {
            return next.pop();
        } else {
            T temp = next.data;
            next = null;
            return temp;
        }
    }

    @Override
    public String toString() {
        return this.data + " -> " + this.next;
    }
}
