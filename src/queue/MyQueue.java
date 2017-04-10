package queue;

/**
 * Created by bu on 4/10/2017.
 */
public class MyQueue {
    private int[] array = new int[4];
    private int head = 1;
    private int tail = 1;

    //入队
    public void enqueue(int x) {
        //处理上溢
        try {
            if (head != tail + 1) {
                array[tail++] = x;
                if (tail == array.length) {
                    tail = 0;
                }
            } else {
                System.out.println("overflow");
                throw new Exception("queue overflow");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //出队
    public int dequeue() {
        int number = 0;
        try {
            if (tail != head) {
                number = array[head];
                head++;
            } else {
                throw new Exception("queue underflow");
            }

        } catch (Exception e) {
            System.out.println("underflow");
            e.printStackTrace();
        }
        return number;
    }
}
