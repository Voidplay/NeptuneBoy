package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TradeAnalysisMapper;
import com.ruoyi.system.domain.TradeAnalysis;
import com.ruoyi.system.service.ITradeAnalysisService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
@Service
public class TradeAnalysisServiceImpl implements ITradeAnalysisService 
{
    @Autowired
    private TradeAnalysisMapper tradeAnalysisMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public TradeAnalysis selectTradeAnalysisById(Long id)
    {
        return tradeAnalysisMapper.selectTradeAnalysisById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tradeAnalysis 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TradeAnalysis> selectTradeAnalysisList(TradeAnalysis tradeAnalysis)
    {
        return tradeAnalysisMapper.selectTradeAnalysisList(tradeAnalysis);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tradeAnalysis 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTradeAnalysis(TradeAnalysis tradeAnalysis)
    {
        return tradeAnalysisMapper.insertTradeAnalysis(tradeAnalysis);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tradeAnalysis 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTradeAnalysis(TradeAnalysis tradeAnalysis)
    {
        return tradeAnalysisMapper.updateTradeAnalysis(tradeAnalysis);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTradeAnalysisByIds(String ids)
    {
        return tradeAnalysisMapper.deleteTradeAnalysisByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteTradeAnalysisById(Long id)
    {
        return tradeAnalysisMapper.deleteTradeAnalysisById(id);
    }
}
