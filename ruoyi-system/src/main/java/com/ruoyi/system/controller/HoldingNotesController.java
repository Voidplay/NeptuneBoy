package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.HoldingNotes;
import com.ruoyi.system.service.IHoldingNotesService;
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
@RequestMapping("/system/holdingRecord")
public class HoldingNotesController extends BaseController
{
    private String prefix = "system/notes";

    @Autowired
    private IHoldingNotesService holdingNotesService;

    @RequiresPermissions("system:notes:view")
    @GetMapping()
    public String notes()
    {
        return prefix + "/notes";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:notes:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HoldingNotes holdingNotes)
    {
        startPage();
        List<HoldingNotes> list = holdingNotesService.selectHoldingNotesList(holdingNotes);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:notes:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HoldingNotes holdingNotes)
    {
        List<HoldingNotes> list = holdingNotesService.selectHoldingNotesList(holdingNotes);
        ExcelUtil<HoldingNotes> util = new ExcelUtil<HoldingNotes>(HoldingNotes.class);
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
    @RequiresPermissions("system:notes:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HoldingNotes holdingNotes)
    {
        return toAjax(holdingNotesService.insertHoldingNotes(holdingNotes));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:notes:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HoldingNotes holdingNotes = holdingNotesService.selectHoldingNotesById(id);
        mmap.put("holdingNotes", holdingNotes);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:notes:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HoldingNotes holdingNotes)
    {
        return toAjax(holdingNotesService.updateHoldingNotes(holdingNotes));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:notes:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(holdingNotesService.deleteHoldingNotesByIds(ids));
    }

    /**
     * 根据 positionId 查询持仓时记录
     */
    @GetMapping("/getByPositionId")
    @ResponseBody
    public AjaxResult getByPositionId(@RequestParam("positionId") Long positionId) {
        HoldingNotes holdingNotes = holdingNotesService.selectHoldingNotesByPositionId(positionId);
        if (holdingNotes != null) {
            return AjaxResult.success(holdingNotes);
        } else {
            return AjaxResult.error("未找到对应的持仓时记录");
        }
    }
}
