package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.HoldingNotesMapper;
import com.ruoyi.system.domain.HoldingNotes;
import com.ruoyi.system.service.IHoldingNotesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
@Service
public class HoldingNotesServiceImpl implements IHoldingNotesService 
{
    @Autowired
    private HoldingNotesMapper holdingNotesMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public HoldingNotes selectHoldingNotesById(Long id)
    {
        return holdingNotesMapper.selectHoldingNotesById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param holdingNotes 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<HoldingNotes> selectHoldingNotesList(HoldingNotes holdingNotes)
    {
        return holdingNotesMapper.selectHoldingNotesList(holdingNotes);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param holdingNotes 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertHoldingNotes(HoldingNotes holdingNotes)
    {
        return holdingNotesMapper.insertHoldingNotes(holdingNotes);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param holdingNotes 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateHoldingNotes(HoldingNotes holdingNotes)
    {
        return holdingNotesMapper.updateHoldingNotes(holdingNotes);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteHoldingNotesByIds(String ids)
    {
        return holdingNotesMapper.deleteHoldingNotesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteHoldingNotesById(Long id)
    {
        return holdingNotesMapper.deleteHoldingNotesById(id);
    }

    @Override
    public HoldingNotes selectHoldingNotesByPositionId(Long positionId) {
        return holdingNotesMapper.selectHoldingNotesByPositionId(positionId);
    }

}
