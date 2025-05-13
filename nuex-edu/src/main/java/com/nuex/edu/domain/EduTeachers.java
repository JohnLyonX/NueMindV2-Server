package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 教师对象 edu_teachers
 *
 * @author john
 * @date 2025-04-02
 */
public class EduTeachers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师ID */
    @Excel(name = "教师ID")
    private Long id;

    /** 教师名称 */
    @Excel(name = "教师名称")
    private String name;

    /** 教师介绍 */
    @Excel(name = "教师介绍")
    private String description;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

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

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getPosition()
    {
        return position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("description", getDescription())
            .append("position", getPosition())
            .toString();
    }
}
