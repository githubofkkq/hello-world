package chap3.linkedList;


import org.junit.Test;

public class TestClass {

    @Test
    public void testFun1(){
        LinkedList<String> list =  new LinkedList<>();
        list.add(0,"one");
        list.add(0,"two");
        list.add(0,"three");
        list.add(0,"four");

        System.out.println(list);


        list.add(4,"kkq");
        System.out.println(list);

        list.remove(4);
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);
    }
}
