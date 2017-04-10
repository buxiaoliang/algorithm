package linear;

/**
 * Created by bu on 4/10/2017.
 */
public class LinkedList<E> {
    private Node<E> header = null;   //头结点
    int size = 0;     //链表大小

    public LinkedList() {
        this.header = new Node<E>();
    }

    //得到链表的长度
    public int length() {
        return size;
    }

    //按值查找节点，返回该节点的位置
    public int locateElem(E e) {
        Node<E> temp = header;
        int count = 1;
        while (temp.next != null && temp.e != e) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    //找到第index个位置的节点
    public Node<E> getNode(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        Node<E> temp = new Node<E>();
        temp = header;
        int count = 1;
        while (count != index) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    //尾添加
    public boolean addToLast(E e) {
        if (size == 0) {
            header.e = e;
        } else {
            Node<E> newnode = new Node<E>(e);  //根据需要添加的内容封装为节点
            Node<E> last = getNode(size); //得到最后一个节点
            last.next = newnode;
        }
        size++;
        return true;
    }

    //头添加
    public boolean addTofirst(E e) {
        if (size == 0) {
            header.e = e;
        } else {
            Node<E> newnode = new Node<E>(e);  //根据需要添加的内容封装为节点
            newnode.next = header.next;
            header.next = newnode;
        }
        size++;
        return true;
    }

    //插入到第index个的位置
    public boolean insert(int index, E e) {
        Node<E> newnode = new Node<E>(e);  //根据需要添加的内容封装为节点
        Node<E> cnode = getNode(index - 1);  //得到第index-1个节点
        newnode.next = cnode.next;
        cnode.next = newnode;
        size++;
        return true;
    }

    //删除第index个节点
    public boolean delete(int index) {
        Node<E> prinode = getNode(index - 1);  //得到被删除的节点的前一个节点
        Node<E> delnode = prinode.next;    //得到被删除的节点
        prinode.next = delnode.next;
        size--;
        return true;
    }

    //判空
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public void destroyList() {
        header = null;
        size = 0;
    }

    //输出
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        Node<E> temp = header;
        for (int i = 0; i < size; i++) {
            s.append(temp.e.toString() + " ");
            temp = temp.next;
        }
        s.append("]");
        return s.toString();
    }

    private class Node<E> {
        E e;  //数据
        Node<E> next; //下一个节点

        Node() {
        }

        Node(E e) {
            this.e = e;
            this.next = null;
        }
    }
}
