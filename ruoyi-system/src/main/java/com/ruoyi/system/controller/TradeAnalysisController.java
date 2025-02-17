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
import com.ruoyi.system.domain.TradeAnalysis;
import com.ruoyi.system.service.ITradeAnalysisService;
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
@RequestMapping("/system/analysis")
public class TradeAnalysisController extends BaseController
{
    private String prefix = "system/analysis";

    @Autowired
    private ITradeAnalysisService tradeAnalysisService;

    @RequiresPermissions("system:analysis:view")
    @GetMapping()
    public String analysis()
    {
        return prefix + "/analysis";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:analysis:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TradeAnalysis tradeAnalysis)
    {
        startPage();
        List<TradeAnalysis> list = tradeAnalysisService.selectTradeAnalysisList(tradeAnalysis);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:analysis:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TradeAnalysis tradeAnalysis)
    {
        List<TradeAnalysis> list = tradeAnalysisService.selectTradeAnalysisList(tradeAnalysis);
        ExcelUtil<TradeAnalysis> util = new ExcelUtil<TradeAnalysis>(TradeAnalysis.class);
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
    @RequiresPermissions("system:analysis:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TradeAnalysis tradeAnalysis)
    {
        return toAjax(tradeAnalysisService.insertTradeAnalysis(tradeAnalysis));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:analysis:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TradeAnalysis tradeAnalysis = tradeAnalysisService.selectTradeAnalysisById(id);
        mmap.put("tradeAnalysis", tradeAnalysis);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:analysis:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TradeAnalysis tradeAnalysis)
    {
        return toAjax(tradeAnalysisService.updateTradeAnalysis(tradeAnalysis));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:analysis:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tradeAnalysisService.deleteTradeAnalysisByIds(ids));
    }
}
