package test;
import static org.junit.jupiter.api.Assertions.*;

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
}
