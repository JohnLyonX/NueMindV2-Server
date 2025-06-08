package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduStudent;

/**
 * 学生基本信息Service接口
 *
 * @author john
 * @date 2025-04-09
 */
public interface IEduStudentService
{
    /**
     * 查询学生基本信息
     *
     * @param id 学生基本信息主键
     * @return 学生基本信息
     */
    public EduStudent selectEduStudentById(Long id);

    /**
     * 查询学生基本信息列表
     *
     * @param eduStudent 学生基本信息
     * @return 学生基本信息集合
     */
    public List<EduStudent> selectEduStudentList(EduStudent eduStudent);

    /**
     * 新增学生基本信息
     *
     * @param eduStudent 学生基本信息
     * @return 结果
     */
    public int insertEduStudent(EduStudent eduStudent);

    /**
     * 修改学生基本信息
     *
     * @param eduStudent 学生基本信息
     * @return 结果
     */
    public int updateEduStudent(EduStudent eduStudent);

    /**
     * 批量删除学生基本信息
     *
     * @param ids 需要删除的学生基本信息主键集合
     * @return 结果
     */
    public int deleteEduStudentByIds(Long[] ids);

    /**
     * 删除学生基本信息信息
     *
     * @param id 学生基本信息主键
     * @return 结果
     */
    public int deleteEduStudentById(Long id);

    EduStudent selectStudentByPhoneNumber(String username);
}
