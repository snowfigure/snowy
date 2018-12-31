package ink.fdq.snowy.controller.test;

import ink.fdq.snowy.controller.GlobalController;
import ink.fdq.snowy.util.factory.P;
import ink.fdq.snowy.util.factory.S;

import java.util.HashMap;
import java.util.Map;

public class TestIndexController extends GlobalController {

    public void showDevInfoText(){
        String text = String.format("DevMode:%s \r\n URL:%s \r\n Version:%s \r\n Msg:%s",
                P.DEV_MODE,
                P.SERVER,
                S.VERSION,
                "Hello");
        renderText(text);
    }

    public void showDevInfoJson(){
        Map<String, Object> map = new HashMap<>();
        map.put("DevMode", P.DEV_MODE);
        map.put("URL", P.SERVER);
        map.put("Version", S.VERSION);
        map.put("Msg", "Hello");

        renderJson(map);
    }
}
