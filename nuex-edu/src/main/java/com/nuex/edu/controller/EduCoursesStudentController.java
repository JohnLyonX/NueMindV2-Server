package com.nuex.edu.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.nuex.edu.domain.EduCourses;
import com.nuex.edu.domain.EduCoursesStudentDetails;
import com.nuex.edu.domain.EduStudent;
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
import com.nuex.edu.domain.EduCoursesStudent;
import com.nuex.edu.service.IEduCoursesStudentService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 课堂管理Controller
 *
 * @author john
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/edu/coursesStudent")
public class EduCoursesStudentController extends BaseController
{
    @Autowired
    private IEduCoursesStudentService eduCoursesStudentService;

    @Autowired
    private IEduCoursesService coursesService;

    @Autowired
    private IEduStudentService studentService;

    /**
     * 查询课堂管理列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesStudent:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduCoursesStudent eduCoursesStudent)
    {
        startPage();
        List<EduCoursesStudent> list = eduCoursesStudentService.selectEduCoursesStudentList(eduCoursesStudent);
        list.forEach(item -> {
            Long coursesId = item.getCoursesId();
            EduCourses eduCourses = coursesService.selectEduCoursesById(coursesId);
            if (eduCourses != null) {
                item.setCourseName(eduCourses.getName());
            }
        });
        return getDataTable(list);
    }

    /**
     * 导出课堂管理列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:coursesStudent:export')")
    @Log(title = "课堂管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduCoursesStudent eduCoursesStudent)
    {
        List<EduCoursesStudent> list = eduCoursesStudentService.selectEduCoursesStudentList(eduCoursesStudent);
        ExcelUtil<EduCoursesStudent> util = new ExcelUtil<EduCoursesStudent>(EduCoursesStudent.class);
        util.exportExcel(response, list, "课堂管理数据");
    }

    /**
     * 获取课堂管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesStudent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        EduCoursesStudent eduCoursesStudent = eduCoursesStudentService.selectEduCoursesStudentById(id);
        Long coursesId = eduCoursesStudent.getCoursesId();
        EduCourses eduCourses = coursesService.selectEduCoursesById(coursesId);
        if (eduCourses != null) {
            eduCoursesStudent.setCourseName(eduCourses.getName());
        }
        List<EduCoursesStudentDetails> eduCoursesStudentDetailsList = eduCoursesStudent.getEduCoursesStudentDetailsList();
        eduCoursesStudentDetailsList.forEach(eduCoursesStudentDetails -> {
            Long studentId = eduCoursesStudentDetails.getStudentId();
            EduStudent eduStudent = studentService.selectEduStudentById(studentId);
            if (eduStudent != null) {
                eduCoursesStudentDetails.setStudentName(eduStudent.getName());
                eduCoursesStudentDetails.setStudentPhoneNumber(eduStudent.getPhoneNumber());
            }

        });
        return success(eduCoursesStudent);
    }

    /**
     * 新增课堂管理
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesStudent:add')")
    @Log(title = "课堂管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduCoursesStudent eduCoursesStudent)
    {
        return toAjax(eduCoursesStudentService.insertEduCoursesStudent(eduCoursesStudent));
    }

    /**
     * 修改课堂管理
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesStudent:edit')")
    @Log(title = "课堂管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduCoursesStudent eduCoursesStudent)
    {
        return toAjax(eduCoursesStudentService.updateEduCoursesStudent(eduCoursesStudent));
    }

    /**
     * 删除课堂管理
     */
    @PreAuthorize("@ss.hasPermi('edu:coursesStudent:remove')")
    @Log(title = "课堂管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduCoursesStudentService.deleteEduCoursesStudentByIds(ids));
    }
}
