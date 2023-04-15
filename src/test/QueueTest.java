package test;
import static org.junit.jupiter.api.Assertions.*;

import exceptions.QueueException;
import interfaces.IQueue;
import model.Coin;
import model.dataestructures.Queue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {

    private IQueue<Coin,String> queue;
    @BeforeEach
    void setUp() {
        queue = new Queue<Coin,String>();
    }

    @Test
    public void testIsEmptyWhenEmpty() {
        //Assert
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        //Arrange
        Coin coin1 = new Coin(500, "Chile");

        //Act
        queue.enqueue(coin1,coin1.getCountry());

        //Assert
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testIsEmptyAfterDequeueElements() {
        //Arrange
        Coin coin1 = new Coin(200,"Chile");
        queue.enqueue(coin1,coin1.getCountry());

        //Act
        try {
            queue.dequeue();
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPushOneElementVerifyIsFirst() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");

        // Act
        queue.enqueue(coin1,coin1.getCountry());

        // Assert
        assertEquals(coin1.getCountry(), queue.getFirst());
    }

    @Test
    void testPushFewElementsVerifyFirst() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        Coin coin4 = new Coin(400,"Venezuela");
        Coin coin5 = new Coin(200,"Mexico");

        // Act
        queue.enqueue(coin2,coin2.getCountry());
        queue.enqueue(coin4,coin4.getCountry());
        queue.enqueue(coin1,coin1.getCountry());
        queue.enqueue(coin3,coin3.getCountry());
        queue.enqueue(coin5,coin5.getCountry());

        // Assert
        assertEquals(coin2.getCountry(), queue.getFirst());
    }

    @Test
    void testPushFewElementsVerifySize() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        Coin coin4 = new Coin(400,"Venezuela");
        Coin coin5 = new Coin(200,"Mexico");

        // Act
        queue.enqueue(coin1,coin1.getCountry());
        queue.enqueue(coin2,coin2.getCountry());
        queue.enqueue(coin3,coin3.getCountry());
        queue.enqueue(coin4,coin4.getCountry());
        queue.enqueue(coin5,coin5.getCountry());

        // Assert
        assertEquals(5, queue.getSize());
    }

    @Test
    void testDequeueisEmptyException() {
        assertThrows(QueueException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    void testDequeueOneElement() {
        //Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        queue.enqueue(coin1,coin1.getCountry());
        queue.enqueue(coin2,coin2.getCountry());


        //Act
        Coin value;
        try {
            value = queue.dequeue();
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertEquals(coin1, value);
        assertEquals(1, queue.getSize());
        assertEquals(coin2.getCountry(), queue.getFirst());
        assertEquals("United States", queue.getFirst());
    }
    @Test
    void testDequeueInNonEmptyQueue() {
        //Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        Coin coin4 = new Coin(400,"Venezuela");
        Coin coin5 = new Coin(200,"Mexico");

        queue.enqueue(coin1,coin1.getCountry());
        queue.enqueue(coin2,coin2.getCountry());
        queue.enqueue(coin3,coin3.getCountry());
        queue.enqueue(coin4,coin4.getCountry());
        queue.enqueue(coin5,coin5.getCountry());

        //Act
        Coin value;
        try {
            value = queue.dequeue();
        } catch (QueueException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertEquals(coin1, value);
        assertEquals(4, queue.getSize());
        assertEquals(coin2.getCountry(), queue.getFirst());
        assertEquals("United States", queue.getFirst());
    }

}