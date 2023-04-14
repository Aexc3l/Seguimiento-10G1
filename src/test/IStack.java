package test;

public interface IStack <V>{
    public boolean isEmpty();
    public void push (V value) throws Exception;
    public V pop();
    public V top();
}
