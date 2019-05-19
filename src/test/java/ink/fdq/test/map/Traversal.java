package ink.fdq.test.map;

import java.util.Iterator;
import java.util.Map;

public class Traversal {
    /**
     * 这是最常见的并且在大多数情况下也是最可取的遍历方式。在键值都需要时使用。
     * @param map
     */
    public void funcOne(Map<Integer, Integer> map){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    /**
     * 如果只需要map中的键或者值，你可以通过keySet或values来实现遍历，而不是用entrySet。
     * 该方法比entrySet遍历在性能上稍好（快了10%），而且代码更加干净。
     *
     * 如果仅需要键(keys)或值(values)使用方法二。
     * @param map
     */
    public void funcTwo(Map<Integer, Integer> map){
        //遍历map中的键
        for (Integer key : map.keySet()) {
            System.out.println("Key = " + key);
        }
        //遍历map中的值
        for (Integer value : map.values()) {
            System.out.println("Value = " + value);
        }
    }

    /**
     * 使用Iterator遍历,使用泛型
     *你也可以在keySet和values上应用同样的方法。
     *
     * 该种方式看起来冗余却有其优点所在。
     * 首先，在老版本java中这是惟一遍历map的方式。
     * 另一个好处是，你可以在遍历时调用iterator.remove()来删除entries，另两个方法则不能。
     * 根据javadoc的说明，如果在for-each遍历中尝试使用此方法，结果是不可预测的。
     * @param map
     */
    public void funcThree(Map<Integer, Integer> map){
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    /**
     * 使用Iterator遍历,不使用泛型
     *
     * 如果你使用的语言版本低于java 5，或是打算在遍历时删除entries，必须使用方法三、四。
     * @param map
     */
    public void funcFour(Map<Integer, Integer> map){
        Iterator entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Integer key = (Integer)entry.getKey();
            Integer value = (Integer)entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }
    }

    /**
     * 作为方法一的替代，这个代码看上去更加干净；
     * 但实际上它相当慢且无效率。
     * 因为从键取值是耗时的操作（与方法一相比，在不同的Map实现中该方法慢了20%~200%）。
     * 如果你安装了FindBugs，它会做出检查并警告你关于哪些是低效率的遍历。所以尽量避免使用。
     * @param map
     */
    public void funcFive(Map<Integer, Integer> map){
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println("Key = " + key + ", Value = " + value);
        }
    }


}
