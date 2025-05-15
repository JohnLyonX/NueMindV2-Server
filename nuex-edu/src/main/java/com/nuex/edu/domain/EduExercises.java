package com.nuex.edu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 练习集合对象 edu_exercises
 *
 * @author hfsui1
 * @date 2025-05-14
 */
public class EduExercises extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long exerciseId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String title;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** 创建练习的老师ID */
    @Excel(name = "创建练习的老师ID")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date createdAt;

    /** 练习提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "练习提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date submissionTime;

    /** 时间限制(分钟) */
    @Excel(name = "时间限制(分钟)")
    private Long timeLimit;

    /** 是否已发布 */
    @Excel(name = "是否已发布")
    private Integer status;

    public void setExerciseId(Long exerciseId)
    {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId()
    {
        return exerciseId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public void setSubmissionTime(Date submissionTime)
    {
        this.submissionTime = submissionTime;
    }

    public Date getSubmissionTime()
    {
        return submissionTime;
    }

    public void setTimeLimit(Long timeLimit)
    {
        this.timeLimit = timeLimit;
    }

    public Long getTimeLimit()
    {
        return timeLimit;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("exerciseId", getExerciseId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("userId", getUserId())
            .append("createdAt", getCreatedAt())
            .append("submissionTime", getSubmissionTime())
            .append("timeLimit", getTimeLimit())
            .append("status", getStatus())
            .toString();
    }
}
