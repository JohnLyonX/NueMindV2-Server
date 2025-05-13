package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduCoursesStudent;

/**
 * 课堂管理Service接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface IEduCoursesStudentService 
{
    /**
     * 查询课堂管理
     * 
     * @param id 课堂管理主键
     * @return 课堂管理
     */
    public EduCoursesStudent selectEduCoursesStudentById(Long id);

    /**
     * 查询课堂管理列表
     * 
     * @param eduCoursesStudent 课堂管理
     * @return 课堂管理集合
     */
    public List<EduCoursesStudent> selectEduCoursesStudentList(EduCoursesStudent eduCoursesStudent);

    /**
     * 新增课堂管理
     * 
     * @param eduCoursesStudent 课堂管理
     * @return 结果
     */
    public int insertEduCoursesStudent(EduCoursesStudent eduCoursesStudent);

    /**
     * 修改课堂管理
     * 
     * @param eduCoursesStudent 课堂管理
     * @return 结果
     */
    public int updateEduCoursesStudent(EduCoursesStudent eduCoursesStudent);

    /**
     * 批量删除课堂管理
     * 
     * @param ids 需要删除的课堂管理主键集合
     * @return 结果
     */
    public int deleteEduCoursesStudentByIds(Long[] ids);

    /**
     * 删除课堂管理信息
     * 
     * @param id 课堂管理主键
     * @return 结果
     */
    public int deleteEduCoursesStudentById(Long id);
}
