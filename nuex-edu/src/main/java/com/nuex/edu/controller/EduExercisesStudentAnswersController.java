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
import com.nuex.edu.domain.EduExercisesStudentAnswers;
import com.nuex.edu.service.IEduExercisesStudentAnswersService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 学生提交答案表Controller
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/edu/answers")
public class EduExercisesStudentAnswersController extends BaseController
{
    @Autowired
    private IEduExercisesStudentAnswersService eduExercisesStudentAnswersService;

    /**
     * 查询学生提交答案表列表
     */
    @PreAuthorize("@ss.hasPermi('edu:answers:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduExercisesStudentAnswers eduExercisesStudentAnswers)
    {
        startPage();
        List<EduExercisesStudentAnswers> list = eduExercisesStudentAnswersService.selectEduExercisesStudentAnswersList(eduExercisesStudentAnswers);
        return getDataTable(list);
    }

    /**
     * 导出学生提交答案表列表
     */
    @PreAuthorize("@ss.hasPermi('edu:answers:export')")
    @Log(title = "学生提交答案表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduExercisesStudentAnswers eduExercisesStudentAnswers)
    {
        List<EduExercisesStudentAnswers> list = eduExercisesStudentAnswersService.selectEduExercisesStudentAnswersList(eduExercisesStudentAnswers);
        ExcelUtil<EduExercisesStudentAnswers> util = new ExcelUtil<EduExercisesStudentAnswers>(EduExercisesStudentAnswers.class);
        util.exportExcel(response, list, "学生提交答案表数据");
    }

    /**
     * 获取学生提交答案表详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:answers:query')")
    @GetMapping(value = "/{answerId}")
    public AjaxResult getInfo(@PathVariable("answerId") Long answerId)
    {
        return success(eduExercisesStudentAnswersService.selectEduExercisesStudentAnswersByAnswerId(answerId));
    }

    /**
     * 新增学生提交答案表
     */
    @PreAuthorize("@ss.hasPermi('edu:answers:add')")
    @Log(title = "学生提交答案表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody List<EduExercisesStudentAnswers> answersList)
    {
        return toAjax(eduExercisesStudentAnswersService.batchInsertEduExercisesStudentAnswers(answersList));
    }


    /**
     * 修改学生提交答案表
     */
    @PreAuthorize("@ss.hasPermi('edu:answers:edit')")
    @Log(title = "学生提交答案表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduExercisesStudentAnswers eduExercisesStudentAnswers)
    {
        return toAjax(eduExercisesStudentAnswersService.updateEduExercisesStudentAnswers(eduExercisesStudentAnswers));
    }

    /**
     * 删除学生提交答案表
     */
    @PreAuthorize("@ss.hasPermi('edu:answers:remove')")
    @Log(title = "学生提交答案表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{answerIds}")
    public AjaxResult remove(@PathVariable Long[] answerIds)
    {
        return toAjax(eduExercisesStudentAnswersService.deleteEduExercisesStudentAnswersByAnswerIds(answerIds));
    }
}
