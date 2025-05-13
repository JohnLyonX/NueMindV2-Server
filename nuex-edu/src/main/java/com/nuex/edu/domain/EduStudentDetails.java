package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 学生信息详情对象 edu_student_details
 *
 * @author john
 * @date 2025-04-09
 */
public class EduStudentDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生编号 */
    @Excel(name = "学生编号")
    private Long studentId;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 专业 */
    @Excel(name = "专业")
    private String major;

    /** 年级 */
    @Excel(name = "年级")
    private String grade;

    /** 班级 */
    @Excel(name = "班级")
    private String classinfo;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 代码能力 */
    @Excel(name = "代码能力")
    private Long codeAbility;

    /** 学习能力 */
    @Excel(name = "学习能力")
    private Long studyAbility;

    /** 逻辑能力 */
    @Excel(name = "逻辑能力")
    private Long thinkingAbility;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getSchool()
    {
        return school;
    }
    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getMajor()
    {
        return major;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setClassinfo(String classinfo)
    {
        this.classinfo = classinfo;
    }

    public String getClassinfo()
    {
        return classinfo;
    }
    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setCodeAbility(Long codeAbility)
    {
        this.codeAbility = codeAbility;
    }

    public Long getCodeAbility()
    {
        return codeAbility;
    }
    public void setStudyAbility(Long studyAbility)
    {
        this.studyAbility = studyAbility;
    }

    public Long getStudyAbility()
    {
        return studyAbility;
    }
    public void setThinkingAbility(Long thinkingAbility)
    {
        this.thinkingAbility = thinkingAbility;
    }

    public Long getThinkingAbility()
    {
        return thinkingAbility;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("school", getSchool())
            .append("major", getMajor())
            .append("grade", getGrade())
            .append("classinfo", getClassinfo())
            .append("age", getAge())
            .append("sex", getSex())
            .append("email", getEmail())
            .append("codeAbility", getCodeAbility())
            .append("studyAbility", getStudyAbility())
            .append("thinkingAbility", getThinkingAbility())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
