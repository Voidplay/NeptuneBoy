package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.NepOptimize;

/**
 * 系统优化Mapper接口
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
public interface NepOptimizeMapper 
{
    /**
     * 查询系统优化
     * 
     * @param id 系统优化主键
     * @return 系统优化
     */
    public NepOptimize selectNepOptimizeById(Long id);

    /**
     * 查询系统优化列表
     * 
     * @param nepOptimize 系统优化
     * @return 系统优化集合
     */
    public List<NepOptimize> selectNepOptimizeList(NepOptimize nepOptimize);

    /**
     * 新增系统优化
     * 
     * @param nepOptimize 系统优化
     * @return 结果
     */
    public int insertNepOptimize(NepOptimize nepOptimize);

    /**
     * 修改系统优化
     * 
     * @param nepOptimize 系统优化
     * @return 结果
     */
    public int updateNepOptimize(NepOptimize nepOptimize);

    /**
     * 删除系统优化
     * 
     * @param id 系统优化主键
     * @return 结果
     */
    public int deleteNepOptimizeById(Long id);

    /**
     * 批量删除系统优化
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNepOptimizeByIds(String[] ids);
}
