package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 视频课对象 edu_video_lesson
 *
 * @author john
 * @date 2025-04-02
 */
public class EduVideoLesson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 视频课id */
    private Long id;

    /** 视频课名称 */
    @Excel(name = "视频课名称")
    private String name;

    /** 课程id */
    private Long courseId;

    /** 视频url */
    @Excel(name = "视频url")
    private String videoUrl;

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
    public void setCourseId(Long courseId)
    {
        this.courseId = courseId;
    }

    public Long getCourseId()
    {
        return courseId;
    }
    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("courseId", getCourseId())
            .append("videoUrl", getVideoUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
