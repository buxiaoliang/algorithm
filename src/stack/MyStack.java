package stack;

import java.util.EmptyStackException;

/**
 * Created by bu on 4/10/2017.
 */
public class MyStack {
    private int[] arr;  //????
    private int top;  //???????

    /**
     * ??????????????10???????
     */
    public MyStack() {
        arr = new int[10];
        top = -1;
    }

    /**
     * ??????????????????
     *
     * @param size
     */
    public MyStack(int size) {
        arr = new int[size];
        top = -1;
    }

    /**
     * ???????
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * ????
     *
     * @param element
     */
    public void push(int element) {
        if (top == arr.length - 1) {
            throw new StackOverflowError();
        } else {
            arr[++top] = element;
        }
    }

    /**
     * ????
     *
     * @return
     */
    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        } else {
            return arr[top--];
        }
    }

    /**
     * ??????
     *
     * @return
     */
    public int peek() {
        if (top == -1) throw new EmptyStackException();
        else return arr[top];
    }
}
