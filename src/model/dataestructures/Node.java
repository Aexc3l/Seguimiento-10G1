package model.dataestructures;

public class Node<V, K extends Comparable<K>> {

    private V value;
    private K key;

    private Node<V, K> next;
    private Node<V, K> back;
    public Node(V value, K key) {
        this.value = value;
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    @Override
    public String toString(){
        return "My value is: " + value;
    }

    public Node<V, K> getNext() {
        return next;
    }

    public void setNext(Node<V, K> next) {
        this.next = next;
    }

    public void setBack(Node<V, K> back) {
        this.back = back;
    }

    public Node<V, K> getBack() {
        return back;
    }
}