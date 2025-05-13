package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduCoursesExam;

/**
 * 课程考试Service接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface IEduCoursesExamService 
{
    /**
     * 查询课程考试
     * 
     * @param id 课程考试主键
     * @return 课程考试
     */
    public EduCoursesExam selectEduCoursesExamById(Long id);

    /**
     * 查询课程考试列表
     * 
     * @param eduCoursesExam 课程考试
     * @return 课程考试集合
     */
    public List<EduCoursesExam> selectEduCoursesExamList(EduCoursesExam eduCoursesExam);

    /**
     * 新增课程考试
     * 
     * @param eduCoursesExam 课程考试
     * @return 结果
     */
    public int insertEduCoursesExam(EduCoursesExam eduCoursesExam);

    /**
     * 修改课程考试
     * 
     * @param eduCoursesExam 课程考试
     * @return 结果
     */
    public int updateEduCoursesExam(EduCoursesExam eduCoursesExam);

    /**
     * 批量删除课程考试
     * 
     * @param ids 需要删除的课程考试主键集合
     * @return 结果
     */
    public int deleteEduCoursesExamByIds(Long[] ids);

    /**
     * 删除课程考试信息
     * 
     * @param id 课程考试主键
     * @return 结果
     */
    public int deleteEduCoursesExamById(Long id);
}
