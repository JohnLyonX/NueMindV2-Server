package com.nuex.edu.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 成绩表对象 edu_exercise_scores
 *
 * @author hfsui1
 * @date 2025-05-14
 */
public class EduExerciseScores extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long scoreId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long studentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long exerciseId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal totalScore;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long maxScore;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date completionTime;

    public void setScoreId(Long scoreId)
    {
        this.scoreId = scoreId;
    }

    public Long getScoreId()
    {
        return scoreId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }

    public void setExerciseId(Long exerciseId)
    {
        this.exerciseId = exerciseId;
    }

    public Long getExerciseId()
    {
        return exerciseId;
    }

    public void setTotalScore(BigDecimal totalScore)
    {
        this.totalScore = totalScore;
    }

    public BigDecimal getTotalScore()
    {
        return totalScore;
    }

    public void setMaxScore(Long maxScore)
    {
        this.maxScore = maxScore;
    }

    public Long getMaxScore()
    {
        return maxScore;
    }

    public void setCompletionTime(Date completionTime)
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime()
    {
        return completionTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scoreId", getScoreId())
            .append("studentId", getStudentId())
            .append("exerciseId", getExerciseId())
            .append("totalScore", getTotalScore())
            .append("maxScore", getMaxScore())
            .append("completionTime", getCompletionTime())
            .toString();
    }
}
