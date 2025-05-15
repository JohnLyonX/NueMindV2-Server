package com.nuex.edu.mapper;

import java.util.List;
import com.nuex.edu.domain.EduExerciseQuestionsCorrelation;

/**
 * 练习题目关联表Mapper接口
 * 
 * @author hfsui1
 * @date 2025-05-14
 */
public interface EduExerciseQuestionsCorrelationMapper 
{
    /**
     * 查询练习题目关联表
     * 
     * @param id 练习题目关联表主键
     * @return 练习题目关联表
     */
    public EduExerciseQuestionsCorrelation selectEduExerciseQuestionsCorrelationById(Long id);

    /**
     * 查询练习题目关联表列表
     * 
     * @param eduExerciseQuestionsCorrelation 练习题目关联表
     * @return 练习题目关联表集合
     */
    public List<EduExerciseQuestionsCorrelation> selectEduExerciseQuestionsCorrelationList(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation);

    /**
     * 新增练习题目关联表
     * 
     * @param eduExerciseQuestionsCorrelation 练习题目关联表
     * @return 结果
     */
    public int insertEduExerciseQuestionsCorrelation(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation);

    /**
     * 修改练习题目关联表
     * 
     * @param eduExerciseQuestionsCorrelation 练习题目关联表
     * @return 结果
     */
    public int updateEduExerciseQuestionsCorrelation(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation);

    /**
     * 删除练习题目关联表
     * 
     * @param id 练习题目关联表主键
     * @return 结果
     */
    public int deleteEduExerciseQuestionsCorrelationById(Long id);

    /**
     * 批量删除练习题目关联表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteEduExerciseQuestionsCorrelationByIds(Long[] ids);
}
