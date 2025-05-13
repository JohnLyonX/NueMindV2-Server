package com.nuex.edu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.nuex.edu.domain.EduCoursesChapter;
import com.nuex.edu.domain.EduCoursesDetails;
import com.nuex.edu.service.IEduCoursesChapterService;
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
import com.nuex.edu.domain.EduCourses;
import com.nuex.edu.service.IEduCoursesService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 课程Controller
 *
 * @author john
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/edu/courses")
public class EduCoursesController extends BaseController
{
    @Autowired
    private IEduCoursesService eduCoursesService;

     @Autowired
    private IEduCoursesChapterService eduCoursesChapterService;

    /**
     * 查询课程列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:courses:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduCourses eduCourses)
    {
        startPage();
        List<EduCourses> list = eduCoursesService.selectEduCoursesList(eduCourses);
        return getDataTable(list);
    }

    /**
     * 导出课程列表
     */
    @PreAuthorize("@ss.hasPermi('edu:courses:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduCourses eduCourses)
    {
        List<EduCourses> list = eduCoursesService.selectEduCoursesList(eduCourses);
        ExcelUtil<EduCourses> util = new ExcelUtil<EduCourses>(EduCourses.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
//    @PreAuthorize("@ss.hasPermi('edu:courses:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        EduCourses eduCourses = eduCoursesService.selectEduCoursesById(id);
        List<EduCoursesDetails> eduCoursesDetailsList = eduCourses.getEduCoursesDetailsList();
        eduCoursesDetailsList.forEach(eduCoursesDetails -> {
            Long coursesChapterId = eduCoursesDetails.getCoursesChapterId();
            EduCoursesChapter eduCoursesChapter = eduCoursesChapterService.selectEduCoursesChapterById(coursesChapterId);
            if (eduCoursesChapter != null) {
                eduCoursesDetails.setCoursesChapterName(eduCoursesChapter.getTitle());
            }
        });

        return success(eduCourses);
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('edu:courses:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduCourses eduCourses)
    {
        return toAjax(eduCoursesService.insertEduCourses(eduCourses));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('edu:courses:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduCourses eduCourses)
    {
        return toAjax(eduCoursesService.updateEduCourses(eduCourses));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('edu:courses:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduCoursesService.deleteEduCoursesByIds(ids));
    }
}
