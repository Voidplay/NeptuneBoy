package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SysTradeAnalysis extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long analysisId;
    private String accountName;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date analysisDate;
    
    private BigDecimal totalProfit;
    private BigDecimal dailyProfit;
    private BigDecimal winRate;
    private BigDecimal maxDrawdown;
    private BigDecimal sharpeRatio;
    private BigDecimal positionValue;
    private BigDecimal cashBalance;
    private Integer tradeCount;

    public Long getAnalysisId() {
        return analysisId;
    }

    public void setAnalysisId(Long analysisId) {
        this.analysisId = analysisId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getAnalysisDate() {
        return analysisDate;
    }

    public void setAnalysisDate(Date analysisDate) {
        this.analysisDate = analysisDate;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public BigDecimal getDailyProfit() {
        return dailyProfit;
    }

    public void setDailyProfit(BigDecimal dailyProfit) {
        this.dailyProfit = dailyProfit;
    }

    public BigDecimal getWinRate() {
        return winRate;
    }

    public void setWinRate(BigDecimal winRate) {
        this.winRate = winRate;
    }

    public BigDecimal getMaxDrawdown() {
        return maxDrawdown;
    }

    public void setMaxDrawdown(BigDecimal maxDrawdown) {
        this.maxDrawdown = maxDrawdown;
    }

    public BigDecimal getSharpeRatio() {
        return sharpeRatio;
    }

    public void setSharpeRatio(BigDecimal sharpeRatio) {
        this.sharpeRatio = sharpeRatio;
    }

    public BigDecimal getPositionValue() {
        return positionValue;
    }

    public void setPositionValue(BigDecimal positionValue) {
        this.positionValue = positionValue;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    @Override
    public String toString() {
        return "SysTradeAnalysis{" +
                "analysisId=" + analysisId +
                ", accountName='" + accountName + '\'' +
                ", analysisDate=" + analysisDate +
                ", totalProfit=" + totalProfit +
                ", dailyProfit=" + dailyProfit +
                ", winRate=" + winRate +
                ", maxDrawdown=" + maxDrawdown +
                ", sharpeRatio=" + sharpeRatio +
                ", positionValue=" + positionValue +
                ", cashBalance=" + cashBalance +
                ", tradeCount=" + tradeCount +
                '}';
    }
}
