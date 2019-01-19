package ink.fdq.snowy.core.kits;

public class IdKit {
    /**
     * 生成UUID   ad8e7a3d-b77a-47b1-91b1-0800a92a88e0 或者 8187c69fe45d434c8978e118f96ba00a
     * @param with_split_symbol  是否包含分隔符 -
     * @return
     */
    public static String getUUID(boolean with_split_symbol)
    {
        String uuid = java.util.UUID.randomUUID().toString();

        if(with_split_symbol)
        {
            return uuid;
        }

        return uuid.replaceAll("-", "");
    }

    /**
     * 生成常规uuid，如 ad8e7a3d-b77a-47b1-91b1-0800a92a88e0
     * @return
     */
    public static String getUUID()
    {
        return getUUID(true);
    }

    /**
     * 生成类似token的uuid字符串 2b82df97189d43eb9e92936ed6755173
     * @return
     */
    public static String getUUIDToken()
    {
        return getUUID(false);
    }

    /**
     * 随机获取一组uuid或者token
     * @param uuid_num
     * @param with_split_symbol
     * @return
     */
    public static java.util.List<String> getUUIDList(int uuid_num, boolean with_split_symbol)
    {
        java.util.List<String> uuid_list = new java.util.ArrayList<String>();

        if(uuid_num < 1)
        {
            return uuid_list;
        }

        for(int index =0 ; index < uuid_num; index++)
        {
            uuid_list.add(getUUID(with_split_symbol));
        }

        return uuid_list;
    }

    /**
     * 随机获取一组uuid
     * @param uuid_num
     * @return
     */
    public static java.util.List<String> getUUIDList(int uuid_num)
    {
        return getUUIDList(uuid_num, true);
    }

    /**
     * 随机获取一组uuid
     * @param uuid_num
     * @return
     */
    public static java.util.List<String> getUUIDTokenList(int uuid_num)
    {
        return getUUIDList(uuid_num, false);
    }
}
