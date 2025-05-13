package com.nuex.edu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.nuex.edu.domain.EduCourses;
import com.nuex.edu.domain.EduCoursesChapter;
import com.nuex.edu.domain.EduStudent;
import com.nuex.edu.service.IEduCoursesChapterService;
import com.nuex.edu.service.IEduCoursesService;
import com.nuex.edu.service.IEduStudentService;
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
import com.nuex.edu.domain.EduExamFilelib;
import com.nuex.edu.service.IEduExamFilelibService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 考试试卷提交与修改Controller
 *
 * @author john
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/edu/examFilelib")
public class EduExamFilelibController extends BaseController {
    @Autowired
    private IEduExamFilelibService eduExamFilelibService;

    @Autowired
    private IEduStudentService studentService;

    @Autowired
    private IEduCoursesService coursesService;

    @Autowired
    private IEduCoursesChapterService eduCoursesChapterService;


    /**
     * 查询考试试卷提交与修改列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:examFilelib:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduExamFilelib eduExamFilelib) {
        startPage();
        List<EduExamFilelib> list = eduExamFilelibService.selectEduExamFilelibList(eduExamFilelib);
        list.forEach(item -> {
            EduCourses eduCourses = coursesService.selectEduCoursesById(item.getCoursesId());
            if (eduCourses != null) {
                item.setCoursesName(eduCourses.getName());
            }
            EduCoursesChapter eduCoursesChapter = eduCoursesChapterService.selectEduCoursesChapterById(item.getCourseChapterId());
            if (eduCoursesChapter != null) {
                item.setCoursesChapter(eduCoursesChapter.getTitle());
                ;
            }
            EduStudent eduStudent = studentService.selectEduStudentById(item.getStudentId());
            if (eduStudent != null) {
                item.setName(eduStudent.getName());
            }

        });
        return getDataTable(list);
    }

    /**
     * 导出考试试卷提交与修改列表
     */
    @PreAuthorize("@ss.hasPermi('edu:examFilelib:export')")
    @Log(title = "考试试卷提交与修改", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduExamFilelib eduExamFilelib) {
        List<EduExamFilelib> list = eduExamFilelibService.selectEduExamFilelibList(eduExamFilelib);
        ExcelUtil<EduExamFilelib> util = new ExcelUtil<EduExamFilelib>(EduExamFilelib.class);
        util.exportExcel(response, list, "考试试卷提交与修改数据");
    }

    /**
     * 获取考试试卷提交与修改详细信息
     */
//    @PreAuthorize("@ss.hasPermi('edu:examFilelib:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        EduExamFilelib eduExamFilelib = eduExamFilelibService.selectEduExamFilelibById(id);
        EduCourses eduCourses = coursesService.selectEduCoursesById(eduExamFilelib.getCoursesId());
        if (eduCourses != null) {
            eduExamFilelib.setCoursesName(eduCourses.getName());
        }
        EduCoursesChapter eduCoursesChapter = eduCoursesChapterService.selectEduCoursesChapterById(eduExamFilelib.getCourseChapterId());
        if (eduCoursesChapter != null) {
            eduExamFilelib.setCoursesChapter(eduCoursesChapter.getTitle());
            ;
        }
        EduStudent eduStudent = studentService.selectEduStudentById(eduExamFilelib.getStudentId());
        if (eduStudent != null) {
            eduExamFilelib.setName(eduStudent.getName());
        }

        return success(eduExamFilelib);
    }

    /**
     * 新增考试试卷提交与修改
     */
//    @PreAuthorize("@ss.hasPermi('edu:examFilelib:add')")
    @Log(title = "考试试卷提交与修改", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduExamFilelib eduExamFilelib) {

        return toAjax(eduExamFilelibService.insertEduExamFilelib(eduExamFilelib));
    }

    /**
     * 修改考试试卷提交与修改
     */
//    @PreAuthorize("@ss.hasPermi('edu:examFilelib:edit')")
    @Log(title = "考试试卷提交与修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduExamFilelib eduExamFilelib) {
        return toAjax(eduExamFilelibService.updateEduExamFilelib(eduExamFilelib));
    }

    /**
     * 删除考试试卷提交与修改
     */
    @PreAuthorize("@ss.hasPermi('edu:examFilelib:remove')")
    @Log(title = "考试试卷提交与修改", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(eduExamFilelibService.deleteEduExamFilelibByIds(ids));
    }
}
