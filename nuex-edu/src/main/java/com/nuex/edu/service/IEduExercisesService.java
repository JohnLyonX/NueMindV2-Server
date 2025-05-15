package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduExercises;

/**
 * 练习集合Service接口
 * 
 * @author hfsui1
 * @date 2025-05-14
 */
public interface IEduExercisesService 
{
    /**
     * 查询练习集合
     * 
     * @param exerciseId 练习集合主键
     * @return 练习集合
     */
    public EduExercises selectEduExercisesByExerciseId(Long exerciseId);

    /**
     * 查询练习集合列表
     * 
     * @param eduExercises 练习集合
     * @return 练习集合集合
     */
    public List<EduExercises> selectEduExercisesList(EduExercises eduExercises);

    /**
     * 新增练习集合
     * 
     * @param eduExercises 练习集合
     * @return 结果
     */
    public int insertEduExercises(EduExercises eduExercises);

    /**
     * 修改练习集合
     * 
     * @param eduExercises 练习集合
     * @return 结果
     */
    public int updateEduExercises(EduExercises eduExercises);

    /**
     * 批量删除练习集合
     * 
     * @param exerciseIds 需要删除的练习集合主键集合
     * @return 结果
     */
    public int deleteEduExercisesByExerciseIds(Long[] exerciseIds);

    /**
     * 删除练习集合信息
     * 
     * @param exerciseId 练习集合主键
     * @return 结果
     */
    public int deleteEduExercisesByExerciseId(Long exerciseId);
}
