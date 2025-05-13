package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduCourses;

/**
 * 课程Service接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface IEduCoursesService 
{
    /**
     * 查询课程
     * 
     * @param id 课程主键
     * @return 课程
     */
    public EduCourses selectEduCoursesById(Long id);

    /**
     * 查询课程列表
     * 
     * @param eduCourses 课程
     * @return 课程集合
     */
    public List<EduCourses> selectEduCoursesList(EduCourses eduCourses);

    /**
     * 新增课程
     * 
     * @param eduCourses 课程
     * @return 结果
     */
    public int insertEduCourses(EduCourses eduCourses);

    /**
     * 修改课程
     * 
     * @param eduCourses 课程
     * @return 结果
     */
    public int updateEduCourses(EduCourses eduCourses);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的课程主键集合
     * @return 结果
     */
    public int deleteEduCoursesByIds(Long[] ids);

    /**
     * 删除课程信息
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteEduCoursesById(Long id);
}
