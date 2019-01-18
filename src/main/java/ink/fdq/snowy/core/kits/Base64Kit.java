package ink.fdq.snowy.core.kits;

/**
 * BASE64编码解码
 * Created by snowfigure on 2015/5/10.
 */

import java.io.UnsupportedEncodingException;

import sun.misc.*;

public class Base64Kit {
    public static void main(String[] args) {
        for (int i = 900000; i < 9000000; i++) {
            if (i % 10000 == 0) {
                System.out.println("Checked:" + i);
            }
            try {

                String _des = DesKit.encrypt(i + "");
                String _base64 = Base64Kit.getBase64(_des);
                String APPLY_ID = _base64.replaceAll("/+", "@").replaceAll("//", "#").replaceAll("=", "$");

                String __base64 = APPLY_ID.replaceAll("@", "/+").replaceAll("#", "//").replaceAll("$", "=");
                String __des = Base64Kit.getFromBase64(__base64);
                String _apply_id = DesKit.decrypt(__des);
                int apply_id = new Integer(_apply_id);
                if (i != apply_id) {
                    System.err.println("Unchecked");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Completed!");
    }

    // 加密
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String getFromBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
