package interfaces;

import exceptions.HashException;

public interface IHashTable <K,V>{

    void insert(K key, V value) throws HashException;

    V search(K key);
    void delete(K key);

    int getSize();

    int getM();

}
