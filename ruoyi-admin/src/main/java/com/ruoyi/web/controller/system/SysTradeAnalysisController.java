package com.ruoyi.web.controller.system;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysTradeAnalysis;
import com.ruoyi.system.service.ISysTradeAnalysisService;

@Controller
@RequestMapping("/system/analysis")
public class SysTradeAnalysisController extends BaseController {
    private String prefix = "system/analysis";

    @Autowired
    private ISysTradeAnalysisService tradeAnalysisService;

    @RequiresPermissions("system:analysis:view")
    @GetMapping()
    public String analysis() {
        return prefix + "/analysis";
    }

    @RequiresPermissions("system:analysis:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysTradeAnalysis analysis) {
        startPage();
        List<SysTradeAnalysis> list = tradeAnalysisService.selectTradeAnalysisList(analysis);
        return getDataTable(list);
    }

    @RequiresPermissions("system:analysis:dailyProfit")
    @GetMapping("/dailyProfit")
    @ResponseBody
    public AjaxResult getDailyProfitTrend(SysTradeAnalysis analysis) {
        List<SysTradeAnalysis> list = tradeAnalysisService.selectDailyProfitTrend(analysis);
        return AjaxResult.success(list);
    }

    @RequiresPermissions("system:analysis:positionValue")
    @GetMapping("/positionValue")
    @ResponseBody
    public AjaxResult getPositionValueTrend(SysTradeAnalysis analysis) {
        List<SysTradeAnalysis> list = tradeAnalysisService.selectPositionValueTrend(analysis);
        return AjaxResult.success(list);
    }

    @RequiresPermissions("system:analysis:latest")
    @GetMapping("/latest/{accountName}")
    @ResponseBody
    public AjaxResult getLatestAnalysis(@PathVariable("accountName") String accountName) {
        return AjaxResult.success(tradeAnalysisService.selectLatestAnalysis(accountName));
    }
}
