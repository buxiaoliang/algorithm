package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by bu on 4/10/2017.
 */
public class MyCollectionStack<E extends Object> {
    private List<E> list = new ArrayList<E>();  //底层基于ArrayList的容器

    public MyCollectionStack() {
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E e) {
        list.add(e);
    }

    public E pop() {
        if (list.isEmpty()) throw new EmptyStackException();
        else return list.remove(list.size() - 1);
    }

    public E peek() {
        if (list.isEmpty()) throw new EmptyStackException();
        else return list.get(list.size() - 1);
    }
}
