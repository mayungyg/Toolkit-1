package com.xavier.toolkit.mapper;

import com.xavier.toolkit.entity.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuMapper {
    public List<SysMenu> getAllSysMenus();
}
