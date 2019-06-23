package chap2.queue;

import java.util.EmptyStackException;

public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front;
    private int tail;
    private int size;

    LoopQueue(){
        this(10);
    }

    LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }
    @Override
    public void enqueue(E element) {
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size++;

    }

    private void resize(int capacity) {
        E[] newData = (E[])new Object[capacity + 1];
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;

    }

    @Override
    public E dequeue() {

        if(isEmpty()){
            throw new IllegalArgumentException("cannot dequeue a empty queue!");
        }else{
            E ret = data[front];
            data[front] = null;
            front = (front + 1) % data.length;
            size--;
            if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
                resize(getCapacity() / 2);
            }
            return ret;
        }
    }


    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("cannot dequeue a empty queue!");
        }else{
            return data[front];
        }
    }

    public int getCapacity(){
        return data.length - 1;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,getCapacity()));
        res.append("front  ->>[ ");
        for(int i = front; i != tail; i = (i + 1) % getCapacity()){
            if((i + 1) % getCapacity() != tail){
                res.append(data[i] + ", ");
            }else{
                res.append(data[i]);
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
