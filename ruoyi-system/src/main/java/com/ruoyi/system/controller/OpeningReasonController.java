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
import com.ruoyi.system.domain.OpeningReason;
import com.ruoyi.system.service.IOpeningReasonService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
@Controller
@RequestMapping("/system/openingReason")
public class OpeningReasonController extends BaseController
{
    private String prefix = "system/reason";

    @Autowired
    private IOpeningReasonService openingReasonService;

    @RequiresPermissions("system:reason:view")
    @GetMapping()
    public String reason()
    {
        return prefix + "/reason";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:reason:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpeningReason openingReason)
    {
        startPage();
        List<OpeningReason> list = openingReasonService.selectOpeningReasonList(openingReason);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:reason:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OpeningReason openingReason)
    {
        List<OpeningReason> list = openingReasonService.selectOpeningReasonList(openingReason);
        ExcelUtil<OpeningReason> util = new ExcelUtil<OpeningReason>(OpeningReason.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:reason:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OpeningReason openingReason)
    {
        return toAjax(openingReasonService.insertOpeningReason(openingReason));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:reason:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        OpeningReason openingReason = openingReasonService.selectOpeningReasonById(id);
        mmap.put("openingReason", openingReason);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:reason:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpeningReason openingReason)
    {
        return toAjax(openingReasonService.updateOpeningReason(openingReason));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:reason:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(openingReasonService.deleteOpeningReasonByIds(ids));
    }
}
