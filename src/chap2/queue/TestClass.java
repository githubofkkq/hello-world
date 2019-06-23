package chap2.queue;

import org.junit.Test;

public class TestClass {

    @Test
    public void testfun1(){
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

    }
    @Test
    public void testfun2(){
        LoopQueue<String> queue = new LoopQueue<>();

        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);

        queue.dequeue();
        queue.enqueue("four");
        queue.dequeue();
        queue.enqueue("five");
        System.out.println(queue);

    }
}
