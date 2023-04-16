package test;
import static org.junit.jupiter.api.Assertions.*;

import exceptions.HashException;
import interfaces.IHashTable;
import model.dataestructures.HashTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class HashTableTest {
    private IHashTable<Integer,String> hashTable;
    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>(8);
    }

    @Test
    public void testInsertEqualKeys() {
        //Arrange
            String n = "Harry";
            String m = "Potter";

        //Act
        try {
            hashTable.insert(1,n);
        } catch (HashException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertThrows(HashException.class, () -> {
            hashTable.insert(1,m);
        });
        assertEquals(8, hashTable.getM());
    }

    @Test
    public void testFewInsertswithDuplicatedKey() {
        //Arrange
        String n = "Harry";
        String m = "Potter";
        String o = "Peter";
        String p = "Parker";

        //Act
        try {
            hashTable.insert(0,n);
            hashTable.insert(4,o);
            hashTable.insert(24,p);
        } catch (HashException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertThrows(HashException.class, () -> {
            hashTable.insert(0,m);
        });
        assertEquals("Harry",hashTable.search(0));
        assertEquals(3, hashTable.getSize());
    }
    @Test
    public void testFewInsertsOverCapacity() {
        //Arrange
        String a = "Harry";
        String b = "Potter";
        String c = "Peter";
        String d = "Parr";
        String q = "Hary";
        String f = "Ptter";
        String g = "Pr";
        String h = "Par";
        String i = "Ha";
        String j = "Ptr";
        String k = "Peteor";
        String l = "Parkr";

        //Act
        try {
            hashTable.insert(0,a);
            hashTable.insert(4,b);
            hashTable.insert(8,c);
            hashTable.insert(24,d);
            hashTable.insert(16,q);
            hashTable.insert(80,f);
            hashTable.insert(14,g);
            hashTable.insert(2,h);
            hashTable.insert(10,i);
            hashTable.insert(19,j);
            hashTable.insert(100,k);
            hashTable.insert(200,l);
        } catch (HashException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertEquals("Potter",hashTable.search(4));
        assertNotEquals(8, hashTable.getSize());
    }
}
