package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统优化对象 nep_optimize
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public class NepOptimize extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 是否完成 */
    @Excel(name = "是否完成")
    private String isDone;

    /** 优化想法详情 */
    @Excel(name = "优化想法详情")
    private String detail;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    /** 优化想法标题 */
    @Excel(name = "优化想法标题")
    private String optimizeName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setIsDone(String isDone) 
    {
        this.isDone = isDone;
    }

    public String getIsDone() 
    {
        return isDone;
    }

    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
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

    public void setOptimizeName(String optimizeName) 
    {
        this.optimizeName = optimizeName;
    }

    public String getOptimizeName() 
    {
        return optimizeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isDone", getIsDone())
            .append("detail", getDetail())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .append("optimizeName", getOptimizeName())
            .toString();
    }
}
