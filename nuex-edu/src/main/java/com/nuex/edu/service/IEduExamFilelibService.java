package com.nuex.edu.service;

import java.util.List;
import com.nuex.edu.domain.EduExamFilelib;

/**
 * 考试试卷提交与修改Service接口
 * 
 * @author john
 * @date 2025-04-09
 */
public interface IEduExamFilelibService 
{
    /**
     * 查询考试试卷提交与修改
     * 
     * @param id 考试试卷提交与修改主键
     * @return 考试试卷提交与修改
     */
    public EduExamFilelib selectEduExamFilelibById(Long id);

    /**
     * 查询考试试卷提交与修改列表
     * 
     * @param eduExamFilelib 考试试卷提交与修改
     * @return 考试试卷提交与修改集合
     */
    public List<EduExamFilelib> selectEduExamFilelibList(EduExamFilelib eduExamFilelib);

    /**
     * 新增考试试卷提交与修改
     * 
     * @param eduExamFilelib 考试试卷提交与修改
     * @return 结果
     */
    public int insertEduExamFilelib(EduExamFilelib eduExamFilelib);

    /**
     * 修改考试试卷提交与修改
     * 
     * @param eduExamFilelib 考试试卷提交与修改
     * @return 结果
     */
    public int updateEduExamFilelib(EduExamFilelib eduExamFilelib);

    /**
     * 批量删除考试试卷提交与修改
     * 
     * @param ids 需要删除的考试试卷提交与修改主键集合
     * @return 结果
     */
    public int deleteEduExamFilelibByIds(Long[] ids);

    /**
     * 删除考试试卷提交与修改信息
     * 
     * @param id 考试试卷提交与修改主键
     * @return 结果
     */
    public int deleteEduExamFilelibById(Long id);
}
