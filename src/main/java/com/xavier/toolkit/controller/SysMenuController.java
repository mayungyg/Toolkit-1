package com.xavier.toolkit.controller;

import com.xavier.toolkit.entity.SysMenu;
import com.xavier.toolkit.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    public List<SysMenu> getAllSysMenus() {
        return sysMenuService.getAllSysMenus();
    }
}
