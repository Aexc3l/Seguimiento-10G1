package model.dataestructures;

public class AltNode<V> {

    private V value;

    private AltNode<V> next;
    public AltNode(V value) {
        this.value = value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }


    public AltNode<V> getNext() {
        return next;
    }

    public void setNext(AltNode<V> next) {
        this.next = next;
    }


}