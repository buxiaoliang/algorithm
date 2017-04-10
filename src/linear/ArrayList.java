package linear;

/**
 * Created by bu on 4/10/2017.
 */
public class ArrayList {
    final int defaultSize = 0;
    int maxSize;   //线性表的最大长度
    int length;  //线性表当前长度
    Object[] arrayList;   //存储线性表的数组

    /*
     * 构造函数
     */
    public ArrayList(int size) {
        initList(size);
    }

    //按给定size初始化顺序表
    public void initList(int size) {
        if (size < 0) {
            throw new RuntimeException("数组大小错误：" + size);
        } else {
            this.maxSize = size;
            this.length = 0;
            this.arrayList = new Object[size];
        }
    }

    //表长
    public int length() {
        return length;
    }

    //按值查找
    public int locateElem(Object e) {
        for (int i = 0; i < length; i++) {
            if (arrayList[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //按位查找
    public Object getElem(int i) {
        if (i < 0 || i >= length) {
            throw new RuntimeException("参数出错：" + i);
        }
        if (length == 0) {
            throw new RuntimeException("顺序表为空");
        }
        return arrayList[i];
    }

    //插入
    public void insert(int i, Object e) {
        if (i < 0 || i > length + 1) {
            throw new RuntimeException("新元素插入位置有误：" + i);
        }
        if (i >= maxSize) {
            throw new RuntimeException("顺序表已满，不能再插入新的元素");
        }
        for (int j = length; j < i; j--) {
            arrayList[j] = arrayList[j - 1];
        }
        arrayList[i] = e;
        length++;
    }

    //删除
    public void delete(int i, Object e) {
        if (i < 0 || i > length - 1) {
            throw new RuntimeException("需删除元素位置有误：" + i);
        }
        if (length == 0) {
            throw new RuntimeException("顺序表为空，不能删除元素");
        }
        for (int j = i; j < length - 1; j++) {
            arrayList[j] = arrayList[j + 1];
        }
        arrayList[length - 1] = "";
        length--;
    }

    //判空
    public boolean isEmpty() {
        return length == 0 ? true : false;
    }

    //删除顺序表
    public void destroyList() {
        this.arrayList = null;
        this.length = 0;
        this.maxSize = 0;
    }
}
