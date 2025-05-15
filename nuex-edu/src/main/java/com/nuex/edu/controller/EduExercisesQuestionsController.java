package com.nuex.edu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nuex.common.annotation.Log;
import com.nuex.common.core.controller.BaseController;
import com.nuex.common.core.domain.AjaxResult;
import com.nuex.common.enums.BusinessType;
import com.nuex.edu.domain.EduExercisesQuestions;
import com.nuex.edu.service.IEduExercisesQuestionsService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 练习题目Controller
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/edu/questions")
public class EduExercisesQuestionsController extends BaseController
{
    @Autowired
    private IEduExercisesQuestionsService eduExercisesQuestionsService;

    /**
     * 查询练习题目列表
     */
    @PreAuthorize("@ss.hasPermi('edu:questions:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduExercisesQuestions eduExercisesQuestions)
    {
        startPage();
        List<EduExercisesQuestions> list = eduExercisesQuestionsService.selectEduExercisesQuestionsList(eduExercisesQuestions);
        return getDataTable(list);
    }

    /**
     * 导出练习题目列表
     */
    @PreAuthorize("@ss.hasPermi('edu:questions:export')")
    @Log(title = "练习题目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduExercisesQuestions eduExercisesQuestions)
    {
        List<EduExercisesQuestions> list = eduExercisesQuestionsService.selectEduExercisesQuestionsList(eduExercisesQuestions);
        ExcelUtil<EduExercisesQuestions> util = new ExcelUtil<EduExercisesQuestions>(EduExercisesQuestions.class);
        util.exportExcel(response, list, "练习题目数据");
    }

    /**
     * 获取练习题目详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:questions:query')")
    @GetMapping(value = "/{questionId}")
    public AjaxResult getInfo(@PathVariable("questionId") Long questionId)
    {
        return success(eduExercisesQuestionsService.selectEduExercisesQuestionsByQuestionId(questionId));
    }

    /**
     * 新增练习题目
     */
    @PreAuthorize("@ss.hasPermi('edu:questions:add')")
    @Log(title = "练习题目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduExercisesQuestions eduExercisesQuestions)
    {
        return toAjax(eduExercisesQuestionsService.insertEduExercisesQuestions(eduExercisesQuestions));
    }

    /**
     * 修改练习题目
     */
    @PreAuthorize("@ss.hasPermi('edu:questions:edit')")
    @Log(title = "练习题目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduExercisesQuestions eduExercisesQuestions)
    {
        return toAjax(eduExercisesQuestionsService.updateEduExercisesQuestions(eduExercisesQuestions));
    }

    /**
     * 删除练习题目
     */
    @PreAuthorize("@ss.hasPermi('edu:questions:remove')")
    @Log(title = "练习题目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{questionIds}")
    public AjaxResult remove(@PathVariable Long[] questionIds)
    {
        return toAjax(eduExercisesQuestionsService.deleteEduExercisesQuestionsByQuestionIds(questionIds));
    }
}
