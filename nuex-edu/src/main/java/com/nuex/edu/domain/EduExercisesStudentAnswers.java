package com.nuex.edu.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 学生提交答案表对象 edu_exercises_student_answers
 *
 * @author hfsui1
 * @date 2025-05-14
 */
public class EduExercisesStudentAnswers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long answerId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long studentId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long exerciseId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long questionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String selectedAnswer;

    /** 是否答对 */
    @Excel(name = "是否答对")
    private Integer isCorrect;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date answerTime;

    public void setAnswerId(Long answerId)
    {
        this.answerId = answerId;
    }

    public Long getAnswerId()
    {
        return answerId;
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

    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }

    public Long getQuestionId()
    {
        return questionId;
    }

    public void setSelectedAnswer(String selectedAnswer)
    {
        this.selectedAnswer = selectedAnswer;
    }

    public String getSelectedAnswer()
    {
        return selectedAnswer;
    }

    public void setIsCorrect(Integer isCorrect)
    {
        this.isCorrect = isCorrect;
    }

    public Integer getIsCorrect()
    {
        return isCorrect;
    }

    public void setAnswerTime(Date answerTime)
    {
        this.answerTime = answerTime;
    }

    public Date getAnswerTime()
    {
        return answerTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("answerId", getAnswerId())
            .append("studentId", getStudentId())
            .append("exerciseId", getExerciseId())
            .append("questionId", getQuestionId())
            .append("selectedAnswer", getSelectedAnswer())
            .append("isCorrect", getIsCorrect())
            .append("answerTime", getAnswerTime())
            .toString();
    }
}
