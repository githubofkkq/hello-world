package chap1.array;

public class Array<E> {
    private E[] data;
    private int size;


    /**
     *  带参构造函数
     * @param capacity 数组容量
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
    }

    /**
     *  默认构造函数
     */
    public Array(){
        this(10);
    }

    // 获取元素的个数
    public int getSize(){
        return size;
    }

    // 获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 判空
    public boolean isEmpty(){
        return size == 0;
    }


    // 末尾添加元素
    public void addLast(E element) throws IllegalArgumentException{
        add(size,element);
    }
    public void addFirst(E element) throws IllegalArgumentException{
        add(0,element);
    }

    // 指定位置添加元素
    public void add(int index,E element) throws IllegalArgumentException{
        if(index < 0 || index > size){
            throw new IllegalArgumentException("数组越界异常：addLast failed,数组已满");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size; i > index; i--){
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
        newData = null;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("get : error index");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size -1 );
    }

    public void set(int index, E element){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("set : error index");
        }
        data[index] = element;
    }



    public boolean contains(E element){
        for(int i = 0; i < size; i++){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public int find(E element){
        for(int i = 0; i < size; i++){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public E delete(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("delete: the element does not exist,index out of range");
        }
        E result = data[index];
        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0 ){
            resize(data.length / 2);
        }
        return result;
    }

    public E deleteFirst(){
        return delete(0);
    }

    public E deleteLast(){
        return delete(size - 1);
    }

    public void deleteElement(E element){
        int index = find(element);
        if(index != -1){
            delete(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n",size,data.length));
        res.append("  ->>[ ");
        for(int i = 0; i < size; i++){
            if(i == (size - 1)){
                res.append(data[i]);
                break;
            }
            res.append(data[i] + ", ");
        }
        res.append("]");
        return res.toString();
    }
}
