package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduExercisesStudentAnswersMapper;
import com.nuex.edu.domain.EduExercisesStudentAnswers;
import com.nuex.edu.service.IEduExercisesStudentAnswersService;

/**
 * 学生提交答案表Service业务层处理
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@Service
public class EduExercisesStudentAnswersServiceImpl implements IEduExercisesStudentAnswersService
{
    @Autowired
    private EduExercisesStudentAnswersMapper eduExercisesStudentAnswersMapper;

    /**
     * 查询学生提交答案表
     *
     * @param answerId 学生提交答案表主键
     * @return 学生提交答案表
     */
    @Override
    public EduExercisesStudentAnswers selectEduExercisesStudentAnswersByAnswerId(Long answerId)
    {
        return eduExercisesStudentAnswersMapper.selectEduExercisesStudentAnswersByAnswerId(answerId);
    }

    /**
     * 查询学生提交答案表列表
     *
     * @param eduExercisesStudentAnswers 学生提交答案表
     * @return 学生提交答案表
     */
    @Override
    public List<EduExercisesStudentAnswers> selectEduExercisesStudentAnswersList(EduExercisesStudentAnswers eduExercisesStudentAnswers)
    {
        return eduExercisesStudentAnswersMapper.selectEduExercisesStudentAnswersList(eduExercisesStudentAnswers);
    }

    /**
     * 新增学生提交答案表
     *
     * @param eduExercisesStudentAnswers 学生提交答案表
     * @return 结果
     */
    @Override
    public int insertEduExercisesStudentAnswers(EduExercisesStudentAnswers eduExercisesStudentAnswers)
    {
        return eduExercisesStudentAnswersMapper.insertEduExercisesStudentAnswers(eduExercisesStudentAnswers);
    }

    /**
     * 修改学生提交答案表
     *
     * @param eduExercisesStudentAnswers 学生提交答案表
     * @return 结果
     */
    @Override
    public int updateEduExercisesStudentAnswers(EduExercisesStudentAnswers eduExercisesStudentAnswers)
    {
        return eduExercisesStudentAnswersMapper.updateEduExercisesStudentAnswers(eduExercisesStudentAnswers);
    }

    /**
     * 批量删除学生提交答案表
     *
     * @param answerIds 需要删除的学生提交答案表主键
     * @return 结果
     */
    @Override
    public int deleteEduExercisesStudentAnswersByAnswerIds(Long[] answerIds)
    {
        return eduExercisesStudentAnswersMapper.deleteEduExercisesStudentAnswersByAnswerIds(answerIds);
    }

    /**
     * 删除学生提交答案表信息
     *
     * @param answerId 学生提交答案表主键
     * @return 结果
     */
    @Override
    public int deleteEduExercisesStudentAnswersByAnswerId(Long answerId)
    {
        return eduExercisesStudentAnswersMapper.deleteEduExercisesStudentAnswersByAnswerId(answerId);
    }

    /**
     * 批量新增学生提交答案表
     *
     * @param answersList 学生提交的答案列表
     * @return 结果
     */
    @Override
    public int batchInsertEduExercisesStudentAnswers(List<EduExercisesStudentAnswers> answersList)
    {
        return eduExercisesStudentAnswersMapper.batchInsertEduExercisesStudentAnswers(answersList);
    }
}
