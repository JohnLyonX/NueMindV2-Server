package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 学生档案对象 edu_student_information
 *
 * @author john
 * @date 2025-04-02
 */
public class EduStudentInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生id */
    @Excel(name = "学生id")
    private Long id;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 学生性别 */
    @Excel(name = "学生性别")
    private String sex;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long age;

    /** 学号 */
    @Excel(name = "学号")
    private Long studentNo;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private Long phoneNumber;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 学生分析 */
    @Excel(name = "学生分析")
    private String studentAnalyze;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }

    public void setAge(Long age)
    {
        this.age = age;
    }

    public Long getAge()
    {
        return age;
    }

    public void setStudentNo(Long studentNo)
    {
        this.studentNo = studentNo;
    }

    public Long getStudentNo()
    {
        return studentNo;
    }

    public void setPhoneNumber(Long phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public Long getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }

    public void setStudentAnalyze(String studentAnalyze)
    {
        this.studentAnalyze = studentAnalyze;
    }

    public String getStudentAnalyze()
    {
        return studentAnalyze;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("sex", getSex())
            .append("age", getAge())
            .append("studentNo", getStudentNo())
            .append("phoneNumber", getPhoneNumber())
            .append("email", getEmail())
            .append("studentAnalyze", getStudentAnalyze())
            .toString();
    }
}
