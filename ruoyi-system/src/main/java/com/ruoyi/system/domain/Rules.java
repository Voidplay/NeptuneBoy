package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 校验规则对象 rules
 * 
 * @author ruoyi
 * @date 2024-12-31
 */
public class Rules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 规则唯一标识，主键 */
    private Long id;

    /** 规则名称 */
    @Excel(name = "规则名称")
    private String ruleName;

    /** 规则类型 */
    @Excel(name = "规则类型")
    private String ruleType;

    /** 交易类型 */
    @Excel(name = "交易类型")
    private String tradeType;

    /** 规则描述 */
    @Excel(name = "规则描述")
    private String ruleDesc;

    /** 触发校验报错 */
    @Excel(name = "触发校验报错")
    private String errorMessage;

    /** 是否启用 */
    @Excel(name = "是否启用")
    private Integer isActive;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setRuleName(String ruleName) 
    {
        this.ruleName = ruleName;
    }

    public String getRuleName() 
    {
        return ruleName;
    }

    public void setRuleType(String ruleType) 
    {
        this.ruleType = ruleType;
    }

    public String getRuleType() 
    {
        return ruleType;
    }

    public void setTradeType(String tradeType) 
    {
        this.tradeType = tradeType;
    }

    public String getTradeType() 
    {
        return tradeType;
    }

    public void setRuleDesc(String ruleDesc) 
    {
        this.ruleDesc = ruleDesc;
    }

    public String getRuleDesc() 
    {
        return ruleDesc;
    }

    public void setErrorMessage(String errorMessage) 
    {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() 
    {
        return errorMessage;
    }

    public void setIsActive(Integer isActive) 
    {
        this.isActive = isActive;
    }

    public Integer getIsActive() 
    {
        return isActive;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ruleName", getRuleName())
            .append("ruleType", getRuleType())
            .append("tradeType", getTradeType())
            .append("ruleDesc", getRuleDesc())
            .append("errorMessage", getErrorMessage())
            .append("isActive", getIsActive())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
