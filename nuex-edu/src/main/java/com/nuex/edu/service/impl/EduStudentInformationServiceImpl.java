package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduStudentInformationMapper;
import com.nuex.edu.domain.EduStudentInformation;
import com.nuex.edu.service.IEduStudentInformationService;

/**
 * 学生档案Service业务层处理
 *
 * @author john
 * @date 2025-04-02
 */
@Service
public class EduStudentInformationServiceImpl implements IEduStudentInformationService
{
    @Autowired
    private EduStudentInformationMapper eduStudentInformationMapper;

    /**
     * 查询学生档案
     *
     * @param id 学生档案主键
     * @return 学生档案
     */
    @Override
    public EduStudentInformation selectEduStudentInformationById(Long id)
    {
        return eduStudentInformationMapper.selectEduStudentInformationById(id);
    }

    /**
     * 查询学生档案列表
     *
     * @param eduStudentInformation 学生档案
     * @return 学生档案
     */
    @Override
    public List<EduStudentInformation> selectEduStudentInformationList(EduStudentInformation eduStudentInformation)
    {
        return eduStudentInformationMapper.selectEduStudentInformationList(eduStudentInformation);
    }

    /**
     * 新增学生档案
     *
     * @param eduStudentInformation 学生档案
     * @return 结果
     */
    @Override
    public int insertEduStudentInformation(EduStudentInformation eduStudentInformation)
    {
        return eduStudentInformationMapper.insertEduStudentInformation(eduStudentInformation);
    }

    /**
     * 修改学生档案
     *
     * @param eduStudentInformation 学生档案
     * @return 结果
     */
    @Override
    public int updateEduStudentInformation(EduStudentInformation eduStudentInformation)
    {
        return eduStudentInformationMapper.updateEduStudentInformation(eduStudentInformation);
    }

    /**
     * 批量删除学生档案
     *
     * @param ids 需要删除的学生档案主键
     * @return 结果
     */
    @Override
    public int deleteEduStudentInformationByIds(Long[] ids)
    {
        return eduStudentInformationMapper.deleteEduStudentInformationByIds(ids);
    }

    /**
     * 删除学生档案信息
     *
     * @param id 学生档案主键
     * @return 结果
     */
    @Override
    public int deleteEduStudentInformationById(Long id)
    {
        return eduStudentInformationMapper.deleteEduStudentInformationById(id);
    }
}
