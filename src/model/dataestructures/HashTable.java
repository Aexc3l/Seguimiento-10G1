package model.dataestructures;
import exceptions.HashException;
import interfaces.IHashTable;

import java.nio.ByteBuffer;
import java.util.ArrayList;


public class HashTable<K extends Comparable<K>,V> implements IHashTable<K,V>{

    private int size; //Tamaño

    private int m; //Capacidad
    private ArrayList<Node<V,K>>[] hashing;

    public HashTable(int m) {
        hashing = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            hashing[i] = new ArrayList<Node<V, K>>();
        }
        this.size = 0;
        this.m = m;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
    @Override
    public int getM() {
        return m;
    }

    private final int hashCode(K key){
        return Math.abs(key.hashCode() % m);
    }
    @Override
    public void insert(K key, V value) throws HashException {
        int index = hashCode(key);

        ArrayList<Node<V,K>> temp = hashing[index];

        for (Node<V,K> entry : temp) {
            if (entry.getKey().equals(key)) {
                throw new HashException("Duplicate key");
            }
        }
        temp.add(new Node<V,K>(value, key));
        size++;
    }

    @Override
    public V search(K key) {
        int index = hashCode(key);
        ArrayList<Node<V,K>> temp = hashing[index];
        for (Node<V,K> entry : temp) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        int index = hashCode(key);
        ArrayList<Node<V,K>> bucket = hashing[index];
        int i = 0;
        while (i < bucket.size()) {
            if (bucket.get(i).getKey().equals(key)) {
                bucket.remove(i);
                size--;
                return;
            }
            i++;
    }
    }
}
