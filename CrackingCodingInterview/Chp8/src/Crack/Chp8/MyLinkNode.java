package Crack.Chp8;

/**
 * Created by Tong on 2017/2/10.
 */
public class MyLinkNode<T> {
    private T data;
    public MyLinkNode<T> nextLinkNode = null;

    public MyLinkNode(){}

    public MyLinkNode(T data){
        this.data = data;
        this.nextLinkNode = null;
    }

    public boolean appendToTail(T data){
        if (this == null){
            return false;
        }

        if (this.data == null){
            this.data = data;
            return true;
        }

        MyLinkNode newEndNode = new MyLinkNode(data);
        MyLinkNode nowEndNode = this;

        while(nowEndNode.nextLinkNode != null){
            nowEndNode = nowEndNode.nextLinkNode;
        }

        nowEndNode.nextLinkNode = newEndNode;
        return true;
    }

    public boolean appendAllToTail(T[] data){
        for (T t : data) {
            if (this.appendToTail(t)) {
            }else{
                return false;
            }
        }

        return true;
    }

    public void removeData(T data){
        MyLinkNode pointer = this;

        if (pointer == null || pointer.data == null){
            return;
        }

        while(pointer.nextLinkNode.data != data){
            pointer = pointer.nextLinkNode;
        }

        pointer.nextLinkNode = pointer.nextLinkNode.nextLinkNode;

        pointer.nextLinkNode = null;
    }

    public boolean removeNode(MyLinkNode node){
        if (node == null || node.nextLinkNode == null){
            return false;
        }

        MyLinkNode next = node.nextLinkNode;

        node.nextLinkNode = next.nextLinkNode;
        node.setData(next.getData());

        return true;
    }

    public boolean isExist(T data){
        MyLinkNode pointer = this;

        if (pointer == null || pointer.data == null){
            return false;
        }

        while(pointer != null){
            if (pointer.data == data){
                return true;
            }else{
                pointer = pointer.nextLinkNode;
            }
        }

        return false;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public static void main(String[] args){
        MyLinkNode<Integer> linkList = new MyLinkNode();
        MyLinkNode<Integer> linkListPointer = linkList;

        Integer[] intArray = {10,2,33,5,9,0};

        for (Integer integer : intArray){
            if (linkList.appendToTail(integer)){}else{
                continue;
            }
        }

        while(linkListPointer != null){
            System.out.println(linkListPointer.data);
            linkListPointer = linkListPointer.nextLinkNode;
        }
    }
}
