package com.xavier.toolkit;

import com.xavier.toolkit.controller.SysMenuController;
import com.xavier.toolkit.entity.SysMenu;
import com.xavier.toolkit.util.URLDetect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@MapperScan(value={"com.xavier.toolkit.mapper"})
public class ToolkitApplication {

    @Autowired
    private  SysMenuController sysMenuController;

    public static void main(String[] args) {
        ApplicationContext applicationContext =SpringApplication.run(ToolkitApplication.class, args);
        SysMenuController sysMenuController=(SysMenuController)applicationContext.getBean("sysMenuController");
        List<SysMenu> menus = sysMenuController.getAllSysMenus();
        updateMenuURLs(menus);
        URLDetect urlDetect = new URLDetect(menus);
        for(SysMenu menu : menus) {
            urlDetect.checkAvailable(menu);
        }
    }

    public static void updateMenuURLs(List<SysMenu> menus) {
        for(SysMenu menu : menus) {
            if (menu.getUrl() == null) continue;
            menu.setUrl("http://localhost:8080/report"+menu.getUrl());
        }
    }
}
