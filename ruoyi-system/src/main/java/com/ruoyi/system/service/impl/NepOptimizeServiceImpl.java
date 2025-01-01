package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NepOptimizeMapper;
import com.ruoyi.system.domain.NepOptimize;
import com.ruoyi.system.service.INepOptimizeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 系统优化Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-01-01
 */
@Service
public class NepOptimizeServiceImpl implements INepOptimizeService 
{
    @Autowired
    private NepOptimizeMapper nepOptimizeMapper;

    /**
     * 查询系统优化
     * 
     * @param id 系统优化主键
     * @return 系统优化
     */
    @Override
    public NepOptimize selectNepOptimizeById(Long id)
    {
        return nepOptimizeMapper.selectNepOptimizeById(id);
    }

    /**
     * 查询系统优化列表
     * 
     * @param nepOptimize 系统优化
     * @return 系统优化
     */
    @Override
    public List<NepOptimize> selectNepOptimizeList(NepOptimize nepOptimize)
    {
        return nepOptimizeMapper.selectNepOptimizeList(nepOptimize);
    }

    /**
     * 新增系统优化
     * 
     * @param nepOptimize 系统优化
     * @return 结果
     */
    @Override
    public int insertNepOptimize(NepOptimize nepOptimize)
    {
        return nepOptimizeMapper.insertNepOptimize(nepOptimize);
    }

    /**
     * 修改系统优化
     * 
     * @param nepOptimize 系统优化
     * @return 结果
     */
    @Override
    public int updateNepOptimize(NepOptimize nepOptimize)
    {
        return nepOptimizeMapper.updateNepOptimize(nepOptimize);
    }

    /**
     * 批量删除系统优化
     * 
     * @param ids 需要删除的系统优化主键
     * @return 结果
     */
    @Override
    public int deleteNepOptimizeByIds(String ids)
    {
        return nepOptimizeMapper.deleteNepOptimizeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除系统优化信息
     * 
     * @param id 系统优化主键
     * @return 结果
     */
    @Override
    public int deleteNepOptimizeById(Long id)
    {
        return nepOptimizeMapper.deleteNepOptimizeById(id);
    }
}
