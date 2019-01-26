package ink.fdq.snowy.core.vo.json;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private String id;
    private String pid;
    private String name;
    private String iconClass;
    private String url;
    private List<Menu> subMenu;

    public Menu() {
    }



    public Menu(String id, String name, String iconClass) {
        this.id = id;
        this.name = name;
        this.iconClass = iconClass;
        this.url="";
        this.subMenu = new ArrayList<>();
    }

    public Menu(String id, String name, String iconClass, String url) {
        this.id = id;
        this.name = name;
        this.iconClass = iconClass;
        this.url = url;
        this.subMenu = new ArrayList<>();
    }

    public Menu(String id, String name, String iconClass, List<Menu> subMenu) {
        this.id = id;
        this.name = name;
        this.iconClass = iconClass;
        this.subMenu = subMenu;
        this.url="";
    }

    public Menu(String id, String name, String iconClass, String url, List<Menu> subMenu) {
        this.id = id;
        this.name = name;
        this.iconClass = iconClass;
        this.url = url;
        this.subMenu = subMenu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void addSubMenu(Menu subMenu){
        if(this.subMenu == null){
            this.subMenu = new ArrayList<>();
        }

        this.subMenu.add(subMenu);
    }
}
