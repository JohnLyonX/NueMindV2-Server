package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduStudent;
import com.nuex.edu.domain.EduStudentDetails;

/**
 * 学生基本信息Mapper接口
 *
 * @author john
 * @date 2025-04-09
 */
public interface EduStudentMapper
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
     * 删除学生基本信息
     *
     * @param id 学生基本信息主键
     * @return 结果
     */
    public int deleteEduStudentById(Long id);

    /**
     * 批量删除学生基本信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduStudentByIds(Long[] ids);

    /**
     * 批量删除学生信息详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduStudentDetailsByStudentIds(Long[] ids);

    /**
     * 批量新增学生信息详情
     *
     * @param eduStudentDetailsList 学生信息详情列表
     * @return 结果
     */
    public int batchEduStudentDetails(List<EduStudentDetails> eduStudentDetailsList);


    /**
     * 通过学生基本信息主键删除学生信息详情信息
     *
     * @param id 学生基本信息ID
     * @return 结果
     */
    public int deleteEduStudentDetailsByStudentId(Long id);
    EduStudent selectStudentByPhoneNumber(String username);

}
