import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public long testLogN(int size) {
        // I want to create everything outside of what I'm testing outside of the performance test
        MaxHeap heapLogN = new MaxHeap(size);
        Random rand = new Random(69);
        Integer[] input = new Integer[size];
        // This creates the array i will input
        for(int i = 0; i < size; i++) {
            input[i] = rand.nextInt(100);
        }

        // What I'm checking is how long it takes to heap
        long startTime = System.nanoTime();
        heapLogN.MaxHeapLogN(input);
        long endTime = System.nanoTime();

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }

    public long testN(int size) {
        MaxHeap heapN = new MaxHeap(size);
        Random rand = new Random(69);
        Integer[] input = new Integer[size];
        // This creates the array i will input
        for(int i = 0; i < size; i++) {
            input[i] = rand.nextInt(100);
        }

        long startTime = System.nanoTime();
        heapN.MaxHeapN(input);
        long endTime = System.nanoTime();

        return TimeUnit.MICROSECONDS.convert(endTime-startTime, TimeUnit.NANOSECONDS);
    }
}
