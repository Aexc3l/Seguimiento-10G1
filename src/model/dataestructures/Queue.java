package model.dataestructures;

import exceptions.QueueException;
import interfaces.IQueue;

public class Queue <V,K extends Comparable<K>> implements IQueue<V,K>{
    private  Node<V,K> first;
    private  Node<V,K>  last;
    private int size;

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(V value, K key){
        Node<V,K> newNode = new Node<V,K>(value, key);
        if (first == null){
            first = last = newNode;
        }else {
            last.setNext(newNode);
            last = newNode;
        }
        this.size++;
    }

    public V dequeue() throws QueueException {
        if (isEmpty()){
            throw new QueueException("There are any elements");
        }
        Node<V, K> temp = first;
        first =   first.getNext();
        this.size--;
        return temp.getValue();
    }

    public void setFirst(Node<V, K> first) {
        this.first = first;
    }

    public K getFirst() {
        return first.getKey();
    }

    public Node<V, K> getLast() {
        return last;
    }

    public void setLast(Node<V, K> last) {
        this.last = last;
    }

}
