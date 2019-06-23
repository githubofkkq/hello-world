package chp6;

public class BST<E extends Comparable<E>>  {

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public void add(E e){
        add(root,e);
    }

    private Node add(Node root, E e){
//        if(root.e.equals(e)){
//            return;
//        }else if(root.e.compareTo(e) > 0 && root.left == null){
//            root.left = new Node(e);
//            size++;
//            return;
//        }else if(root.e.compareTo(e) < 0 && root.right == null){
//            root.right = new Node(e);
//            size++;
//            return;
//        }else if(root.e.compareTo(e) > 0){
//            add(root.left, e);
//        }else{
//            add(root.right, e);
//        }


        if(root == null){
            size++;
            return new Node(e);
        }
        if(root.e.compareTo(e) > 0){
            root.left = add(root.left, e);
        }else if(root.e.compareTo(e) < 0){
            root.right = add(root.right, e);
        }
        return root;
    }




    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private class Node<E extends Comparable<E>>{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }
}
