package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.HoldingNotes;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2025-02-13
 */
public interface IHoldingNotesService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public HoldingNotes selectHoldingNotesById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param holdingNotes 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<HoldingNotes> selectHoldingNotesList(HoldingNotes holdingNotes);

    /**
     * 新增【请填写功能名称】
     * 
     * @param holdingNotes 【请填写功能名称】
     * @return 结果
     */
    public int insertHoldingNotes(HoldingNotes holdingNotes);

    /**
     * 修改【请填写功能名称】
     * 
     * @param holdingNotes 【请填写功能名称】
     * @return 结果
     */
    public int updateHoldingNotes(HoldingNotes holdingNotes);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteHoldingNotesByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteHoldingNotesById(Long id);

    HoldingNotes selectHoldingNotesByPositionId(Long positionId);

}
