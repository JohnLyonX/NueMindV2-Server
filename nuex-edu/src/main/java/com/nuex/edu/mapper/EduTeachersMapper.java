package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduTeachers;

/**
 * 教师Mapper接口
 *
 * @author john
 * @date 2025-04-02
 */
public interface EduTeachersMapper
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
     * 删除教师
     *
     * @param id 教师主键
     * @return 结果
     */
    public int deleteEduTeachersById(Long id);

    /**
     * 批量删除教师
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduTeachersByIds(Long[] ids);
}
