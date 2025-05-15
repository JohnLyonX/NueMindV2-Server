package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduExercisesQuestionsMapper;
import com.nuex.edu.domain.EduExercisesQuestions;
import com.nuex.edu.service.IEduExercisesQuestionsService;

/**
 * 练习题目Service业务层处理
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@Service
public class EduExercisesQuestionsServiceImpl implements IEduExercisesQuestionsService
{
    @Autowired
    private EduExercisesQuestionsMapper eduExercisesQuestionsMapper;

    /**
     * 查询练习题目
     *
     * @param questionId 练习题目主键
     * @return 练习题目
     */
    @Override
    public EduExercisesQuestions selectEduExercisesQuestionsByQuestionId(Long questionId)
    {
        return eduExercisesQuestionsMapper.selectEduExercisesQuestionsByQuestionId(questionId);
    }

    /**
     * 查询练习题目列表
     *
     * @param eduExercisesQuestions 练习题目
     * @return 练习题目
     */
    @Override
    public List<EduExercisesQuestions> selectEduExercisesQuestionsList(EduExercisesQuestions eduExercisesQuestions)
    {
        return eduExercisesQuestionsMapper.selectEduExercisesQuestionsList(eduExercisesQuestions);
    }

    /**
     * 新增练习题目
     *
     * @param eduExercisesQuestions 练习题目
     * @return 结果
     */
    @Override
    public int insertEduExercisesQuestions(EduExercisesQuestions eduExercisesQuestions)
    {
        return eduExercisesQuestionsMapper.insertEduExercisesQuestions(eduExercisesQuestions);
    }

    /**
     * 修改练习题目
     *
     * @param eduExercisesQuestions 练习题目
     * @return 结果
     */
    @Override
    public int updateEduExercisesQuestions(EduExercisesQuestions eduExercisesQuestions)
    {
        return eduExercisesQuestionsMapper.updateEduExercisesQuestions(eduExercisesQuestions);
    }

    /**
     * 批量删除练习题目
     *
     * @param questionIds 需要删除的练习题目主键
     * @return 结果
     */
    @Override
    public int deleteEduExercisesQuestionsByQuestionIds(Long[] questionIds)
    {
        return eduExercisesQuestionsMapper.deleteEduExercisesQuestionsByQuestionIds(questionIds);
    }

    /**
     * 删除练习题目信息
     *
     * @param questionId 练习题目主键
     * @return 结果
     */
    @Override
    public int deleteEduExercisesQuestionsByQuestionId(Long questionId)
    {
        return eduExercisesQuestionsMapper.deleteEduExercisesQuestionsByQuestionId(questionId);
    }
}
