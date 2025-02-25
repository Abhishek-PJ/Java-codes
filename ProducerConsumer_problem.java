package programs;


import java.util.LinkedList;

class SharedBuffer {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait(); // Wait if the buffer is full
        }
        buffer.add(value);
        System.out.println("Producer produced: " + value);
        notify(); // Notify consumer that data is available
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Wait if the buffer is empty
        }
        int value = buffer.removeFirst();
        System.out.println("Consumer consumed: " + value);
        notify(); // Notify producer that space is available
        return value;
    }
}

class Producer extends Thread 
{
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.produce(i);
                Thread.sleep(2000); // Simulate time taken to produce
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                buffer.consume();
                Thread.sleep(4000); // Simulate time taken to consume
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class demo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(2); // Buffer capacity of 2s
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
