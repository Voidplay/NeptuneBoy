package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓位管理，用于记录正股和期权的仓位详情对象 position_management
 * 
 * @author ruoyi
 * @date 2024-12-24
 */
public class PositionManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 账户名称，即券商名字，例如: Robinhood, Interactive Brokers */
    @Excel(name = "账户名称，即券商名字，例如: Robinhood, Interactive Brokers")
    private String accountName;

    /** 交易类型，STOCK表示正股，OPTION表示期权 */
    @Excel(name = "交易类型，STOCK表示正股，OPTION表示期权")
    private String tradeType;

    /** 交易标的代码，例如AAPL、TSLA */
    @Excel(name = "交易标的代码，例如AAPL、TSLA")
    private String tickerSymbol;

    /** 交易日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "交易日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tradeDate;

    /** 交易方向，BUY表示买入，SELL表示卖出 */
    @Excel(name = "交易方向，BUY表示买入，SELL表示卖出")
    private String tradeDirection;

    /** 交易数量 */
    @Excel(name = "交易数量")
    private Long quantity;

    /** 交易单价 */
    @Excel(name = "交易单价")
    private BigDecimal price;

    /** 交易总价，数量乘以价格 */
    @Excel(name = "交易总价，数量乘以价格")
    private BigDecimal totalPrice;

    /** 是否已平仓，FALSE表示未平仓，TRUE表示已平仓 */
    @Excel(name = "是否已平仓，FALSE表示未平仓，TRUE表示已平仓")
    private Integer isClosed;

    /** 期权策略，例如裸买、买入跨式等 */
    @Excel(name = "期权策略，例如裸买、买入跨式等")
    private String optionStrategy;

    /** 盈亏金额 */
    @Excel(name = "盈亏金额")
    private BigDecimal profitLoss;

    /** 是否盈利，盈亏金额大于0为盈利 */
    @Excel(name = "是否盈利，盈亏金额大于0为盈利")
    private String isProfitable;

    /** 平仓单价 */
    @Excel(name = "平仓单价")
    private BigDecimal closingPrice;

    /** 平仓总价 */
    @Excel(name = "平仓总价")
    private BigDecimal closingTotalPrice;

    /** 平仓日期 */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @Excel(name = "平仓日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date closingDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setAccountName(String accountName) 
    {
        this.accountName = accountName;
    }

    public String getAccountName() 
    {
        return accountName;
    }

    public void setTradeType(String tradeType) 
    {
        this.tradeType = tradeType;
    }

    public String getTradeType() 
    {
        return tradeType;
    }

    public void setTickerSymbol(String tickerSymbol) 
    {
        this.tickerSymbol = tickerSymbol;
    }

    public String getTickerSymbol() 
    {
        return tickerSymbol;
    }

    public void setTradeDate(Date tradeDate) 
    {
        this.tradeDate = tradeDate;
    }

    public Date getTradeDate() 
    {
        return tradeDate;
    }

    public void setTradeDirection(String tradeDirection) 
    {
        this.tradeDirection = tradeDirection;
    }

    public String getTradeDirection() 
    {
        return tradeDirection;
    }

    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }

    public void setIsClosed(Integer isClosed) 
    {
        this.isClosed = isClosed;
    }

    public Integer getIsClosed() 
    {
        return isClosed;
    }

    public void setOptionStrategy(String optionStrategy) 
    {
        this.optionStrategy = optionStrategy;
    }

    public String getOptionStrategy() 
    {
        return optionStrategy;
    }

    public void setProfitLoss(BigDecimal profitLoss) 
    {
        this.profitLoss = profitLoss;
    }

    public BigDecimal getProfitLoss() 
    {
        return profitLoss;
    }

    public void setIsProfitable(String isProfitable)
    {
        this.isProfitable = isProfitable;
    }

    public String getIsProfitable()
    {
        return isProfitable;
    }

    public void setClosingPrice(BigDecimal closingPrice) 
    {
        this.closingPrice = closingPrice;
    }

    public BigDecimal getClosingPrice() 
    {
        return closingPrice;
    }

    public void setClosingTotalPrice(BigDecimal closingTotalPrice) 
    {
        this.closingTotalPrice = closingTotalPrice;
    }

    public BigDecimal getClosingTotalPrice() 
    {
        return closingTotalPrice;
    }

    public void setClosingDate(Date closingDate) 
    {
        this.closingDate = closingDate;
    }

    public Date getClosingDate() 
    {
        return closingDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("accountName", getAccountName())
            .append("tradeType", getTradeType())
            .append("tickerSymbol", getTickerSymbol())
            .append("tradeDate", getTradeDate())
            .append("tradeDirection", getTradeDirection())
            .append("quantity", getQuantity())
            .append("price", getPrice())
            .append("totalPrice", getTotalPrice())
            .append("isClosed", getIsClosed())
            .append("optionStrategy", getOptionStrategy())
            .append("profitLoss", getProfitLoss())
            .append("isProfitable", getIsProfitable())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("closingPrice", getClosingPrice())
            .append("closingTotalPrice", getClosingTotalPrice())
            .append("closingDate", getClosingDate())
            .toString();
    }
}
