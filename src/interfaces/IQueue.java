package interfaces;

import exceptions.QueueException;
import model.dataestructures.Node;

public interface IQueue <V,K extends Comparable<K>>{
    public boolean isEmpty();

    public K getFirst();

    public int getSize();

    public void enqueue(V value, K key);
    public V dequeue() throws QueueException;
    public void setFirst(Node<V, K> first);

    public Node<V, K> getLast();

    public void setLast(Node<V, K> last);
}
