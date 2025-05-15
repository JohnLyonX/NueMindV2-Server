package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduExercisesMapper;
import com.nuex.edu.domain.EduExercises;
import com.nuex.edu.service.IEduExercisesService;

/**
 * 练习集合Service业务层处理
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@Service
public class EduExercisesServiceImpl implements IEduExercisesService
{
    @Autowired
    private EduExercisesMapper eduExercisesMapper;

    /**
     * 查询练习集合
     *
     * @param exerciseId 练习集合主键
     * @return 练习集合
     */
    @Override
    public EduExercises selectEduExercisesByExerciseId(Long exerciseId)
    {
        return eduExercisesMapper.selectEduExercisesByExerciseId(exerciseId);
    }

    /**
     * 查询练习集合列表
     *
     * @param eduExercises 练习集合
     * @return 练习集合
     */
    @Override
    public List<EduExercises> selectEduExercisesList(EduExercises eduExercises)
    {
        return eduExercisesMapper.selectEduExercisesList(eduExercises);
    }

    /**
     * 新增练习集合
     *
     * @param eduExercises 练习集合
     * @return 结果
     */
    @Override
    public int insertEduExercises(EduExercises eduExercises)
    {
        return eduExercisesMapper.insertEduExercises(eduExercises);
    }

    /**
     * 修改练习集合
     *
     * @param eduExercises 练习集合
     * @return 结果
     */
    @Override
    public int updateEduExercises(EduExercises eduExercises)
    {
        return eduExercisesMapper.updateEduExercises(eduExercises);
    }

    /**
     * 批量删除练习集合
     *
     * @param exerciseIds 需要删除的练习集合主键
     * @return 结果
     */
    @Override
    public int deleteEduExercisesByExerciseIds(Long[] exerciseIds)
    {
        return eduExercisesMapper.deleteEduExercisesByExerciseIds(exerciseIds);
    }

    /**
     * 删除练习集合信息
     *
     * @param exerciseId 练习集合主键
     * @return 结果
     */
    @Override
    public int deleteEduExercisesByExerciseId(Long exerciseId)
    {
        return eduExercisesMapper.deleteEduExercisesByExerciseId(exerciseId);
    }
}
