package ink.fdq.snowy.core.kits;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class HttpDownloadKit {
    /**
     * 根据URL下载图片
     *
     * @param dir  保存文件路径
     * @param _url 下载路径
     * @param name 重命名
     * @return
     */
    public static boolean ImageDownload(String dir, String _url, String name) {
        String type = _url.substring(_url.lastIndexOf("."), _url.length());
        try {
            URL url = new URL(_url);
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            byte[] bytes = new byte[100];
            File _dir = new File(dir + "/");
            _dir.mkdirs();
            OutputStream bos = new FileOutputStream(new File(dir + "/" + name + type));
            int len;
            while ((len = bis.read(bytes)) > 0) {
                bos.write(bytes, 0, len);
            }
            bis.close();
            bos.flush();
            bos.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }

    public static void main(String[] args) {
        String url = "http://c.hiphotos.baidu.com/super/pic/item/f11f3a292df5e0fe737617935f6034a85edf7232.jpg";
        HttpDownloadKit.ImageDownload("M:/donwloadtest/test0/test1/", url, "don");
    }
}
