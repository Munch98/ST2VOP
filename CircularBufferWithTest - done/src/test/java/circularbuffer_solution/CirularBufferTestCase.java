/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularbuffer_solution;

import java.CircularBuff;
import java.util.Arrays;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fsan
 */
public class CirularBufferTestCase extends TestCase {

    CircularBuff instance = null;
    int size;
    Producer producer;

    public CirularBufferTestCase() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    @Override
    public void setUp() {
        size = 5;
        instance = new CircularBuff(size);
        producer = new Producer(instance);
        producer.start();
    }

    @After
    @Override
    public void tearDown() {
        producer.interrupt();
    }

    /**
     * Test of put method, of class CircularBuff.
     */
    @Test
    public void testPutGet() {
        System.out.println("putGet");
        int[] arr = new int[11];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = instance.get();
        }
        int[] expResult = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expResult, arr);
    }
    
    /**
     * Test of toString method, of class CircularBuff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Integer[] buf = new Integer[size];
        String expResult = "Buff: " + Arrays.toString(buf);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    public class Producer extends Thread {
        private CircularBuff q;

        public Producer(CircularBuff q) {
            this.q = q;
        }

        @Override
        public void run() {
            int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            try {
                for (int j : arr) {
                    q.put(j);
                    Thread.sleep((long) (Math.random() * 100));
                }
            } catch (InterruptedException ex) {
                System.out.println("Producer was interrupted");
            }

        }
    }

}
