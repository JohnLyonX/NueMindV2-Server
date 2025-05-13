package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduCoursesExamMapper;
import com.nuex.edu.domain.EduCoursesExam;
import com.nuex.edu.service.IEduCoursesExamService;

/**
 * 课程考试Service业务层处理
 *
 * @author john
 * @date 2025-04-09
 */
@Service
public class EduCoursesExamServiceImpl implements IEduCoursesExamService
{
    @Autowired
    private EduCoursesExamMapper eduCoursesExamMapper;

    /**
     * 查询课程考试
     *
     * @param id 课程考试主键
     * @return 课程考试
     */
    @Override
    public EduCoursesExam selectEduCoursesExamById(Long id)
    {
        return eduCoursesExamMapper.selectEduCoursesExamById(id);
    }

    /**
     * 查询课程考试列表
     *
     * @param eduCoursesExam 课程考试
     * @return 课程考试
     */
    @Override
    public List<EduCoursesExam> selectEduCoursesExamList(EduCoursesExam eduCoursesExam)
    {
        return eduCoursesExamMapper.selectEduCoursesExamList(eduCoursesExam);
    }

    /**
     * 新增课程考试
     *
     * @param eduCoursesExam 课程考试
     * @return 结果
     */
    @Override
    public int insertEduCoursesExam(EduCoursesExam eduCoursesExam)
    {
        return eduCoursesExamMapper.insertEduCoursesExam(eduCoursesExam);
    }

    /**
     * 修改课程考试
     *
     * @param eduCoursesExam 课程考试
     * @return 结果
     */
    @Override
    public int updateEduCoursesExam(EduCoursesExam eduCoursesExam)
    {
        return eduCoursesExamMapper.updateEduCoursesExam(eduCoursesExam);
    }

    /**
     * 批量删除课程考试
     *
     * @param ids 需要删除的课程考试主键
     * @return 结果
     */
    @Override
    public int deleteEduCoursesExamByIds(Long[] ids)
    {
        return eduCoursesExamMapper.deleteEduCoursesExamByIds(ids);
    }

    /**
     * 删除课程考试信息
     *
     * @param id 课程考试主键
     * @return 结果
     */
    @Override
    public int deleteEduCoursesExamById(Long id)
    {
        return eduCoursesExamMapper.deleteEduCoursesExamById(id);
    }
}
