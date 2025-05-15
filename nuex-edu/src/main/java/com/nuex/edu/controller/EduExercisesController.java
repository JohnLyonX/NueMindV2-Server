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
import com.nuex.edu.domain.EduExercises;
import com.nuex.edu.service.IEduExercisesService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 练习集合Controller
 *
 * @author hfsui1
 * @date 2025-05-14
 */
@RestController
@RequestMapping("/edu/exercises")
public class EduExercisesController extends BaseController
{
    @Autowired
    private IEduExercisesService eduExercisesService;

    /**
     * 查询练习集合列表
     */
    @PreAuthorize("@ss.hasPermi('edu:exercises:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduExercises eduExercises)
    {
        startPage();
        List<EduExercises> list = eduExercisesService.selectEduExercisesList(eduExercises);
        return getDataTable(list);
    }

    /**
     * 导出练习集合列表
     */
    @PreAuthorize("@ss.hasPermi('edu:exercises:export')")
    @Log(title = "练习集合", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduExercises eduExercises)
    {
        List<EduExercises> list = eduExercisesService.selectEduExercisesList(eduExercises);
        ExcelUtil<EduExercises> util = new ExcelUtil<EduExercises>(EduExercises.class);
        util.exportExcel(response, list, "练习集合数据");
    }

    /**
     * 获取练习集合详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:exercises:query')")
    @GetMapping(value = "/{exerciseId}")
    public AjaxResult getInfo(@PathVariable("exerciseId") Long exerciseId)
    {
        return success(eduExercisesService.selectEduExercisesByExerciseId(exerciseId));
    }

    /**
     * 新增练习集合
     */
    @PreAuthorize("@ss.hasPermi('edu:exercises:add')")
    @Log(title = "练习集合", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduExercises eduExercises)
    {
        return toAjax(eduExercisesService.insertEduExercises(eduExercises));
    }

    /**
     * 修改练习集合
     */
    @PreAuthorize("@ss.hasPermi('edu:exercises:edit')")
    @Log(title = "练习集合", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduExercises eduExercises)
    {
        return toAjax(eduExercisesService.updateEduExercises(eduExercises));
    }

    /**
     * 删除练习集合
     */
    @PreAuthorize("@ss.hasPermi('edu:exercises:remove')")
    @Log(title = "练习集合", businessType = BusinessType.DELETE)
	@DeleteMapping("/{exerciseIds}")
    public AjaxResult remove(@PathVariable Long[] exerciseIds)
    {
        return toAjax(eduExercisesService.deleteEduExercisesByExerciseIds(exerciseIds));
    }
}
