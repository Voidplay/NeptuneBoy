package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PositionManagementMapper;
import com.ruoyi.system.domain.PositionManagement;
import com.ruoyi.system.service.IPositionManagementService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仓位管理，用于记录正股和期权的仓位详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-12-24
 */
@Service
public class PositionManagementServiceImpl implements IPositionManagementService 
{
    @Autowired
    private PositionManagementMapper positionManagementMapper;

    /**
     * 查询仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param id 仓位管理，用于记录正股和期权的仓位详情主键
     * @return 仓位管理，用于记录正股和期权的仓位详情
     */
    @Override
    public PositionManagement selectPositionManagementById(Long id)
    {
        return positionManagementMapper.selectPositionManagementById(id);
    }

    /**
     * 查询仓位管理，用于记录正股和期权的仓位详情列表
     * 
     * @param positionManagement 仓位管理，用于记录正股和期权的仓位详情
     * @return 仓位管理，用于记录正股和期权的仓位详情
     */
    @Override
    public List<PositionManagement> selectPositionManagementList(PositionManagement positionManagement)
    {
        return positionManagementMapper.selectPositionManagementList(positionManagement);
    }

    /**
     * 新增仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param positionManagement 仓位管理，用于记录正股和期权的仓位详情
     * @return 结果
     */
    @Override
    public int insertPositionManagement(PositionManagement positionManagement)
    {
        positionManagement.setCreateTime(DateUtils.getNowDate());
        return positionManagementMapper.insertPositionManagement(positionManagement);
    }

    /**
     * 修改仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param positionManagement 仓位管理，用于记录正股和期权的仓位详情
     * @return 结果
     */
    @Override
    public int updatePositionManagement(PositionManagement positionManagement)
    {
        positionManagement.setUpdateTime(DateUtils.getNowDate());
        return positionManagementMapper.updatePositionManagement(positionManagement);
    }

    /**
     * 批量删除仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param ids 需要删除的仓位管理，用于记录正股和期权的仓位详情主键
     * @return 结果
     */
    @Override
    public int deletePositionManagementByIds(String ids)
    {
        return positionManagementMapper.deletePositionManagementByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除仓位管理，用于记录正股和期权的仓位详情信息
     * 
     * @param id 仓位管理，用于记录正股和期权的仓位详情主键
     * @return 结果
     */
    @Override
    public int deletePositionManagementById(Long id)
    {
        return positionManagementMapper.deletePositionManagementById(id);
    }

    @Override
    public BigDecimal getTotalProfitLoss() {
        return positionManagementMapper.sumProfitLoss();
    }

}
