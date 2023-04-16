package model.dataestructures;

public class Node<V, K extends Comparable<K>> {

    private V value;
    private K key;

    private Node<V, K> next;
    private Node<V, K> previous;
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

    public Node<V, K> getNext() {
        return next;
    }

    public void setNext(Node<V, K> next) {
        this.next = next;
    }

    public void setPrevious(Node<V, K> previous) {
        this.previous = previous;
    }

    public Node<V, K> getPrevious() {
        return previous;
    }
}