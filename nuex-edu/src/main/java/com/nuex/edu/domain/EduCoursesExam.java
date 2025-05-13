package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 课程考试对象 edu_courses_exam
 *
 * @author john
 * @date 2025-04-09
 */
public class EduCoursesExam extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long coursesId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String coursesName;

    /** 课程章节编号 */
    @Excel(name = "课程章节编号")
    private Long coursesChapterId;


    /** 课程章节编号 */
    @Excel(name = "课程章节")
    private String coursesChapterName;



    /** 考试名称 */
    @Excel(name = "考试名称")
    private String name;

    /** 试卷地址 */
    @Excel(name = "试卷地址")
    private String fileUrl;

    @Excel(name = "部门id")
    private String deptId;

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

    public void setCoursesName(String coursesName)
    {
        this.coursesName = coursesName;
    }

    public String getCoursesName()
    {
        return coursesName;
    }

    public void setCoursesChapterId(Long coursesChapterId)
    {
        this.coursesChapterId = coursesChapterId;
    }

    public Long getCoursesChapterId()
    {
        return coursesChapterId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl()
    {
        return fileUrl;
    }

    public String getCoursesChapterName() {
        return coursesChapterName;
    }

    public void setCoursesChapterName(String coursesChapterName) {
        this.coursesChapterName = coursesChapterName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coursesId", getCoursesId())
            .append("coursesName", getCoursesName())
            .append("coursesChapterId", getCoursesChapterId())
            .append("name", getName())
            .append("fileUrl", getFileUrl())
            .toString();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }
}
