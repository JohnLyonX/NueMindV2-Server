package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 视频课对象 edu_courses_details
 *
 * @author john
 * @date 2025-04-09
 */
public class EduCoursesDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @Excel(name = "编号")
    private Long id;

    /**
     * 课程编号
     */
    @Excel(name = "课程编号")
    private Long coursesId;

    /**
     * 课程章节编号
     */
    @Excel(name = "课程章节编号")
    private Long coursesChapterId;

    /**
     * 课程章节标题
     */
    @Excel(name = "课程章节标题")
    private String coursesChapterName;

    /**
     * 视频课标题
     */
    @Excel(name = "视频课标题")
    private String title;

    /**
     * 视频课视频地址
     */
    @Excel(name = "视频课视频地址")
    private String videoUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCoursesId(Long coursesId) {
        this.coursesId = coursesId;
    }

    public Long getCoursesId() {
        return coursesId;
    }

    public void setCoursesChapterId(Long coursesChapterId) {
        this.coursesChapterId = coursesChapterId;
    }

    public Long getCoursesChapterId() {
        return coursesChapterId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getCoursesChapterName() {
        return coursesChapterName;
    }

    public void setCoursesChapterName(String coursesChapterName) {
        this.coursesChapterName = coursesChapterName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("coursesId", getCoursesId())
                .append("coursesChapterId", getCoursesChapterId())
                .append("title", getTitle())
                .append("videoUrl", getVideoUrl())
                .toString();
    }
}
