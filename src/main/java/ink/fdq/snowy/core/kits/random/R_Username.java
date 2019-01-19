package ink.fdq.snowy.core.kits.random;

public class R_Username extends R_Base{
    /**
     * 获取随机用户名，由 [a,z] [0,9] 以及 _ 组成
     * @param length
     * @return
     */
    public static String get_username(int length)
    {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(common_chars.charAt(R_Number.get_number(0,common_chars_len - 1)));

        sbuffer.append(generate(length - 1, username_support, username_support_len));

        return sbuffer.toString().toLowerCase();
    }
}
