package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

    @ResponseBody
    @GetMapping("/totalProfitLoss")
    public AjaxResult getTotalProfitLoss() {
        BigDecimal totalProfitLoss = positionManagementService.getTotalProfitLoss();
        return AjaxResult.success(totalProfitLoss);
    }

    @ResponseBody
    @GetMapping("/profitLossCounts")
    public AjaxResult getProfitLossCounts() {
        try {
            Map<String, Integer> profitLossCounts = positionManagementService.getProfitLossCount();
            return AjaxResult.success("盈亏次数统计成功", profitLossCounts);
        } catch (Exception e) {
            return AjaxResult.error("获取盈亏次数统计失败：" + e.getMessage());
        }
    }

    @PostMapping("/close")
    @ResponseBody
    public AjaxResult closePosition(@RequestParam Long id,
                                    @RequestParam BigDecimal profitLoss,
                                    @RequestParam BigDecimal closingPrice,
                                    @RequestParam BigDecimal closingTotalPrice,
                                    @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date closingDate) {
        // 1. 获取仓位
        PositionManagement position = positionManagementService.selectPositionManagementById(id);
        if (position == null) {
            return AjaxResult.error("仓位不存在");
        }

        // 2. 更新仓位信息
        PositionManagement SetPosition = new PositionManagement();
        SetPosition.setId(id);
        SetPosition.setIsClosed(1); // 设置为已平仓
        SetPosition.setProfitLoss(profitLoss);
        SetPosition.setClosingPrice(closingPrice);
        SetPosition.setClosingTotalPrice(closingTotalPrice);
        SetPosition.setClosingDate(closingDate);

        // 3. 保存更新
        int result = positionManagementService.updatePositionManagement(SetPosition);
        return result > 0 ? AjaxResult.success("平仓成功") : AjaxResult.error("平仓失败");
    }

    @GetMapping("/tradeAnalysis/{positionId}")
    public String tradeAnalysis(@PathVariable("positionId") Long positionId, Model model) {
        // 将 positionId 传递到前端，方便查询相关数据
        model.addAttribute("positionId", positionId);
        return "system/management/tradeAnalysis"; // 返回 tradeAnalysis.html
    }




}
