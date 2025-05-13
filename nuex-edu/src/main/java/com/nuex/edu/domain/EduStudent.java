package com.nuex.edu.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 学生基本信息对象 edu_student
 *
 * @author john
 * @date 2025-04-09
 */
public class EduStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生编号 */
    @Excel(name = "学生编号")
    private Long id;

    /** 学生名字 */
    @Excel(name = "学生名字")
    private String name;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String url;


    /** 登陆账号 */
    @Excel(name = "登陆账号")
    private String phoneNumber;

    /** 登陆密码 */
    @Excel(name = "登陆密码")
    private String password;

    /** 学生信息详情信息 */
    private List<EduStudentDetails> eduStudentDetailsList;

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

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public List<EduStudentDetails> getEduStudentDetailsList()
    {
        return eduStudentDetailsList;
    }

    public void setEduStudentDetailsList(List<EduStudentDetails> eduStudentDetailsList)
    {
        this.eduStudentDetailsList = eduStudentDetailsList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phoneNumber", getPhoneNumber())
            .append("password", getPassword())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("eduStudentDetailsList", getEduStudentDetailsList())
            .toString();
    }
}
