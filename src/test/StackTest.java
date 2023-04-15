package test;
import static org.junit.jupiter.api.Assertions.*;

import exceptions.StackException;
import interfaces.IStack;
import model.Coin;
import model.dataestructures.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTest {

    private IStack<Coin> stack;
    @BeforeEach
    void setUp() {
        stack = new Stack<Coin>();
    }
    @Test
    public void testIsEmptyWhenEmpty() {
        //Assert
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmptyWhenNotEmpty() {
        //Arrange
        Coin coin1 = new Coin(500, "Chile");

        //Act
        stack.push(coin1);

        //Assert
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testIsEmptyAfterPopElements() {
        //Arrange
        stack.push(new Coin(200,"Chile"));

        //Act
        try {
            stack.pop();
        } catch (StackException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertTrue(stack.isEmpty());
    }
    @Test
    void testPushOneElementVerifyIsTop() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");

        // Act
        stack.push(coin1);

        // Assert
        assertEquals(coin1, stack.top());
    }

    @Test
    void testPushFewElementsVerifyTop() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        Coin coin4 = new Coin(400,"Venezuela");
        Coin coin5 = new Coin(200,"Mexico");


        // Act
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);
        stack.push(coin4);
        stack.push(coin5);


        // Assert
        assertNotEquals(coin1, stack.top());
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
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);
        stack.push(coin4);
        stack.push(coin5);

        // Assert
        assertEquals(5, stack.size());
    }

    @Test
    void testPopOneElementVerifyIsEmpty() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");
        stack.push(coin1);

        // Act
        try {
            stack.pop();
        } catch (StackException e) {
            throw new RuntimeException(e);
        }

        // Assert
        assertNotEquals(coin1, stack.isEmpty());
    }

    @Test
    void testPopFewElementsVerifyTop() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        Coin coin4 = new Coin(400,"Venezuela");
        Coin coin5 = new Coin(200,"Mexico");
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);
        stack.push(coin4);
        stack.push(coin5);


        // Act
        try {
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (StackException e) {
            throw new RuntimeException(e);
        }

        // Assert
        assertEquals(coin2, stack.top());
    }

    @Test
    void testPopFewElementsVerifySize() {
        // Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);

        // Act
        try {
            stack.pop();
        } catch (StackException e) {
            throw new RuntimeException(e);
        }

        // Assert
        assertEquals(2, stack.size());
    }

    @Test
    public void testTop() {
        //Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);

        //Act
        Coin value = stack.top();

        //Assert
        assertEquals(3, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(coin3, value);
    }

    @Test
    public void testTopWhenEmpty() {
        //Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);

        //Act
        try {
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (StackException e) {
            throw new RuntimeException(e);
        }

        //Assert
        assertNull(stack.top());
    }

    @Test
    public void testTopAfterPop() throws StackException {
        //Arrange
        Coin coin1 = new Coin(100,"Colombia");
        Coin coin2 = new Coin(5,"United States");
        Coin coin3 = new Coin(1000,"Colombia");
        stack.push(coin1);
        stack.push(coin2);
        stack.push(coin3);
        stack.pop();

        //Act

        Coin value = stack.top();

        //Assert
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
        assertEquals(coin2, value);
    }
}
