package chap1.array;

import org.junit.Test;
import sun.reflect.annotation.ExceptionProxy;

public class TestClass {

    @Test
    public void testFun1() throws Exception {
        Array array = new Array(3);
        array.addLast(1);
        array.addLast(2);
        System.out.println(array);

        array.addLast(3);
        array.addFirst(0);
        System.out.println(array);
        array.add(3,5);

        System.out.println(array);
//        System.out.println(array.get(4));
//        System.out.println(array.getSize());
        array.deleteFirst();
        array.deleteFirst();
        System.out.println(array);


        System.out.println(array.contains(5));
        System.out.println(array.find(2));
        System.out.println(array.delete(1));
        System.out.println(array);

    }

    @Test
    public void testFun2() throws Exception {
        Array<String> array = new Array<>();
        array.addLast("one");
        array.addLast("two");
        array.addLast("three");
        array.addFirst("zero");
        System.out.println(array);

        array.add(3,"five");
        System.out.println(array);
//        System.out.println(array.get(4));
//        System.out.println(array.getSize());

        array.deleteFirst();
        array.deleteFirst();
        array.deleteFirst();
        System.out.println(array.contains("two"));
        System.out.println(array.find("three"));
        System.out.println(array.delete(1));
        System.out.println(array);

    }
}
