package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 考试试卷提交与修改对象 edu_exam_filelib
 *
 * @author john
 * @date 2025-04-09
 */
public class EduExamFilelib extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 学生编号 */
    @Excel(name = "学生编号")
    private Long studentId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String name;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String coursesName;

    /** 考试编号 */
    @Excel(name = "考试编号")
    private Long courseChapterId;

    /** 课程章节 */
    @Excel(name = "课程章节")
    private String coursesChapter;

    /** 文件提交路径 */
    @Excel(name = "文件提交路径")
    private String subPath;

    /** 批改后的文件路径 */
    @Excel(name = "批改后的文件路径")
    private String correctPath;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private Long coursesId;
    @Excel(name = "课程考试名称")
    private String coursesExamName;
    @Excel(name = "得分")
    private int score;
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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setCoursesName(String coursesName)
    {
        this.coursesName = coursesName;
    }

    public String getCoursesName()
    {
        return coursesName;
    }

    public void setCourseChapterId(Long courseChapterId)
    {
        this.courseChapterId = courseChapterId;
    }

    public Long getCourseChapterId()
    {
        return courseChapterId;
    }

    public void setCoursesChapter(String coursesChapter)
    {
        this.coursesChapter = coursesChapter;
    }

    public String getCoursesChapter()
    {
        return coursesChapter;
    }

    public void setSubPath(String subPath)
    {
        this.subPath = subPath;
    }

    public String getSubPath()
    {
        return subPath;
    }

    public void setCorrectPath(String correctPath)
    {
        this.correctPath = correctPath;
    }

    public String getCorrectPath()
    {
        return correctPath;
    }

    public void setCoursesId(Long coursesId)
    {
        this.coursesId = coursesId;
    }

    public Long getCoursesId()
    {
        return coursesId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("studentId", getStudentId())
            .append("name", getName())
            .append("coursesName", getCoursesName())
            .append("courseChapterId", getCourseChapterId())
            .append("coursesChapter", getCoursesChapter())
            .append("subPath", getSubPath())
            .append("correctPath", getCorrectPath())
            .append("coursesId", getCoursesId())
            .toString();
    }

    public String getCoursesExamName() {
        return coursesExamName;
    }

    public void setCoursesExamName(String coursesExamName) {
        this.coursesExamName = coursesExamName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
