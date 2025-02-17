package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClosingReviewMapper;
import com.ruoyi.system.domain.ClosingReview;
import com.ruoyi.system.service.IClosingReviewService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
@Service
public class ClosingReviewServiceImpl implements IClosingReviewService 
{
    @Autowired
    private ClosingReviewMapper closingReviewMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public ClosingReview selectClosingReviewById(Long id)
    {
        return closingReviewMapper.selectClosingReviewById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param closingReview 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ClosingReview> selectClosingReviewList(ClosingReview closingReview)
    {
        return closingReviewMapper.selectClosingReviewList(closingReview);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param closingReview 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertClosingReview(ClosingReview closingReview)
    {
        return closingReviewMapper.insertClosingReview(closingReview);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param closingReview 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateClosingReview(ClosingReview closingReview)
    {
        return closingReviewMapper.updateClosingReview(closingReview);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteClosingReviewByIds(String ids)
    {
        return closingReviewMapper.deleteClosingReviewByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteClosingReviewById(Long id)
    {
        return closingReviewMapper.deleteClosingReviewById(id);
    }
}
