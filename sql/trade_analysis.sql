-- 交易分析报表表
create table sys_trade_analysis (
  analysis_id           bigint(20)      not null auto_increment    comment '分析ID',
  account_name         varchar(50)     not null                   comment '券商账户',
  analysis_date        date            not null                   comment '分析日期',
  total_profit         decimal(20,2)                              comment '总收益',
  daily_profit         decimal(20,2)                              comment '日收益',
  win_rate            decimal(10,2)                              comment '胜率',
  max_drawdown        decimal(10,2)                              comment '最大回撤',
  sharpe_ratio        decimal(10,2)                              comment '夏普比率',
  position_value      decimal(20,2)                              comment '持仓市值',
  cash_balance        decimal(20,2)                              comment '现金余额',
  trade_count         int                                        comment '交易次数',
  create_by           varchar(64)      default ''                comment '创建者',
  create_time         datetime                                   comment '创建时间',
  update_by           varchar(64)      default ''                comment '更新者',
  update_time         datetime                                   comment '更新时间',
  primary key (analysis_id)
) engine=innodb auto_increment=100 comment = '交易分析报表表';

-- 策略分析表
create table sys_strategy_analysis (
  strategy_id          bigint(20)      not null auto_increment    comment '策略ID',
  strategy_name        varchar(50)     not null                   comment '策略名称',
  analysis_date        date            not null                   comment '分析日期',
  strategy_profit      decimal(20,2)                              comment '策略收益',
  strategy_drawdown    decimal(10,2)                              comment '策略回撤',
  win_rate            decimal(10,2)                              comment '策略胜率',
  position_count       int                                        comment '持仓数量',
  create_by           varchar(64)      default ''                comment '创建者',
  create_time         datetime                                   comment '创建时间',
  update_by           varchar(64)      default ''                comment '更新者',
  update_time         datetime                                   comment '更新时间',
  primary key (strategy_id)
) engine=innodb auto_increment=100 comment = '策略分析表';
