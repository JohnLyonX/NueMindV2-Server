package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduExerciseQuestionsCorrelationMapper;
import com.nuex.edu.domain.EduExerciseQuestionsCorrelation;
import com.nuex.edu.service.IEduExerciseQuestionsCorrelationService;

/**
 * 练习题目关联表Service业务层处理
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@Service
public class EduExerciseQuestionsCorrelationServiceImpl implements IEduExerciseQuestionsCorrelationService
{
    @Autowired
    private EduExerciseQuestionsCorrelationMapper eduExerciseQuestionsCorrelationMapper;

    /**
     * 查询练习题目关联表
     *
     * @param id 练习题目关联表主键
     * @return 练习题目关联表
     */
    @Override
    public EduExerciseQuestionsCorrelation selectEduExerciseQuestionsCorrelationById(Long id)
    {
        return eduExerciseQuestionsCorrelationMapper.selectEduExerciseQuestionsCorrelationById(id);
    }

    /**
     * 查询练习题目关联表列表
     *
     * @param eduExerciseQuestionsCorrelation 练习题目关联表
     * @return 练习题目关联表
     */
    @Override
    public List<EduExerciseQuestionsCorrelation> selectEduExerciseQuestionsCorrelationList(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        return eduExerciseQuestionsCorrelationMapper.selectEduExerciseQuestionsCorrelationList(eduExerciseQuestionsCorrelation);
    }

    /**
     * 新增练习题目关联表
     *
     * @param eduExerciseQuestionsCorrelation 练习题目关联表
     * @return 结果
     */
    @Override
    public int insertEduExerciseQuestionsCorrelation(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        return eduExerciseQuestionsCorrelationMapper.insertEduExerciseQuestionsCorrelation(eduExerciseQuestionsCorrelation);
    }

    /**
     * 修改练习题目关联表
     *
     * @param eduExerciseQuestionsCorrelation 练习题目关联表
     * @return 结果
     */
    @Override
    public int updateEduExerciseQuestionsCorrelation(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        return eduExerciseQuestionsCorrelationMapper.updateEduExerciseQuestionsCorrelation(eduExerciseQuestionsCorrelation);
    }

    /**
     * 批量删除练习题目关联表
     *
     * @param ids 需要删除的练习题目关联表主键
     * @return 结果
     */
    @Override
    public int deleteEduExerciseQuestionsCorrelationByIds(Long[] ids)
    {
        return eduExerciseQuestionsCorrelationMapper.deleteEduExerciseQuestionsCorrelationByIds(ids);
    }

    /**
     * 删除练习题目关联表信息
     *
     * @param id 练习题目关联表主键
     * @return 结果
     */
    @Override
    public int deleteEduExerciseQuestionsCorrelationById(Long id)
    {
        return eduExerciseQuestionsCorrelationMapper.deleteEduExerciseQuestionsCorrelationById(id);
    }
}
