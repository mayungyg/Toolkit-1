package com.xavier.toolkit;

import com.xavier.toolkit.controller.SysMenuController;
import com.xavier.toolkit.entity.SysMenu;
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
        printURL(menus);
    }

    public static void printURL(List<SysMenu> menus) {
        for(SysMenu menu : menus) {
            System.out.println(menu.getMenucode() + "\t\t" + menu.getUrl());
        }
    }
}
