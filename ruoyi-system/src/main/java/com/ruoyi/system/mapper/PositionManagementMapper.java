package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PositionManagement;

/**
 * 仓位管理，用于记录正股和期权的仓位详情Mapper接口
 * 
 * @author ruoyi
 * @date 2024-12-24
 */
public interface PositionManagementMapper 
{
    /**
     * 查询仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param id 仓位管理，用于记录正股和期权的仓位详情主键
     * @return 仓位管理，用于记录正股和期权的仓位详情
     */
    public PositionManagement selectPositionManagementById(Long id);

    /**
     * 查询仓位管理，用于记录正股和期权的仓位详情列表
     * 
     * @param positionManagement 仓位管理，用于记录正股和期权的仓位详情
     * @return 仓位管理，用于记录正股和期权的仓位详情集合
     */
    public List<PositionManagement> selectPositionManagementList(PositionManagement positionManagement);

    /**
     * 新增仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param positionManagement 仓位管理，用于记录正股和期权的仓位详情
     * @return 结果
     */
    public int insertPositionManagement(PositionManagement positionManagement);

    /**
     * 修改仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param positionManagement 仓位管理，用于记录正股和期权的仓位详情
     * @return 结果
     */
    public int updatePositionManagement(PositionManagement positionManagement);

    /**
     * 删除仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param id 仓位管理，用于记录正股和期权的仓位详情主键
     * @return 结果
     */
    public int deletePositionManagementById(Long id);

    /**
     * 批量删除仓位管理，用于记录正股和期权的仓位详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePositionManagementByIds(String[] ids);
}
