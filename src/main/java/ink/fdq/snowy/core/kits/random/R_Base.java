package ink.fdq.snowy.core.kits.random;

public class R_Base {
    protected static String number_chars = "0123456789";
    protected static String upper_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    protected static String lower_chars = "abcdefghijklmnopqrstuvwxyz";
    protected static String special_chars = "~!@#$%^&*.?";
    protected static char username_special_char = '_';

    protected static String common_chars = lower_chars + upper_chars + number_chars;

    protected static String username_support = common_chars + username_special_char;


    protected static String password_support = common_chars + special_chars;
    protected static String password_enhance = common_chars + "~!@#$%^&*()_+{}|:\"<>?`-=[]\\;',./";

    protected static int common_chars_len = common_chars.length();
    protected static int username_support_len = username_support.length();
    protected static int password_support_len = password_support.length();
    protected static int password_enhance_len = password_enhance.length();

    protected static char ascii_satrt = '!';
    protected static char ascii_end  = '~';
    protected static int ascii_num = (ascii_end - ascii_satrt + 1);

    /**
     * 以指定字符串为字典，生成指定长度的随机字符
     * @param length
     * @param chars_list  ASICC码下非控制类字符组成的字符串
     * @param chars_length
     * @return
     */
    protected static String generate(int length, String chars_list, int chars_length)
    {
        StringBuffer sbuffer = new StringBuffer();
        for(int i = 0; i < length; i++)
        {
            sbuffer.append(chars_list.charAt(R_Number.get_number(0,chars_length - 1)));
        }

        return sbuffer.toString();
    }
}
