package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduExercisesQuestions;

/**
 * 练习题目Service接口
 * 
 * @author hfsui1
 * @date 2025-05-14
 */
public interface IEduExercisesQuestionsService 
{
    /**
     * 查询练习题目
     * 
     * @param questionId 练习题目主键
     * @return 练习题目
     */
    public EduExercisesQuestions selectEduExercisesQuestionsByQuestionId(Long questionId);

    /**
     * 查询练习题目列表
     * 
     * @param eduExercisesQuestions 练习题目
     * @return 练习题目集合
     */
    public List<EduExercisesQuestions> selectEduExercisesQuestionsList(EduExercisesQuestions eduExercisesQuestions);

    /**
     * 新增练习题目
     * 
     * @param eduExercisesQuestions 练习题目
     * @return 结果
     */
    public int insertEduExercisesQuestions(EduExercisesQuestions eduExercisesQuestions);

    /**
     * 修改练习题目
     * 
     * @param eduExercisesQuestions 练习题目
     * @return 结果
     */
    public int updateEduExercisesQuestions(EduExercisesQuestions eduExercisesQuestions);

    /**
     * 批量删除练习题目
     * 
     * @param questionIds 需要删除的练习题目主键集合
     * @return 结果
     */
    public int deleteEduExercisesQuestionsByQuestionIds(Long[] questionIds);

    /**
     * 删除练习题目信息
     * 
     * @param questionId 练习题目主键
     * @return 结果
     */
    public int deleteEduExercisesQuestionsByQuestionId(Long questionId);
}
