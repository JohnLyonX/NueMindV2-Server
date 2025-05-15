package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 练习题目对象 edu_exercises_questions
 *
 * @author hfsui1
 * @date 2025-05-14
 */
public class EduExercisesQuestions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long questionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String questionText;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionA;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionB;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionC;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionD;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String correctAnswer;

    /** 题目解析 */
    @Excel(name = "题目解析")
    private String explanation;

    /** 所属科目 */
    @Excel(name = "所属科目")
    private String coursesName;

    /** 创建题目的老师ID */
    @Excel(name = "创建题目的老师ID")
    private Long userId;

    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }

    public Long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }

    public String getQuestionText()
    {
        return questionText;
    }

    public void setOptionA(String optionA)
    {
        this.optionA = optionA;
    }

    public String getOptionA()
    {
        return optionA;
    }

    public void setOptionB(String optionB)
    {
        this.optionB = optionB;
    }

    public String getOptionB()
    {
        return optionB;
    }

    public void setOptionC(String optionC)
    {
        this.optionC = optionC;
    }

    public String getOptionC()
    {
        return optionC;
    }

    public void setOptionD(String optionD)
    {
        this.optionD = optionD;
    }

    public String getOptionD()
    {
        return optionD;
    }

    public void setCorrectAnswer(String correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer()
    {
        return correctAnswer;
    }

    public void setExplanation(String explanation)
    {
        this.explanation = explanation;
    }

    public String getExplanation()
    {
        return explanation;
    }

    public void setCoursesName(String coursesName)
    {
        this.coursesName = coursesName;
    }

    public String getCoursesName()
    {
        return coursesName;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("questionId", getQuestionId())
            .append("questionText", getQuestionText())
            .append("optionA", getOptionA())
            .append("optionB", getOptionB())
            .append("optionC", getOptionC())
            .append("optionD", getOptionD())
            .append("correctAnswer", getCorrectAnswer())
            .append("explanation", getExplanation())
            .append("coursesName", getCoursesName())
            .append("userId", getUserId())
            .toString();
    }
}
