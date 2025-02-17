package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.OpeningReasonMapper;
import com.ruoyi.system.domain.OpeningReason;
import com.ruoyi.system.service.IOpeningReasonService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
@Service
public class OpeningReasonServiceImpl implements IOpeningReasonService 
{
    @Autowired
    private OpeningReasonMapper openingReasonMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public OpeningReason selectOpeningReasonById(Long id)
    {
        return openingReasonMapper.selectOpeningReasonById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param openingReason 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<OpeningReason> selectOpeningReasonList(OpeningReason openingReason)
    {
        return openingReasonMapper.selectOpeningReasonList(openingReason);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param openingReason 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertOpeningReason(OpeningReason openingReason)
    {
        return openingReasonMapper.insertOpeningReason(openingReason);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param openingReason 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateOpeningReason(OpeningReason openingReason)
    {
        return openingReasonMapper.updateOpeningReason(openingReason);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOpeningReasonByIds(String ids)
    {
        return openingReasonMapper.deleteOpeningReasonByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteOpeningReasonById(Long id)
    {
        return openingReasonMapper.deleteOpeningReasonById(id);
    }
}
