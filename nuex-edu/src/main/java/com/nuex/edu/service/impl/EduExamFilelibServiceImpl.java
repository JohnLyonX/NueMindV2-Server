package com.nuex.edu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nuex.edu.mapper.EduExamFilelibMapper;
import com.nuex.edu.domain.EduExamFilelib;
import com.nuex.edu.service.IEduExamFilelibService;

/**
 * 考试试卷提交与修改Service业务层处理
 *
 * @author john
 * @date 2025-04-09
 */
@Service
public class EduExamFilelibServiceImpl implements IEduExamFilelibService
{
    @Autowired
    private EduExamFilelibMapper eduExamFilelibMapper;

    /**
     * 查询考试试卷提交与修改
     *
     * @param id 考试试卷提交与修改主键
     * @return 考试试卷提交与修改
     */
    @Override
    public EduExamFilelib selectEduExamFilelibById(Long id)
    {
        return eduExamFilelibMapper.selectEduExamFilelibById(id);
    }

    /**
     * 查询考试试卷提交与修改列表
     *
     * @param eduExamFilelib 考试试卷提交与修改
     * @return 考试试卷提交与修改
     */
    @Override
    public List<EduExamFilelib> selectEduExamFilelibList(EduExamFilelib eduExamFilelib)
    {
        return eduExamFilelibMapper.selectEduExamFilelibList(eduExamFilelib);
    }

    /**
     * 新增考试试卷提交与修改
     *
     * @param eduExamFilelib 考试试卷提交与修改
     * @return 结果
     */
    @Override
    public int insertEduExamFilelib(EduExamFilelib eduExamFilelib)
    {
        return eduExamFilelibMapper.insertEduExamFilelib(eduExamFilelib);
    }

    /**
     * 修改考试试卷提交与修改
     *
     * @param eduExamFilelib 考试试卷提交与修改
     * @return 结果
     */
    @Override
    public int updateEduExamFilelib(EduExamFilelib eduExamFilelib)
    {
        return eduExamFilelibMapper.updateEduExamFilelib(eduExamFilelib);
    }

    /**
     * 批量删除考试试卷提交与修改
     *
     * @param ids 需要删除的考试试卷提交与修改主键
     * @return 结果
     */
    @Override
    public int deleteEduExamFilelibByIds(Long[] ids)
    {
        return eduExamFilelibMapper.deleteEduExamFilelibByIds(ids);
    }

    /**
     * 删除考试试卷提交与修改信息
     *
     * @param id 考试试卷提交与修改主键
     * @return 结果
     */
    @Override
    public int deleteEduExamFilelibById(Long id)
    {
        return eduExamFilelibMapper.deleteEduExamFilelibById(id);
    }
}
