package com.nuex.edu.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 课程对象 edu_courses
 *
 * @author john
 * @date 2025-04-09
 */
public class EduCourses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @Excel(name = "编号")
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String url;

    /** 课程简介 */
    @Excel(name = "课程简介")
    private String summary;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 课程状态 */
    @Excel(name = "课程状态")
    private Long status;
    /** 教师姓名（新增字段） */
    @Excel(name = "教师姓名")
    private String teacherName;

    /** 学习进度（新增字段，假设为整数百分比） */
    @Excel(name = "学习进度")
    private Integer progress;
    /** 视频课信息 */
    private List<EduCoursesDetails> eduCoursesDetailsList;

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

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public List<EduCoursesDetails> getEduCoursesDetailsList()
    {
        return eduCoursesDetailsList;
    }

    public void setEduCoursesDetailsList(List<EduCoursesDetails> eduCoursesDetailsList)
    {
        this.eduCoursesDetailsList = eduCoursesDetailsList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("url", getUrl())
            .append("summary", getSummary())
            .append("price", getPrice())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("eduCoursesDetailsList", getEduCoursesDetailsList())
            .append("teacherName", getTeacherName())
            .append("progress", getProgress())
            .toString();
    }
}
