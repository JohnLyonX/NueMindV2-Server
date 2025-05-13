package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduStudentInformation;

/**
 * 学生档案Mapper接口
 * 
 * @author john
 * @date 2025-04-02
 */
public interface EduStudentInformationMapper 
{
    /**
     * 查询学生档案
     * 
     * @param id 学生档案主键
     * @return 学生档案
     */
    public EduStudentInformation selectEduStudentInformationById(Long id);

    /**
     * 查询学生档案列表
     * 
     * @param eduStudentInformation 学生档案
     * @return 学生档案集合
     */
    public List<EduStudentInformation> selectEduStudentInformationList(EduStudentInformation eduStudentInformation);

    /**
     * 新增学生档案
     * 
     * @param eduStudentInformation 学生档案
     * @return 结果
     */
    public int insertEduStudentInformation(EduStudentInformation eduStudentInformation);

    /**
     * 修改学生档案
     * 
     * @param eduStudentInformation 学生档案
     * @return 结果
     */
    public int updateEduStudentInformation(EduStudentInformation eduStudentInformation);

    /**
     * 删除学生档案
     * 
     * @param id 学生档案主键
     * @return 结果
     */
    public int deleteEduStudentInformationById(Long id);

    /**
     * 批量删除学生档案
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduStudentInformationByIds(Long[] ids);
}
