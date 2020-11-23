package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
        Stack stack = new Stack();

        @Test
        public void testPush() {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            assertEquals(3, (int) stack.peek());
            stack.pop();
            assertEquals(2, (int) stack.peek());
        }

        @Test
        public void testDequeue() {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.pop();
            stack.pop();
            assertEquals(1, (int) stack.peek());

        }
    }

