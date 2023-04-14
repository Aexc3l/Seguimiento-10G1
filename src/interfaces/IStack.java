package interfaces;

import exceptions.StackException;

public interface IStack <V>{
    public boolean isEmpty();
    public void push (V value);
    public V pop() throws StackException;
    public V top();
    public int size();
}
