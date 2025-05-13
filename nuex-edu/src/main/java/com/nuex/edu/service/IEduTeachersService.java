package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduTeachers;

/**
 * 教师Service接口
 *
 * @author john
 * @date 2025-04-02
 */
public interface IEduTeachersService
{
    /**
     * 查询教师
     *
     * @param id 教师主键
     * @return 教师
     */
    public EduTeachers selectEduTeachersById(Long id);

    /**
     * 查询教师列表
     *
     * @param eduTeachers 教师
     * @return 教师集合
     */
    public List<EduTeachers> selectEduTeachersList(EduTeachers eduTeachers);

    /**
     * 新增教师
     *
     * @param eduTeachers 教师
     * @return 结果
     */
    public int insertEduTeachers(EduTeachers eduTeachers);

    /**
     * 修改教师
     *
     * @param eduTeachers 教师
     * @return 结果
     */
    public int updateEduTeachers(EduTeachers eduTeachers);

    /**
     * 批量删除教师
     *
     * @param ids 需要删除的教师主键集合
     * @return 结果
     */
    public int deleteEduTeachersByIds(Long[] ids);

    /**
     * 删除教师信息
     *
     * @param id 教师主键
     * @return 结果
     */
    public int deleteEduTeachersById(Long id);
}
