package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduCourses;
import com.nuex.edu.domain.EduCoursesDetails;

/**
 * 课程Mapper接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface EduCoursesMapper 
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
     * 删除课程
     * 
     * @param id 课程主键
     * @return 结果
     */
    public int deleteEduCoursesById(Long id);

    /**
     * 批量删除课程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduCoursesByIds(Long[] ids);

    /**
     * 批量删除视频课
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduCoursesDetailsByCoursesIds(Long[] ids);
    
    /**
     * 批量新增视频课
     * 
     * @param eduCoursesDetailsList 视频课列表
     * @return 结果
     */
    public int batchEduCoursesDetails(List<EduCoursesDetails> eduCoursesDetailsList);
    

    /**
     * 通过课程主键删除视频课信息
     * 
     * @param id 课程ID
     * @return 结果
     */
    public int deleteEduCoursesDetailsByCoursesId(Long id);
}
