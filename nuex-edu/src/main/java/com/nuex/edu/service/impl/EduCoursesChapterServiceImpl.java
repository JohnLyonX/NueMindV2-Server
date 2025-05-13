package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduCoursesChapterMapper;
import com.nuex.edu.domain.EduCoursesChapter;
import com.nuex.edu.service.IEduCoursesChapterService;

/**
 * 课程章节信息Service业务层处理
 *
 * @author john
 * @date 2025-04-09
 */
@Service
public class EduCoursesChapterServiceImpl implements IEduCoursesChapterService
{
    @Autowired
    private EduCoursesChapterMapper eduCoursesChapterMapper;

    /**
     * 查询课程章节信息
     *
     * @param id 课程章节信息主键
     * @return 课程章节信息
     */
    @Override
    public EduCoursesChapter selectEduCoursesChapterById(Long id)
    {
        return eduCoursesChapterMapper.selectEduCoursesChapterById(id);
    }

    /**
     * 查询课程章节信息列表
     *
     * @param eduCoursesChapter 课程章节信息
     * @return 课程章节信息
     */
    @Override
    public List<EduCoursesChapter> selectEduCoursesChapterList(EduCoursesChapter eduCoursesChapter)
    {
        return eduCoursesChapterMapper.selectEduCoursesChapterList(eduCoursesChapter);
    }

    /**
     * 新增课程章节信息
     *
     * @param eduCoursesChapter 课程章节信息
     * @return 结果
     */
    @Override
    public int insertEduCoursesChapter(EduCoursesChapter eduCoursesChapter)
    {
        return eduCoursesChapterMapper.insertEduCoursesChapter(eduCoursesChapter);
    }

    /**
     * 修改课程章节信息
     *
     * @param eduCoursesChapter 课程章节信息
     * @return 结果
     */
    @Override
    public int updateEduCoursesChapter(EduCoursesChapter eduCoursesChapter)
    {
        return eduCoursesChapterMapper.updateEduCoursesChapter(eduCoursesChapter);
    }

    /**
     * 批量删除课程章节信息
     *
     * @param ids 需要删除的课程章节信息主键
     * @return 结果
     */
    @Override
    public int deleteEduCoursesChapterByIds(Long[] ids)
    {
        return eduCoursesChapterMapper.deleteEduCoursesChapterByIds(ids);
    }

    /**
     * 删除课程章节信息信息
     *
     * @param id 课程章节信息主键
     * @return 结果
     */
    @Override
    public int deleteEduCoursesChapterById(Long id)
    {
        return eduCoursesChapterMapper.deleteEduCoursesChapterById(id);
    }
}
