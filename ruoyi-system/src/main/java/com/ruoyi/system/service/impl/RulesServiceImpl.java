package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RulesMapper;
import com.ruoyi.system.domain.Rules;
import com.ruoyi.system.service.IRulesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 校验规则Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
@Service
public class RulesServiceImpl implements IRulesService 
{
    @Autowired
    private RulesMapper rulesMapper;

    /**
     * 查询校验规则
     * 
     * @param id 校验规则主键
     * @return 校验规则
     */
    @Override
    public Rules selectRulesById(Long id)
    {
        return rulesMapper.selectRulesById(id);
    }

    /**
     * 查询校验规则列表
     * 
     * @param rules 校验规则
     * @return 校验规则
     */
    @Override
    public List<Rules> selectRulesList(Rules rules)
    {
        return rulesMapper.selectRulesList(rules);
    }

    /**
     * 新增校验规则
     * 
     * @param rules 校验规则
     * @return 结果
     */
    @Override
    public int insertRules(Rules rules)
    {
        return rulesMapper.insertRules(rules);
    }

    /**
     * 修改校验规则
     * 
     * @param rules 校验规则
     * @return 结果
     */
    @Override
    public int updateRules(Rules rules)
    {
        return rulesMapper.updateRules(rules);
    }

    /**
     * 批量删除校验规则
     * 
     * @param ids 需要删除的校验规则主键
     * @return 结果
     */
    @Override
    public int deleteRulesByIds(String ids)
    {
        return rulesMapper.deleteRulesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除校验规则信息
     * 
     * @param id 校验规则主键
     * @return 结果
     */
    @Override
    public int deleteRulesById(Long id)
    {
        return rulesMapper.deleteRulesById(id);
    }
}
