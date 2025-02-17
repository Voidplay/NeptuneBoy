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
import com.ruoyi.system.domain.ClosingReview;
import com.ruoyi.system.service.IClosingReviewService;
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
@RequestMapping("/system/closingReview")
public class ClosingReviewController extends BaseController
{
    private String prefix = "system/review";

    @Autowired
    private IClosingReviewService closingReviewService;

    @RequiresPermissions("system:review:view")
    @GetMapping()
    public String review()
    {
        return prefix + "/review";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:review:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ClosingReview closingReview)
    {
        startPage();
        List<ClosingReview> list = closingReviewService.selectClosingReviewList(closingReview);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:review:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ClosingReview closingReview)
    {
        List<ClosingReview> list = closingReviewService.selectClosingReviewList(closingReview);
        ExcelUtil<ClosingReview> util = new ExcelUtil<ClosingReview>(ClosingReview.class);
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
    @RequiresPermissions("system:review:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ClosingReview closingReview)
    {
        return toAjax(closingReviewService.insertClosingReview(closingReview));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:review:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ClosingReview closingReview = closingReviewService.selectClosingReviewById(id);
        mmap.put("closingReview", closingReview);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:review:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ClosingReview closingReview)
    {
        return toAjax(closingReviewService.updateClosingReview(closingReview));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:review:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(closingReviewService.deleteClosingReviewByIds(ids));
    }
}
