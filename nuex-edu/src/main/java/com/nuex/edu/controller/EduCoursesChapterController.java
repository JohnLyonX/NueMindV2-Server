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
import com.nuex.edu.domain.EduCoursesChapter;
import com.nuex.edu.service.IEduCoursesChapterService;
import com.nuex.common.utils.poi.ExcelUtil;

/**
 * 课程章节信息Controller
 *
 * @author john
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/edu/coursesChapter")
public class EduCoursesChapterController extends BaseController
{
    @Autowired
    private IEduCoursesChapterService eduCoursesChapterService;

    /**
     * 查询课程章节信息列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesChapter:list')")
    @GetMapping("/list")
    public AjaxResult list(EduCoursesChapter eduCoursesChapter)
    {
        List<EduCoursesChapter> list = eduCoursesChapterService.selectEduCoursesChapterList(eduCoursesChapter);
        return success(list);
    }

    /**
     * 导出课程章节信息列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesChapter:export')")
    @Log(title = "课程章节信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduCoursesChapter eduCoursesChapter)
    {
        List<EduCoursesChapter> list = eduCoursesChapterService.selectEduCoursesChapterList(eduCoursesChapter);
        ExcelUtil<EduCoursesChapter> util = new ExcelUtil<EduCoursesChapter>(EduCoursesChapter.class);
        util.exportExcel(response, list, "课程章节信息数据");
    }

    /**
     * 获取课程章节信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesChapter:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eduCoursesChapterService.selectEduCoursesChapterById(id));
    }

    /**
     * 新增课程章节信息
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesChapter:add')")
    @Log(title = "课程章节信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduCoursesChapter eduCoursesChapter)
    {
        return toAjax(eduCoursesChapterService.insertEduCoursesChapter(eduCoursesChapter));
    }

    /**
     * 修改课程章节信息
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesChapter:edit')")
    @Log(title = "课程章节信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduCoursesChapter eduCoursesChapter)
    {
        return toAjax(eduCoursesChapterService.updateEduCoursesChapter(eduCoursesChapter));
    }

    /**
     * 删除课程章节信息
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesChapter:remove')")
    @Log(title = "课程章节信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduCoursesChapterService.deleteEduCoursesChapterByIds(ids));
    }
}
