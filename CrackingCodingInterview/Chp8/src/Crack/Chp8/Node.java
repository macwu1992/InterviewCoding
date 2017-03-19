package Crack.Chp8;

/**
 * Created by Tong on 2017/2/11.
 */
public class Node<T> {
    private T data;
    public Node<T> next;

    private Node(){}

    public Node(T data){
        this.data = data;
        next = null;
    }

    public T getData(){
        return this.data;
    }
}
