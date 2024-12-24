package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PositionManagement;
import com.ruoyi.system.service.IPositionManagementService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓位管理，用于记录正股和期权的仓位详情Controller
 * 
 * @author ruoyi
 * @date 2024-12-24
 */
@Controller
@RequestMapping("/system/management")
public class PositionManagementController extends BaseController
{
    private String prefix = "system/management";

    @Autowired
    private IPositionManagementService positionManagementService;

    @RequiresPermissions("system:management:view")
    @GetMapping()
    public String management()
    {
        return prefix + "/management";
    }

    /**
     * 查询仓位管理，用于记录正股和期权的仓位详情列表
     */
    @RequiresPermissions("system:management:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PositionManagement positionManagement)
    {
        startPage();
        List<PositionManagement> list = positionManagementService.selectPositionManagementList(positionManagement);
        return getDataTable(list);
    }

    /**
     * 导出仓位管理，用于记录正股和期权的仓位详情列表
     */
    @RequiresPermissions("system:management:export")
    @Log(title = "仓位管理，用于记录正股和期权的仓位详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PositionManagement positionManagement)
    {
        List<PositionManagement> list = positionManagementService.selectPositionManagementList(positionManagement);
        ExcelUtil<PositionManagement> util = new ExcelUtil<PositionManagement>(PositionManagement.class);
        return util.exportExcel(list, "仓位管理，用于记录正股和期权的仓位详情数据");
    }

    /**
     * 新增仓位管理，用于记录正股和期权的仓位详情
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓位管理，用于记录正股和期权的仓位详情
     */
    @RequiresPermissions("system:management:add")
    @Log(title = "仓位管理，用于记录正股和期权的仓位详情", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PositionManagement positionManagement)
    {
        return toAjax(positionManagementService.insertPositionManagement(positionManagement));
    }

    /**
     * 修改仓位管理，用于记录正股和期权的仓位详情
     */
    @RequiresPermissions("system:management:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PositionManagement positionManagement = positionManagementService.selectPositionManagementById(id);
        mmap.put("positionManagement", positionManagement);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓位管理，用于记录正股和期权的仓位详情
     */
    @RequiresPermissions("system:management:edit")
    @Log(title = "仓位管理，用于记录正股和期权的仓位详情", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PositionManagement positionManagement)
    {
        return toAjax(positionManagementService.updatePositionManagement(positionManagement));
    }

    /**
     * 删除仓位管理，用于记录正股和期权的仓位详情
     */
    @RequiresPermissions("system:management:remove")
    @Log(title = "仓位管理，用于记录正股和期权的仓位详情", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(positionManagementService.deletePositionManagementByIds(ids));
    }
}
