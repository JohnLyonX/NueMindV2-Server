package com.nuex.edu.service.impl;

import java.util.List;
import com.nuex.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.nuex.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.nuex.edu.domain.EduStudentDetails;
import com.nuex.edu.mapper.EduStudentMapper;
import com.nuex.edu.domain.EduStudent;
import com.nuex.edu.service.IEduStudentService;

/**
 * 学生基本信息Service业务层处理
 *
 * @author john
 * @date 2025-04-09
 */
@Service
public class EduStudentServiceImpl implements IEduStudentService
{
    @Autowired
    private EduStudentMapper eduStudentMapper;

    /**
     * 查询学生基本信息
     *
     * @param id 学生基本信息主键
     * @return 学生基本信息
     */
    @Override
    public EduStudent selectEduStudentById(Long id)
    {
        return eduStudentMapper.selectEduStudentById(id);
    }

    /**
     * 查询学生基本信息列表
     *
     * @param eduStudent 学生基本信息
     * @return 学生基本信息
     */
    @Override
    public List<EduStudent> selectEduStudentList(EduStudent eduStudent)
    {
        return eduStudentMapper.selectEduStudentList(eduStudent);
    }

    /**
     * 新增学生基本信息
     *
     * @param eduStudent 学生基本信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertEduStudent(EduStudent eduStudent)
    {
        eduStudent.setCreateTime(DateUtils.getNowDate());
        int rows = eduStudentMapper.insertEduStudent(eduStudent);
        insertEduStudentDetails(eduStudent);
        return rows;
    }

    /**
     * 修改学生基本信息
     *
     * @param eduStudent 学生基本信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateEduStudent(EduStudent eduStudent)
    {
        eduStudent.setUpdateTime(DateUtils.getNowDate());
        eduStudentMapper.deleteEduStudentDetailsByStudentId(eduStudent.getId());
        insertEduStudentDetails(eduStudent);
        return eduStudentMapper.updateEduStudent(eduStudent);
    }

    /**
     * 批量删除学生基本信息
     *
     * @param ids 需要删除的学生基本信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEduStudentByIds(Long[] ids)
    {
        eduStudentMapper.deleteEduStudentDetailsByStudentIds(ids);
        return eduStudentMapper.deleteEduStudentByIds(ids);
    }

    /**
     * 删除学生基本信息信息
     *
     * @param id 学生基本信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEduStudentById(Long id)
    {
        eduStudentMapper.deleteEduStudentDetailsByStudentId(id);
        return eduStudentMapper.deleteEduStudentById(id);
    }

    /**
     * 新增学生信息详情信息
     *
     * @param eduStudent 学生基本信息对象
     */
    public void insertEduStudentDetails(EduStudent eduStudent)
    {
        List<EduStudentDetails> eduStudentDetailsList = eduStudent.getEduStudentDetailsList();
        Long id = eduStudent.getId();
        if (StringUtils.isNotNull(eduStudentDetailsList))
        {
            List<EduStudentDetails> list = new ArrayList<EduStudentDetails>();
            for (EduStudentDetails eduStudentDetails : eduStudentDetailsList)
            {
                eduStudentDetails.setStudentId(id);
                list.add(eduStudentDetails);
            }
            if (list.size() > 0)
            {
                eduStudentMapper.batchEduStudentDetails(list);
            }
        }
    }
}
