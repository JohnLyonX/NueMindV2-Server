package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduCoursesChapter;

/**
 * 课程章节信息Service接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface IEduCoursesChapterService 
{
    /**
     * 查询课程章节信息
     * 
     * @param id 课程章节信息主键
     * @return 课程章节信息
     */
    public EduCoursesChapter selectEduCoursesChapterById(Long id);

    /**
     * 查询课程章节信息列表
     * 
     * @param eduCoursesChapter 课程章节信息
     * @return 课程章节信息集合
     */
    public List<EduCoursesChapter> selectEduCoursesChapterList(EduCoursesChapter eduCoursesChapter);

    /**
     * 新增课程章节信息
     * 
     * @param eduCoursesChapter 课程章节信息
     * @return 结果
     */
    public int insertEduCoursesChapter(EduCoursesChapter eduCoursesChapter);

    /**
     * 修改课程章节信息
     * 
     * @param eduCoursesChapter 课程章节信息
     * @return 结果
     */
    public int updateEduCoursesChapter(EduCoursesChapter eduCoursesChapter);

    /**
     * 批量删除课程章节信息
     * 
     * @param ids 需要删除的课程章节信息主键集合
     * @return 结果
     */
    public int deleteEduCoursesChapterByIds(Long[] ids);

    /**
     * 删除课程章节信息信息
     * 
     * @param id 课程章节信息主键
     * @return 结果
     */
    public int deleteEduCoursesChapterById(Long id);
}
