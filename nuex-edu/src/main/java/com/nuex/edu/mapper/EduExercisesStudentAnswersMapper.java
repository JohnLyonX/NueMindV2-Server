package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduExercisesStudentAnswers;

/**
 * 学生提交答案表Mapper接口
 * 
 * @author hfsui1
 * @date 2025-05-14
 */
public interface EduExercisesStudentAnswersMapper 
{
    /**
     * 查询学生提交答案表
     * 
     * @param answerId 学生提交答案表主键
     * @return 学生提交答案表
     */
    public EduExercisesStudentAnswers selectEduExercisesStudentAnswersByAnswerId(Long answerId);

    /**
     * 查询学生提交答案表列表
     * 
     * @param eduExercisesStudentAnswers 学生提交答案表
     * @return 学生提交答案表集合
     */
    public List<EduExercisesStudentAnswers> selectEduExercisesStudentAnswersList(EduExercisesStudentAnswers eduExercisesStudentAnswers);

    /**
     * 新增学生提交答案表
     * 
     * @param eduExercisesStudentAnswers 学生提交答案表
     * @return 结果
     */
    public int insertEduExercisesStudentAnswers(EduExercisesStudentAnswers eduExercisesStudentAnswers);

    /**
     * 修改学生提交答案表
     * 
     * @param eduExercisesStudentAnswers 学生提交答案表
     * @return 结果
     */
    public int updateEduExercisesStudentAnswers(EduExercisesStudentAnswers eduExercisesStudentAnswers);

    /**
     * 删除学生提交答案表
     * 
     * @param answerId 学生提交答案表主键
     * @return 结果
     */
    public int deleteEduExercisesStudentAnswersByAnswerId(Long answerId);

    /**
     * 批量删除学生提交答案表
     * 
     * @param answerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduExercisesStudentAnswersByAnswerIds(Long[] answerIds);
}
