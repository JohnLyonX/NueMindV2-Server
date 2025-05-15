package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduExerciseScoresMapper;
import com.nuex.edu.domain.EduExerciseScores;
import com.nuex.edu.service.IEduExerciseScoresService;

/**
 * 成绩表Service业务层处理
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@Service
public class EduExerciseScoresServiceImpl implements IEduExerciseScoresService
{
    @Autowired
    private EduExerciseScoresMapper eduExerciseScoresMapper;

    /**
     * 查询成绩表
     *
     * @param scoreId 成绩表主键
     * @return 成绩表
     */
    @Override
    public EduExerciseScores selectEduExerciseScoresByScoreId(Long scoreId)
    {
        return eduExerciseScoresMapper.selectEduExerciseScoresByScoreId(scoreId);
    }

    /**
     * 查询成绩表列表
     *
     * @param eduExerciseScores 成绩表
     * @return 成绩表
     */
    @Override
    public List<EduExerciseScores> selectEduExerciseScoresList(EduExerciseScores eduExerciseScores)
    {
        return eduExerciseScoresMapper.selectEduExerciseScoresList(eduExerciseScores);
    }

    /**
     * 新增成绩表
     *
     * @param eduExerciseScores 成绩表
     * @return 结果
     */
    @Override
    public int insertEduExerciseScores(EduExerciseScores eduExerciseScores)
    {
        return eduExerciseScoresMapper.insertEduExerciseScores(eduExerciseScores);
    }

    /**
     * 修改成绩表
     *
     * @param eduExerciseScores 成绩表
     * @return 结果
     */
    @Override
    public int updateEduExerciseScores(EduExerciseScores eduExerciseScores)
    {
        return eduExerciseScoresMapper.updateEduExerciseScores(eduExerciseScores);
    }

    /**
     * 批量删除成绩表
     *
     * @param scoreIds 需要删除的成绩表主键
     * @return 结果
     */
    @Override
    public int deleteEduExerciseScoresByScoreIds(Long[] scoreIds)
    {
        return eduExerciseScoresMapper.deleteEduExerciseScoresByScoreIds(scoreIds);
    }

    /**
     * 删除成绩表信息
     *
     * @param scoreId 成绩表主键
     * @return 结果
     */
    @Override
    public int deleteEduExerciseScoresByScoreId(Long scoreId)
    {
        return eduExerciseScoresMapper.deleteEduExerciseScoresByScoreId(scoreId);
    }
}
