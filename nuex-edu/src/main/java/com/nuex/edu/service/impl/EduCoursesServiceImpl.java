package com.nuex.edu.service.impl;

import java.util.List;
import com.nuex.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.nuex.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.nuex.edu.domain.EduCoursesDetails;
import com.nuex.edu.mapper.EduCoursesMapper;
import com.nuex.edu.domain.EduCourses;
import com.nuex.edu.service.IEduCoursesService;

/**
 * 课程Service业务层处理
 *
 * @author john
 * @date 2025-04-09
 */
@Service
public class EduCoursesServiceImpl implements IEduCoursesService
{
    @Autowired
    private EduCoursesMapper eduCoursesMapper;

    /**
     * 查询课程
     *
     * @param id 课程主键
     * @return 课程
     */
    @Override
    public EduCourses selectEduCoursesById(Long id)
    {
        return eduCoursesMapper.selectEduCoursesById(id);
    }

    /**
     * 查询课程列表
     *
     * @param eduCourses 课程
     * @return 课程
     */
    @Override
    public List<EduCourses> selectEduCoursesList(EduCourses eduCourses)
    {
        return eduCoursesMapper.selectEduCoursesList(eduCourses);
    }

    /**
     * 新增课程
     *
     * @param eduCourses 课程
     * @return 结果
     */
    @Transactional
    @Override
    public int insertEduCourses(EduCourses eduCourses)
    {
        eduCourses.setCreateTime(DateUtils.getNowDate());
        int rows = eduCoursesMapper.insertEduCourses(eduCourses);
        insertEduCoursesDetails(eduCourses);
        return rows;
    }

    /**
     * 修改课程
     *
     * @param eduCourses 课程
     * @return 结果
     */
    @Transactional
    @Override
    public int updateEduCourses(EduCourses eduCourses)
    {
        eduCourses.setUpdateTime(DateUtils.getNowDate());
        eduCoursesMapper.deleteEduCoursesDetailsByCoursesId(eduCourses.getId());
        insertEduCoursesDetails(eduCourses);
        return eduCoursesMapper.updateEduCourses(eduCourses);
    }

    /**
     * 批量删除课程
     *
     * @param ids 需要删除的课程主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEduCoursesByIds(Long[] ids)
    {
        eduCoursesMapper.deleteEduCoursesDetailsByCoursesIds(ids);
        return eduCoursesMapper.deleteEduCoursesByIds(ids);
    }

    /**
     * 删除课程信息
     *
     * @param id 课程主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteEduCoursesById(Long id)
    {
        eduCoursesMapper.deleteEduCoursesDetailsByCoursesId(id);
        return eduCoursesMapper.deleteEduCoursesById(id);
    }

    /**
     * 新增视频课信息
     *
     * @param eduCourses 课程对象
     */
    public void insertEduCoursesDetails(EduCourses eduCourses)
    {
        List<EduCoursesDetails> eduCoursesDetailsList = eduCourses.getEduCoursesDetailsList();
        Long id = eduCourses.getId();
        if (StringUtils.isNotNull(eduCoursesDetailsList))
        {
            List<EduCoursesDetails> list = new ArrayList<EduCoursesDetails>();
            for (EduCoursesDetails eduCoursesDetails : eduCoursesDetailsList)
            {
                eduCoursesDetails.setCoursesId(id);
                list.add(eduCoursesDetails);
            }
            if (list.size() > 0)
            {
                eduCoursesMapper.batchEduCoursesDetails(list);
            }
        }
    }
}
