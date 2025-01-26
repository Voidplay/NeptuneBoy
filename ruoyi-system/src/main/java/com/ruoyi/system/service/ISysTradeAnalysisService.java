package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysTradeAnalysis;

public interface ISysTradeAnalysisService {
    public List<SysTradeAnalysis> selectTradeAnalysisList(SysTradeAnalysis analysis);
    
    public List<SysTradeAnalysis> selectDailyProfitTrend(SysTradeAnalysis analysis);
    
    public List<SysTradeAnalysis> selectPositionValueTrend(SysTradeAnalysis analysis);
    
    public SysTradeAnalysis selectLatestAnalysis(String accountName);
    
    public int insertTradeAnalysis(SysTradeAnalysis analysis);
    
    public int updateTradeAnalysis(SysTradeAnalysis analysis);
    
    public void generateDailyAnalysis(String accountName);
}
