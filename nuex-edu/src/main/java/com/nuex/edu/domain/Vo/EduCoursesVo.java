package com.nuex.edu.domain.Vo;

import com.nuex.common.annotation.Excel;

import java.math.BigDecimal;

public class EduCoursesVo {
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long id;

    /** 课程名字 */
    @Excel(name = "课程名字")
    private String name;

    /** 课程描述 */
    @Excel(name = "课程描述")
    private String description;

     /** 教师名称 */
    @Excel(name = "教师名称")
    private String teacherName;
    @Excel(name = "学习进度")
    private Integer progress;
    /** 教师介绍 */
    @Excel(name = "教师介绍")
    private String teacherDescription;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    /** 封面图片URL */
    @Excel(name = "封面图片URL")
    private String coverImage;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 状态(1:上线;0:下线) */
    @Excel(name = "状态(1:上线;0:下线)")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDescription() {
        return teacherDescription;
    }

    public void setTeacherDescription(String teacherDescription) {
        this.teacherDescription = teacherDescription;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }
}
