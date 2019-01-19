package ink.fdq.snowy.core.kits.random;

public class R_Password extends R_Base {
    /**
     * 获取加强版的密码 0~9 A-Z a-z ~!@#$%^&*()_+{}|:"< >?`-=[]\;',./
     * @param length
     * @return
     */
    public static String get_password_enhance(int length)
    {
        return generate(length, password_enhance, password_enhance_len);
    }



    /**
     * 随机生成由 [a,z] [A,Z], [0,9] 以及   ~！@#￥%……&*.?  组成的指定长度密码字符串
     * @param length
     * @return
     */
    public static String get_password(int length)
    {
        return generate(length, password_support, password_support_len);
    }

    /**
     * 随机生成由 [a,z] [A,Z], [0,9] 组成的指定长度密码字符串
     * @param length
     * @return
     */
    public static String get_password_common(int length)
    {
        return get_string_common(length);
    }

    /**
     * 随机生成由 [a,z] [A,Z], [0,9] 组成的指定长度字符串
     * @param length
     * @return
     */
    public static String get_string_common(int length)
    {
        return generate(length, common_chars, common_chars_len);
    }
}
