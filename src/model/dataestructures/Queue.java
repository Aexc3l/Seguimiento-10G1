package model.dataestructures;

public class Queue <V,K extends Comparable<K>>{
    private  Node<V,K> top;
    private  Node<V,K>  last;
    private int size;

    private boolean isEmpty(){
        return this.top == null;
    }

    public Node<V, K> getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }

    public void enqueue(V value, K key){
        Node<V,K> newNode = new Node<V,K>(value, key);
        if (top == null){
            top = last = newNode;
        }else {
            last.setNext(newNode);
            last = newNode;
        }
        size++;
    }
    public V dequeue(){
        if (isEmpty()){
            throw new RuntimeException("There are any elements");
        }
        Node<V, K> temp = top;
        top =   top.getNext();
        size--;
        return temp.getValue();
    }
    public void setTop(Node<V, K> top) {
        this.top = top;
    }

    public Node<V, K> getLast() {
        return last;
    }

    public void setLast(Node<V, K> last) {
        this.last = last;
    }
}
