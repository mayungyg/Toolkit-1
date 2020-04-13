package com.xavier.toolkit.service;

import com.xavier.toolkit.entity.SysMenu;
import com.xavier.toolkit.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuService {
    @Autowired
    SysMenuMapper sysMenuMapper;

    public List<SysMenu> getAllSysMenus() {
        return sysMenuMapper.getAllSysMenus();
    }
}
