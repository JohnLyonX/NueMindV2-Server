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
import com.nuex.edu.domain.EduExerciseQuestionsCorrelation;
import com.nuex.edu.service.IEduExerciseQuestionsCorrelationService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 练习题目关联表Controller
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/edu/correlation")
public class EduExerciseQuestionsCorrelationController extends BaseController
{
    @Autowired
    private IEduExerciseQuestionsCorrelationService eduExerciseQuestionsCorrelationService;

    /**
     * 查询练习题目关联表列表
     */
    @PreAuthorize("@ss.hasPermi('edu:correlation:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        startPage();
        List<EduExerciseQuestionsCorrelation> list = eduExerciseQuestionsCorrelationService.selectEduExerciseQuestionsCorrelationList(eduExerciseQuestionsCorrelation);
        return getDataTable(list);
    }

    /**
     * 导出练习题目关联表列表
     */
    @PreAuthorize("@ss.hasPermi('edu:correlation:export')")
    @Log(title = "练习题目关联表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        List<EduExerciseQuestionsCorrelation> list = eduExerciseQuestionsCorrelationService.selectEduExerciseQuestionsCorrelationList(eduExerciseQuestionsCorrelation);
        ExcelUtil<EduExerciseQuestionsCorrelation> util = new ExcelUtil<EduExerciseQuestionsCorrelation>(EduExerciseQuestionsCorrelation.class);
        util.exportExcel(response, list, "练习题目关联表数据");
    }

    /**
     * 获取练习题目关联表详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:correlation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eduExerciseQuestionsCorrelationService.selectEduExerciseQuestionsCorrelationById(id));
    }

    /**
     * 新增练习题目关联表
     */
    @PreAuthorize("@ss.hasPermi('edu:correlation:add')")
    @Log(title = "练习题目关联表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        return toAjax(eduExerciseQuestionsCorrelationService.insertEduExerciseQuestionsCorrelation(eduExerciseQuestionsCorrelation));
    }

    /**
     * 修改练习题目关联表
     */
    @PreAuthorize("@ss.hasPermi('edu:correlation:edit')")
    @Log(title = "练习题目关联表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduExerciseQuestionsCorrelation eduExerciseQuestionsCorrelation)
    {
        return toAjax(eduExerciseQuestionsCorrelationService.updateEduExerciseQuestionsCorrelation(eduExerciseQuestionsCorrelation));
    }

    /**
     * 删除练习题目关联表
     */
    @PreAuthorize("@ss.hasPermi('edu:correlation:remove')")
    @Log(title = "练习题目关联表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduExerciseQuestionsCorrelationService.deleteEduExerciseQuestionsCorrelationByIds(ids));
    }
}
