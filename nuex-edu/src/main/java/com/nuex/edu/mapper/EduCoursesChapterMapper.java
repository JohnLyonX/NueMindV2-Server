package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduCoursesChapter;

/**
 * 课程章节信息Mapper接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface EduCoursesChapterMapper 
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
     * 删除课程章节信息
     * 
     * @param id 课程章节信息主键
     * @return 结果
     */
    public int deleteEduCoursesChapterById(Long id);

    /**
     * 批量删除课程章节信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduCoursesChapterByIds(Long[] ids);
}
