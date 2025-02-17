package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TradeAnalysis;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
public interface TradeAnalysisMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TradeAnalysis selectTradeAnalysisById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tradeAnalysis 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TradeAnalysis> selectTradeAnalysisList(TradeAnalysis tradeAnalysis);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tradeAnalysis 【请填写功能名称】
     * @return 结果
     */
    public int insertTradeAnalysis(TradeAnalysis tradeAnalysis);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tradeAnalysis 【请填写功能名称】
     * @return 结果
     */
    public int updateTradeAnalysis(TradeAnalysis tradeAnalysis);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTradeAnalysisById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTradeAnalysisByIds(String[] ids);
}
