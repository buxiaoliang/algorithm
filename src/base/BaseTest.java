package base;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;
import com.sun.deploy.util.ArrayUtil;

import java.util.*;

/**
 * Created by bur on 2018/11/14.
 */
public class BaseTest {
    public static void main(String[] args) {
        // -------------------------- Array -----------------------------------
        // array example
        int[] array = new int[10];
        array[1] = 1;
        array[2] = 2;
        for (int ele : array) {
            System.out.println("Array example:" + ele);
        }
        // array example1
        int[] array_1 = {1, 2, 3};
        for (int i = 0; i < array_1.length; i++) {
            System.out.println("Array example1:" + array_1[i]);
        }
        // array example2:two-dimension
        int arr[][] = new int[][]{{1}, {2, 3}, {4, 5, 6}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Array example2:" + arr[i][j]);
            }
        }
        // array example3:two-dimension
        for (int[] x : arr) {
            for (int y : x) {
                System.out.println("Array example3:" + y);
            }
        }
        // Arrays???
        Arrays.asList(arr);
        // -------------------------- Map -----------------------------------
        // Map example
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "Alice");
        map.put("2", "Susan");
        map.put("3", "Tom");
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> mapEntry = iterator.next();
            System.out.println("Map example:" + "key:" + mapEntry.getKey() + " value:" + mapEntry.getValue());
        }
        Set<String> keySet = map.keySet();
        for (String ks : keySet) {
            System.out.println("Map example1 key:" + ks);
        }
        Collection<String> valueSet = map.values();
        for (String value : valueSet) {
            System.out.println("Map example1 value:" + value);
        }
        // -------------------------- List -----------------------------------
        List<String> list = new ArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        Iterator<String> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            String listEle = iterator1.next();
            System.out.println("List example key:" + listEle);
        }
        // -------------------------- Set -----------------------------------
        // -------------------------- Sort -----------------------------------
        // two ways:
        // 1) implement Comparable interface and rewrite compareTo method
        User user1 = new User();
        user1.setName("a");
        user1.setOrder(1);
        User user2 = new User();
        user2.setName("b");
        user2.setOrder(2);
        List<User> list1 = new ArrayList<User>();
        list1.add(user2);
        list1.add(user1);
        Collections.sort(list);
        for (User u : list1) {
            System.out.println("sort example:" + u.getName());
        }
        // 2) implement Comparator
        User user3 = new User();
        user3.setName("a");
        user3.setOrder(11);
        User user4 = new User();
        user4.setName("b");
        user4.setOrder(2);

        Set<User> Hset = new HashSet<User>();
        Hset.add(user4);
        Hset.add(user3);

        List<User> list2 = new ArrayList<User>();
        list2.addAll(Hset);


        Collections.sort(list2, new Comparator<User>() {
            public int compare(User arg0, User arg1) {
                return arg0.getOrder().compareTo(arg1.getOrder());
            }
        });
        for (User u : list2) {
            System.out.println("sort example2:" + u.getName());
        }

    }
}