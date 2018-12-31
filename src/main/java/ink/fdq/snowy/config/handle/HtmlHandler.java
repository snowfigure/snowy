package ink.fdq.snowy.config.handle;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlHandler extends Handler {

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        // 将以.html结尾的url路径进行处理，截取.html后缀
        int index = target.toLowerCase().indexOf(".html");
        if (index != -1) {
            // 从url中截取.html
            target = target.substring(0, index) + target.substring(index + 5);
        }
        next.handle(target, request, response, isHandled);
    }
}