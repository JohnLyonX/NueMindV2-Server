package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduCoursesStudent;
import com.nuex.edu.domain.EduCoursesStudentDetails;

/**
 * 课堂管理Mapper接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface EduCoursesStudentMapper 
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
     * 删除课堂管理
     * 
     * @param id 课堂管理主键
     * @return 结果
     */
    public int deleteEduCoursesStudentById(Long id);

    /**
     * 批量删除课堂管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduCoursesStudentByIds(Long[] ids);

    /**
     * 批量删除课堂管理详情
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduCoursesStudentDetailsByCoursesStudentIds(Long[] ids);
    
    /**
     * 批量新增课堂管理详情
     * 
     * @param eduCoursesStudentDetailsList 课堂管理详情列表
     * @return 结果
     */
    public int batchEduCoursesStudentDetails(List<EduCoursesStudentDetails> eduCoursesStudentDetailsList);
    

    /**
     * 通过课堂管理主键删除课堂管理详情信息
     * 
     * @param id 课堂管理ID
     * @return 结果
     */
    public int deleteEduCoursesStudentDetailsByCoursesStudentId(Long id);
}
