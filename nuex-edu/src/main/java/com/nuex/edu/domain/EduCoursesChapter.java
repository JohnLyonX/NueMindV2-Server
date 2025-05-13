package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.TreeEntity;

/**
 * 课程章节信息对象 edu_courses_chapter
 *
 * @author john
 * @date 2025-04-09
 */
public class EduCoursesChapter extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long coursesId;

    /** 课程章节 */
    @Excel(name = "课程章节")
    private String title;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setCoursesId(Long coursesId)
    {
        this.coursesId = coursesId;
    }

    public Long getCoursesId()
    {
        return coursesId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coursesId", getCoursesId())
            .append("title", getTitle())
            .append("parentId", getParentId())
            .toString();
    }
}
