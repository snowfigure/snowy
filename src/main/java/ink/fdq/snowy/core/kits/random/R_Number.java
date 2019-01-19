package ink.fdq.snowy.core.kits.random;

public class R_Number {
    /**
     * 指定范围[min,max],获取属于此范围的随机数字
     * @param min  最小值
     * @param max  最大值
     * @return
     */
    public static int get_number(int min, int max)
    {
        java.util.Random random = new java.util.Random();

        if(min > max)
        {
            min ^= max;
            max ^= min;
            min ^= max;
        }
        int number = random.nextInt(max - min + 1) + min;

        //System.out.println(number);
        return number;
    }
}
