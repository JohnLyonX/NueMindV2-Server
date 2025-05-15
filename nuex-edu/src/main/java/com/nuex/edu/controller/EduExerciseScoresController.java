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
import com.nuex.edu.domain.EduExerciseScores;
import com.nuex.edu.service.IEduExerciseScoresService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 成绩表Controller
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/edu/scores")
public class EduExerciseScoresController extends BaseController
{
    @Autowired
    private IEduExerciseScoresService eduExerciseScoresService;

    /**
     * 查询成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('edu:scores:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduExerciseScores eduExerciseScores)
    {
        startPage();
        List<EduExerciseScores> list = eduExerciseScoresService.selectEduExerciseScoresList(eduExerciseScores);
        return getDataTable(list);
    }

    /**
     * 导出成绩表列表
     */
    @PreAuthorize("@ss.hasPermi('edu:scores:export')")
    @Log(title = "成绩表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduExerciseScores eduExerciseScores)
    {
        List<EduExerciseScores> list = eduExerciseScoresService.selectEduExerciseScoresList(eduExerciseScores);
        ExcelUtil<EduExerciseScores> util = new ExcelUtil<EduExerciseScores>(EduExerciseScores.class);
        util.exportExcel(response, list, "成绩表数据");
    }

    /**
     * 获取成绩表详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:scores:query')")
    @GetMapping(value = "/{scoreId}")
    public AjaxResult getInfo(@PathVariable("scoreId") Long scoreId)
    {
        return success(eduExerciseScoresService.selectEduExerciseScoresByScoreId(scoreId));
    }

    /**
     * 新增成绩表
     */
    @PreAuthorize("@ss.hasPermi('edu:scores:add')")
    @Log(title = "成绩表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduExerciseScores eduExerciseScores)
    {
        return toAjax(eduExerciseScoresService.insertEduExerciseScores(eduExerciseScores));
    }

    /**
     * 修改成绩表
     */
    @PreAuthorize("@ss.hasPermi('edu:scores:edit')")
    @Log(title = "成绩表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduExerciseScores eduExerciseScores)
    {
        return toAjax(eduExerciseScoresService.updateEduExerciseScores(eduExerciseScores));
    }

    /**
     * 删除成绩表
     */
    @PreAuthorize("@ss.hasPermi('edu:scores:remove')")
    @Log(title = "成绩表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scoreIds}")
    public AjaxResult remove(@PathVariable Long[] scoreIds)
    {
        return toAjax(eduExerciseScoresService.deleteEduExerciseScoresByScoreIds(scoreIds));
    }
}
