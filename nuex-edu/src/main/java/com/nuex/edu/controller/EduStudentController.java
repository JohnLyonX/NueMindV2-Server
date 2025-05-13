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
import com.nuex.edu.domain.EduStudent;
import com.nuex.edu.service.IEduStudentService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 学生基本信息Controller
 *
 * @author john
 * @date 2025-04-09
 */
@RestController
@RequestMapping("/edu/student")
public class EduStudentController extends BaseController
{
    @Autowired
    private IEduStudentService eduStudentService;

    /**
     * 查询学生基本信息列表
     */
//    @PreAuthorize("@ss.hasPermi('edu:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduStudent eduStudent)
    {
        startPage();
        List<EduStudent> list = eduStudentService.selectEduStudentList(eduStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('edu:student:export')")
    @Log(title = "学生基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduStudent eduStudent)
    {
        List<EduStudent> list = eduStudentService.selectEduStudentList(eduStudent);
        ExcelUtil<EduStudent> util = new ExcelUtil<EduStudent>(EduStudent.class);
        util.exportExcel(response, list, "学生基本信息数据");
    }

    /**
     * 获取学生基本信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('edu:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eduStudentService.selectEduStudentById(id));
    }

    /**
     * 新增学生基本信息
     */
    @PreAuthorize("@ss.hasPermi('edu:student:add')")
    @Log(title = "学生基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduStudent eduStudent)
    {
        return toAjax(eduStudentService.insertEduStudent(eduStudent));
    }

    /**
     * 修改学生基本信息
     */
    @PreAuthorize("@ss.hasPermi('edu:student:edit')")
    @Log(title = "学生基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduStudent eduStudent)
    {
        return toAjax(eduStudentService.updateEduStudent(eduStudent));
    }

    /**
     * 删除学生基本信息
     */
    @PreAuthorize("@ss.hasPermi('edu:student:remove')")
    @Log(title = "学生基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduStudentService.deleteEduStudentByIds(ids));
    }
}
