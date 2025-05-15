package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduExerciseScores;

/**
 * 成绩表Service接口
 * 
 * @author hfsui1
 * @date 2025-05-14
 */
public interface IEduExerciseScoresService 
{
    /**
     * 查询成绩表
     * 
     * @param scoreId 成绩表主键
     * @return 成绩表
     */
    public EduExerciseScores selectEduExerciseScoresByScoreId(Long scoreId);

    /**
     * 查询成绩表列表
     * 
     * @param eduExerciseScores 成绩表
     * @return 成绩表集合
     */
    public List<EduExerciseScores> selectEduExerciseScoresList(EduExerciseScores eduExerciseScores);

    /**
     * 新增成绩表
     * 
     * @param eduExerciseScores 成绩表
     * @return 结果
     */
    public int insertEduExerciseScores(EduExerciseScores eduExerciseScores);

    /**
     * 修改成绩表
     * 
     * @param eduExerciseScores 成绩表
     * @return 结果
     */
    public int updateEduExerciseScores(EduExerciseScores eduExerciseScores);

    /**
     * 批量删除成绩表
     * 
     * @param scoreIds 需要删除的成绩表主键集合
     * @return 结果
     */
    public int deleteEduExerciseScoresByScoreIds(Long[] scoreIds);

    /**
     * 删除成绩表信息
     * 
     * @param scoreId 成绩表主键
     * @return 结果
     */
    public int deleteEduExerciseScoresByScoreId(Long scoreId);
}
