package ink.fdq.test.list;

import java.util.*;

public class Convert {
    /**
     * List 转 数组
     * @param list
     * @return
     */
    public static String[] toArray(List<String> list){
        return list.toArray(new String[0]);
    }

    /**
     * Set 转 数组
     * @param set
     * @return
     */
    public static String[] toArray(Set<String> set){
        return set.toArray(new String[0]);
    }

    /**
     * 数组 转 List
     * @param array
     * @return
     */
    public static List<String> toList(String[] array){
        return Arrays.asList(array);
    }

    /**
     * Set 转 List
     * @param set
     * @return
     */
    public static List<String> toList(Set<String> set){
        return new ArrayList<>(set);
    }

    /**
     * 数组 转 ArrayList
     * @param array
     * @return
     */
    public static ArrayList<String> toArrayList(String[] array){
        return new ArrayList<>(Arrays.asList());
    }

    /**
     * 数组 转 Set
     * @param array
     * @return
     */
    public static Set<String> toSet(String[] array){
        return new HashSet<String>(Arrays.asList(array));
    }

    /**
     * List 转 Set
     * @param list
     * @return
     */
    public static Set<String> toSet(List<String> list){
        return new HashSet<>(list);
    }

}
