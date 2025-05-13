package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.nuex.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.nuex.edu.domain.EduCoursesStudentDetails;
import com.nuex.edu.mapper.EduCoursesStudentMapper;
import com.nuex.edu.domain.EduCoursesStudent;
import com.nuex.edu.service.IEduCoursesStudentService;

/**
 * 课堂管理Service业务层处理
 *
 * @author john
 * @date 2025-04-09
 */
@Service
public class EduCoursesStudentServiceImpl implements IEduCoursesStudentService
{
    @Autowired
    private EduCoursesStudentMapper eduCoursesStudentMapper;

    /**
     * 查询课堂管理
     *
     * @param id 课堂管理主键
     * @return 课堂管理
     */
    @Override
    public EduCoursesStudent selectEduCoursesStudentById(Long id)
    {
        return eduCoursesStudentMapper.selectEduCoursesStudentById(id);
    }

    /**
     * 查询课堂管理列表
     *
     * @param eduCoursesStudent 课堂管理
     * @return 课堂管理
     */
    @Override
    public List<EduCoursesStudent> selectEduCoursesStudentList(EduCoursesStudent eduCoursesStudent)
    {
        return eduCoursesStudentMapper.selectEduCoursesStudentList(eduCoursesStudent);
    }

    /**
     * 新增课堂管理
     *
     * @param eduCoursesStudent 课堂管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertEduCoursesStudent(EduCoursesStudent eduCoursesStudent)
    {
        int rows = eduCoursesStudentMapper.insertEduCoursesStudent(eduCoursesStudent);
        insertEduCoursesStudentDetails(eduCoursesStudent);
        return rows;
    }

    /**
     * 修改课堂管理
     *
     * @param eduCoursesStudent 课堂管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateEduCoursesStudent(EduCoursesStudent eduCoursesStudent)
    {
        eduCoursesStudentMapper.deleteEduCoursesStudentDetailsByCoursesStudentId(eduCoursesStudent.getId());
        insertEduCoursesStudentDetails(eduCoursesStudent);
        return eduCoursesStudentMapper.updateEduCoursesStudent(eduCoursesStudent);
    }

    /**
     * 批量删除课堂管理
     *
     * @param ids 需要删除的课堂管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEduCoursesStudentByIds(Long[] ids)
    {
        eduCoursesStudentMapper.deleteEduCoursesStudentDetailsByCoursesStudentIds(ids);
        return eduCoursesStudentMapper.deleteEduCoursesStudentByIds(ids);
    }

    /**
     * 删除课堂管理信息
     *
     * @param id 课堂管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEduCoursesStudentById(Long id)
    {
        eduCoursesStudentMapper.deleteEduCoursesStudentDetailsByCoursesStudentId(id);
        return eduCoursesStudentMapper.deleteEduCoursesStudentById(id);
    }

    /**
     * 新增课堂管理详情信息
     *
     * @param eduCoursesStudent 课堂管理对象
     */
    public void insertEduCoursesStudentDetails(EduCoursesStudent eduCoursesStudent)
    {
        List<EduCoursesStudentDetails> eduCoursesStudentDetailsList = eduCoursesStudent.getEduCoursesStudentDetailsList();
        Long id = eduCoursesStudent.getId();
        if (StringUtils.isNotNull(eduCoursesStudentDetailsList))
        {
            List<EduCoursesStudentDetails> list = new ArrayList<EduCoursesStudentDetails>();
            for (EduCoursesStudentDetails eduCoursesStudentDetails : eduCoursesStudentDetailsList)
            {
                eduCoursesStudentDetails.setCoursesStudentId(id);
                list.add(eduCoursesStudentDetails);
            }
            if (list.size() > 0)
            {
                eduCoursesStudentMapper.batchEduCoursesStudentDetails(list);
            }
        }
    }
}
