package com.nuex.edu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.nuex.common.annotation.Excel;
import com.nuex.common.core.domain.BaseEntity;

/**
 * 练习题目关联表对象 edu_exercise_questions_correlation
 *
 * @author hfsui1
 * @date 2025-05-14
 */
public class EduExerciseQuestionsCorrelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long exerciseId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long questionId;

    /** 题目在练习中的顺序 */
    @Excel(name = "题目在练习中的顺序")
    private Long questionOrder;

    /** 本题分值 */
    @Excel(name = "本题分值")
    private Long score;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
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

    public void setQuestionOrder(Long questionOrder)
    {
        this.questionOrder = questionOrder;
    }

    public Long getQuestionOrder()
    {
        return questionOrder;
    }

    public void setScore(Long score)
    {
        this.score = score;
    }

    public Long getScore()
    {
        return score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("exerciseId", getExerciseId())
            .append("questionId", getQuestionId())
            .append("questionOrder", getQuestionOrder())
            .append("score", getScore())
            .toString();
    }
}
