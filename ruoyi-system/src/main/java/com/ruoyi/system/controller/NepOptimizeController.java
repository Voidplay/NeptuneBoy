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
import com.ruoyi.system.domain.NepOptimize;
import com.ruoyi.system.service.INepOptimizeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统优化Controller
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Controller
@RequestMapping("/system/optimize")
public class NepOptimizeController extends BaseController
{
    private String prefix = "system/optimize";

    @Autowired
    private INepOptimizeService nepOptimizeService;

    @RequiresPermissions("system:optimize:view")
    @GetMapping()
    public String optimize()
    {
        return prefix + "/optimize";
    }

    /**
     * 查询系统优化列表
     */
    @RequiresPermissions("system:optimize:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NepOptimize nepOptimize)
    {
        startPage();
        List<NepOptimize> list = nepOptimizeService.selectNepOptimizeList(nepOptimize);
        return getDataTable(list);
    }

    /**
     * 导出系统优化列表
     */
    @RequiresPermissions("system:optimize:export")
    @Log(title = "系统优化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NepOptimize nepOptimize)
    {
        List<NepOptimize> list = nepOptimizeService.selectNepOptimizeList(nepOptimize);
        ExcelUtil<NepOptimize> util = new ExcelUtil<NepOptimize>(NepOptimize.class);
        return util.exportExcel(list, "系统优化数据");
    }

    /**
     * 新增系统优化
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存系统优化
     */
    @RequiresPermissions("system:optimize:add")
    @Log(title = "系统优化", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NepOptimize nepOptimize)
    {
        return toAjax(nepOptimizeService.insertNepOptimize(nepOptimize));
    }

    /**
     * 修改系统优化
     */
    @RequiresPermissions("system:optimize:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        NepOptimize nepOptimize = nepOptimizeService.selectNepOptimizeById(id);
        mmap.put("nepOptimize", nepOptimize);
        return prefix + "/edit";
    }

    /**
     * 修改保存系统优化
     */
    @RequiresPermissions("system:optimize:edit")
    @Log(title = "系统优化", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NepOptimize nepOptimize)
    {
        return toAjax(nepOptimizeService.updateNepOptimize(nepOptimize));
    }

    /**
     * 删除系统优化
     */
    @RequiresPermissions("system:optimize:remove")
    @Log(title = "系统优化", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(nepOptimizeService.deleteNepOptimizeByIds(ids));
    }
}
