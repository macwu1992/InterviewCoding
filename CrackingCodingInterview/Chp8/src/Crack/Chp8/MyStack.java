package Crack.Chp8;

import java.util.List;

/**
 * Created by Tong on 2017/2/11.
 */
public class MyStack<T> {
    private Node<T> top;

    public MyStack(){}

    public MyStack(T data){
        top = new Node(data);
    }

    public MyStack(Node<T> node){
        top = node;
    }

    public T getTop() throws NullPointerException{
        if (this.top == null){
            throw new NullPointerException();
        }
        return this.top.getData();
    }

    public void pop(){
        if (this.top == null){
            return;
        }

        top = top.next;
        return;
    }

    public void push(T data){
        this.pushNode(new Node(data));
    }

    private void pushNode(Node<T> node){
        if (node == null || node.getData() == null){
            return;
        }

        if (this == null || this.top == null || this.top.getData() == null){
            this.top = node;
            return;
        }

        Node top = this.getTopNode();

        node.next = top;
        this.top = node;
    }

    private Node<T> getTopNode(){
        return this.top;
    }



    public static void main(String[] args){
        MyStack<String> stack = new MyStack();

        stack.push("1");
        stack.push("2");

        stack.pop();

        try {
            System.out.println(stack.getTop());
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
