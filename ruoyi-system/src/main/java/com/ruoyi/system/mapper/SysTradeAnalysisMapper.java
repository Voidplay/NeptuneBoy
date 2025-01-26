package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTradeAnalysis;

public interface SysTradeAnalysisMapper {
    public List<SysTradeAnalysis> selectTradeAnalysisList(SysTradeAnalysis analysis);
    
    public List<SysTradeAnalysis> selectDailyProfitTrend(SysTradeAnalysis analysis);
    
    public List<SysTradeAnalysis> selectPositionValueTrend(SysTradeAnalysis analysis);
    
    public SysTradeAnalysis selectLatestAnalysis(String accountName);
    
    public int insertTradeAnalysis(SysTradeAnalysis analysis);
    
    public int updateTradeAnalysis(SysTradeAnalysis analysis);
}
