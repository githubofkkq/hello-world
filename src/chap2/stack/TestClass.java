package chap2.stack;

import org.junit.Test;

public class TestClass {

    @Test
    public void testFun1() {
        Stack stack = new ArrayStack(10);



        stack.push("I");
        stack.push("am");
        stack.push("kkq");

        System.out.println(stack);

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
