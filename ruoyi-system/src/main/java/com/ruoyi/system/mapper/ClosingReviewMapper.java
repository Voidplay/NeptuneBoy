package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.ClosingReview;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
public interface ClosingReviewMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public ClosingReview selectClosingReviewById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param closingReview 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ClosingReview> selectClosingReviewList(ClosingReview closingReview);

    /**
     * 新增【请填写功能名称】
     * 
     * @param closingReview 【请填写功能名称】
     * @return 结果
     */
    public int insertClosingReview(ClosingReview closingReview);

    /**
     * 修改【请填写功能名称】
     * 
     * @param closingReview 【请填写功能名称】
     * @return 结果
     */
    public int updateClosingReview(ClosingReview closingReview);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteClosingReviewById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClosingReviewByIds(String[] ids);
}
