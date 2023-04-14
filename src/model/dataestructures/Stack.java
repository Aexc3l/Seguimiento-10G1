package model.dataestructures;

import test.IStack;

public class Stack<V> implements IStack<V> {

    private AltNode<V> top;
    private int size;

    public boolean isEmpty(){
        return top == null;
    }

    public void push(V value) {
        AltNode<V> node = new AltNode<V>(value);
        node.setNext(top);
        top = node;
    }

    public V pop() {
        if (isEmpty()) {
            return null;
        }
        V value = top.getValue();
        top = top.getNext();

        return value;
    }

    public V top() {
        if (isEmpty()) {
            return null;
        }
        return top.getValue();
    }
    public int size() {
        return this.size;
    }
}
