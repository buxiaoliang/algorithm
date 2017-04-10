package linear;

/**
 * Created by bu on 4/10/2017.
 */
public class DoubleLinkedList<E> {
    private TNode<E> header = null;   //头结点
    int size = 0;     //链表大小

    public DoubleLinkedList() {
        this.header = new TNode<E>();
    }

    //尾添加
    public boolean addToLast(E e) {
        if (size == 0) {
            header.e = e;
        } else {
            TNode<E> TNode = new TNode<E>(e);  //根据需要添加的内容封装为节点
            TNode<E> last = getNode(size); //得到最后一个节点
            last.next = TNode;
            TNode.prior = last;
        }
        size++;
        return true;
    }


    //找到第index个位置的节点
    public TNode<E> getNode(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("索引值有错：" + index);
        }
        TNode<E> temp = new TNode<E>();
        temp = header;
        int count = 1;
        while (count != index) {
            temp = temp.next;
            count++;
        }
        return temp;
    }

    //插入到第index个的位置
    public boolean insert(int index, E e) {
        TNode<E> TNode = new TNode<E>(e);
        TNode<E> cnode = getNode(index - 1); //找到第index-1个位置的节点
        TNode.next = cnode.next;
        TNode.prior = cnode;
        cnode.next.prior = TNode;
        cnode.next = TNode;
        size++;
        return true;
    }

    //删除第index个节点
    public boolean delete(int index) {
        TNode<E> delnode = getNode(index);
        delnode.prior.next = delnode.next;
        delnode.next.prior = delnode.prior;
        size--;
        return true;
    }

    private class TNode<E> {
        E e;
        TNode<E> prior, next;

        TNode() {
        }

        TNode(E e) {
            this.e = e;
            prior = null;
            next = null;
        }
    }
}
