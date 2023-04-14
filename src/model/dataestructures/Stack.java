package model.dataestructures;

import exceptions.StackException;
import interfaces.IStack;

public class Stack<V> implements IStack<V> {

    private AltNode<V> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(V value) {
        AltNode<V> node = new AltNode<V>(value);
        node.setNext(top);
        top = node;
        this.size++;
    }

    public V pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is empty");
        }
        V value = top.getValue();
        top = top.getNext();
        this.size--;

        return value;
    }

    public V top() {
        if (isEmpty()) {
            return null;
        }
        return top.getValue();
    }

    @Override
    public int size() {
        return this.size;
    }
}
