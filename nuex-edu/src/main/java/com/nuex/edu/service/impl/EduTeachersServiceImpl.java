package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduTeachersMapper;
import com.nuex.edu.domain.EduTeachers;
import com.nuex.edu.service.IEduTeachersService;

/**
 * 教师Service业务层处理
 *
 * @author john
 * @date 2025-04-02
 */
@Service
public class EduTeachersServiceImpl implements IEduTeachersService
{
    @Autowired
    private EduTeachersMapper eduTeachersMapper;

    /**
     * 查询教师
     *
     * @param id 教师主键
     * @return 教师
     */
    @Override
    public EduTeachers selectEduTeachersById(Long id)
    {
        return eduTeachersMapper.selectEduTeachersById(id);
    }

    /**
     * 查询教师列表
     *
     * @param eduTeachers 教师
     * @return 教师
     */
    @Override
    public List<EduTeachers> selectEduTeachersList(EduTeachers eduTeachers)
    {
        return eduTeachersMapper.selectEduTeachersList(eduTeachers);
    }

    /**
     * 新增教师
     *
     * @param eduTeachers 教师
     * @return 结果
     */
    @Override
    public int insertEduTeachers(EduTeachers eduTeachers)
    {
        return eduTeachersMapper.insertEduTeachers(eduTeachers);
    }

    /**
     * 修改教师
     *
     * @param eduTeachers 教师
     * @return 结果
     */
    @Override
    public int updateEduTeachers(EduTeachers eduTeachers)
    {
        return eduTeachersMapper.updateEduTeachers(eduTeachers);
    }

    /**
     * 批量删除教师
     *
     * @param ids 需要删除的教师主键
     * @return 结果
     */
    @Override
    public int deleteEduTeachersByIds(Long[] ids)
    {
        return eduTeachersMapper.deleteEduTeachersByIds(ids);
    }

    /**
     * 删除教师信息
     *
     * @param id 教师主键
     * @return 结果
     */
    @Override
    public int deleteEduTeachersById(Long id)
    {
        return eduTeachersMapper.deleteEduTeachersById(id);
    }
}
