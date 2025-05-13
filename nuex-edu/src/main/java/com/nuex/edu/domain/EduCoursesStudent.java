package com.nuex.edu.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 课堂管理对象 edu_courses_student
 *
 * @author john
 * @date 2025-04-09
 */
public class EduCoursesStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long coursesId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课堂管理详情信息 */
    private List<EduCoursesStudentDetails> eduCoursesStudentDetailsList;

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

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public List<EduCoursesStudentDetails> getEduCoursesStudentDetailsList()
    {
        return eduCoursesStudentDetailsList;
    }

    public void setEduCoursesStudentDetailsList(List<EduCoursesStudentDetails> eduCoursesStudentDetailsList)
    {
        this.eduCoursesStudentDetailsList = eduCoursesStudentDetailsList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coursesId", getCoursesId())
            .append("courseName", getCourseName())
            .append("eduCoursesStudentDetailsList", getEduCoursesStudentDetailsList())
            .toString();
    }
}
