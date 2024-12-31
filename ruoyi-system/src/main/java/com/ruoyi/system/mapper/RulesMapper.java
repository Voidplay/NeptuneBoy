package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Rules;

/**
 * 校验规则Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public interface RulesMapper 
{
    /**
     * 查询校验规则
     * 
     * @param id 校验规则主键
     * @return 校验规则
     */
    public Rules selectRulesById(Long id);

    /**
     * 查询校验规则列表
     * 
     * @param rules 校验规则
     * @return 校验规则集合
     */
    public List<Rules> selectRulesList(Rules rules);

    /**
     * 新增校验规则
     * 
     * @param rules 校验规则
     * @return 结果
     */
    public int insertRules(Rules rules);

    /**
     * 修改校验规则
     * 
     * @param rules 校验规则
     * @return 结果
     */
    public int updateRules(Rules rules);

    /**
     * 删除校验规则
     * 
     * @param id 校验规则主键
     * @return 结果
     */
    public int deleteRulesById(Long id);

    /**
     * 批量删除校验规则
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRulesByIds(String[] ids);
}
