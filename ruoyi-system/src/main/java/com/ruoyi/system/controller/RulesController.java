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
import com.ruoyi.system.domain.Rules;
import com.ruoyi.system.service.IRulesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 校验规则Controller
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Controller
@RequestMapping("/system/rules")
public class RulesController extends BaseController
{
    private String prefix = "system/rules";

    @Autowired
    private IRulesService rulesService;

    @RequiresPermissions("system:rules:view")
    @GetMapping()
    public String rules()
    {
        return prefix + "/rules";
    }

    /**
     * 查询校验规则列表
     */
    @RequiresPermissions("system:rules:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Rules rules)
    {
        startPage();
        List<Rules> list = rulesService.selectRulesList(rules);
        return getDataTable(list);
    }

    /**
     * 导出校验规则列表
     */
    @RequiresPermissions("system:rules:export")
    @Log(title = "校验规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Rules rules)
    {
        List<Rules> list = rulesService.selectRulesList(rules);
        ExcelUtil<Rules> util = new ExcelUtil<Rules>(Rules.class);
        return util.exportExcel(list, "校验规则数据");
    }

    /**
     * 新增校验规则
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存校验规则
     */
    @RequiresPermissions("system:rules:add")
    @Log(title = "校验规则", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Rules rules)
    {
        return toAjax(rulesService.insertRules(rules));
    }

    /**
     * 修改校验规则
     */
    @RequiresPermissions("system:rules:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Rules rules = rulesService.selectRulesById(id);
        mmap.put("rules", rules);
        return prefix + "/edit";
    }

    /**
     * 修改保存校验规则
     */
    @RequiresPermissions("system:rules:edit")
    @Log(title = "校验规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Rules rules)
    {
        return toAjax(rulesService.updateRules(rules));
    }

    /**
     * 删除校验规则
     */
    @RequiresPermissions("system:rules:remove")
    @Log(title = "校验规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(rulesService.deleteRulesByIds(ids));
    }
}
