import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // helper method that adds elements to a heap for O(n)
    // AKA HeapifyDown. I used slide's 40 psudocode to build this function
    private void arrayHeapSort(int index) {
        int largest = index;
        // Have the children of the index
        int leftChildChild = (index * 2) + 1;
        int rightChildChild = (index * 2) + 2;

        if (leftChildChild < size && data[leftChildChild] > data[largest])
            largest = leftChildChild;
        if (rightChildChild < size && data[rightChildChild] > data[largest])
            largest = rightChildChild;
        if (largest != index) {
            swap(index, largest);
            arrayHeapSort(largest);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }


    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // Adding each individual piece of data is nlogn
        for(Integer input: data)
            add(input);
        size = data.length;
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        if(data.length == 0) return;
        // Need a deep copy of the array, this MaxHeap object now holds the array and we manipulate our own data
        System.arraycopy(data, 0, this.data, 0, data.length);
        size = data.length;
        for(int i = data.length / 2; i >= 0; i--) {
            arrayHeapSort(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // Checks to see if the heap is at max length or at size 0
        if(size == data.length) return false;
        if(size == 0) {
            data[size] = item;
            size++;
            return true;
        }

        data[size] = item;
        int count = size;

        while (data[count] > data[(count / 2)]) {
            swap(count, (count / 2));
            count /= 2;
        }
        size++;
        return true;
    }

    // return the max item in the heap
    public Integer get() {
        return size == 0 ? null : data[0];
    }

    // remove the root item
    public Integer pop() {
        if(size == 0) return null;
        Integer output = data[0];
        size--;
        data[0] = data[size];
        // Now that the first value has been removed, we need to move everything
        for(int i = data.length / 2; i >= 0; i--) {
            arrayHeapSort(i);
        }
        data[size] = null;


        return output;
    }

    // Built the recommended equals function. Initally it checked if the elements were the same but two valid heaps can have a
    // different arrangement of elements
    public boolean equals(MaxHeap other) {
        // Null pointer exceptions, just in case
        if(other.data.length != this.data.length) return false;

        Integer[] otherData = new Integer[other.data.length];
        Integer[] ourData = new Integer[this.data.length];
        // Wanted to not change initial arrays but I also want manipulated arrays to check
        System.arraycopy(other.data, 0, otherData, 0, other.data.length);
        System.arraycopy(data, 0, ourData, 0, this.data.length);

        Arrays.sort(otherData);
        Arrays.sort(ourData);

        for(int i = 0; i < size; i++) {
            if (!otherData[i].equals(ourData[i])) return false;
        }
        return true;
    }
}
