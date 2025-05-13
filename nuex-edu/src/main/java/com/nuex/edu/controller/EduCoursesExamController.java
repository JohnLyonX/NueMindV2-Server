package com.nuex.edu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.nuex.edu.domain.EduCourses;
import com.nuex.edu.domain.EduCoursesChapter;
import com.nuex.edu.service.IEduCoursesChapterService;
import com.nuex.edu.service.IEduCoursesService;
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
import com.nuex.edu.domain.EduCoursesExam;
import com.nuex.edu.service.IEduCoursesExamService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 课程考试Controller
 *
 * @author john
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/edu/coursesExam")
public class EduCoursesExamController extends BaseController {
    @Autowired
    private IEduCoursesExamService eduCoursesExamService;

    @Autowired
    private IEduCoursesService eduCoursesService;

    @Autowired
    private IEduCoursesChapterService eduCoursesChapterService;


    /**
     * 查询课程考试列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesExam:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduCoursesExam eduCoursesExam) {
        startPage();
        List<EduCoursesExam> list = eduCoursesExamService.selectEduCoursesExamList(eduCoursesExam);
        list.forEach(item -> {
            Long coursesId = item.getCoursesId();
            Long coursesChapterId = item.getCoursesChapterId();
            EduCourses eduCourses = eduCoursesService.selectEduCoursesById(coursesId);
            EduCoursesChapter eduCoursesChapter = eduCoursesChapterService.selectEduCoursesChapterById(coursesChapterId);
            if (eduCourses != null) {
                item.setCoursesName(eduCourses.getName());
            }
            if (eduCoursesChapter != null) {
                item.setCoursesChapterName(eduCoursesChapter.getTitle());
            }

        });
        return getDataTable(list);
    }

    /**
     * 导出课程考试列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesExam:export')")
    @Log(title = "课程考试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduCoursesExam eduCoursesExam) {
        List<EduCoursesExam> list = eduCoursesExamService.selectEduCoursesExamList(eduCoursesExam);
        ExcelUtil<EduCoursesExam> util = new ExcelUtil<EduCoursesExam>(EduCoursesExam.class);
        util.exportExcel(response, list, "课程考试数据");
    }

    /**
     * 获取课程考试详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesExam:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        EduCoursesExam eduCoursesExam = eduCoursesExamService.selectEduCoursesExamById(id);
        Long coursesId = eduCoursesExam.getCoursesId();
        Long coursesChapterId = eduCoursesExam.getCoursesChapterId();
        EduCourses eduCourses = eduCoursesService.selectEduCoursesById(coursesId);
        EduCoursesChapter eduCoursesChapter = eduCoursesChapterService.selectEduCoursesChapterById(coursesChapterId);
        if (eduCourses != null) {
            eduCoursesExam.setCoursesName(eduCourses.getName());
        }
        if (eduCoursesChapter != null) {
            eduCoursesExam.setCoursesChapterName(eduCoursesChapter.getTitle());
        }
        return success(eduCoursesExam);
    }

    /**
     * 新增课程考试
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesExam:add')")
    @Log(title = "课程考试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduCoursesExam eduCoursesExam) {
        return toAjax(eduCoursesExamService.insertEduCoursesExam(eduCoursesExam));
    }

    /**
     * 修改课程考试
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesExam:edit')")
    @Log(title = "课程考试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduCoursesExam eduCoursesExam) {
        return toAjax(eduCoursesExamService.updateEduCoursesExam(eduCoursesExam));
    }

    /**
     * 删除课程考试
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesExam:remove')")
    @Log(title = "课程考试", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(eduCoursesExamService.deleteEduCoursesExamByIds(ids));
    }
}
