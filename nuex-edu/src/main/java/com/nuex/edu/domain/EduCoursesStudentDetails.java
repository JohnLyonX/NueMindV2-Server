package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 课堂管理详情对象 edu_courses_student_details
 *
 * @author john
 * @date 2025-04-09
 */
public class EduCoursesStudentDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 课堂ID */
    @Excel(name = "课堂ID")
    private Long coursesStudentId;

    /** 学生编号 */
    @Excel(name = "学生编号")
    private Long studentId;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String studentName;

    /** 学生手机号 */
    @Excel(name = "学生手机号")
    private String studentPhoneNumber;

    /** 学生性别 */
    @Excel(name = "学生性别")
    private String studentSex;

    /** 学生状态 */
    @Excel(name = "学生状态")
    private Long studentStatus;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCoursesStudentId(Long coursesStudentId)
    {
        this.coursesStudentId = coursesStudentId;
    }

    public Long getCoursesStudentId()
    {
        return coursesStudentId;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public void setStudentPhoneNumber(String studentPhoneNumber)
    {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentPhoneNumber()
    {
        return studentPhoneNumber;
    }
    public void setStudentSex(String studentSex)
    {
        this.studentSex = studentSex;
    }

    public String getStudentSex()
    {
        return studentSex;
    }
    public void setStudentStatus(Long studentStatus)
    {
        this.studentStatus = studentStatus;
    }

    public Long getStudentStatus()
    {
        return studentStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("coursesStudentId", getCoursesStudentId())
            .append("studentId", getStudentId())
            .append("studentName", getStudentName())
            .append("studentPhoneNumber", getStudentPhoneNumber())
            .append("studentSex", getStudentSex())
            .append("studentStatus", getStudentStatus())
            .toString();
    }
}
