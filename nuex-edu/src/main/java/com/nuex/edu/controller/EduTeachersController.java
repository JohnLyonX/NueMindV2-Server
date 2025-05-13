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
import com.nuex.edu.domain.EduTeachers;
import com.nuex.edu.service.IEduTeachersService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 教师Controller
 *
 * @author john
 * @date 2025-04-02
 */
@RestController
@RequestMapping("/edu/teachers")
public class EduTeachersController extends BaseController
{
    @Autowired
    private IEduTeachersService eduTeachersService;

    /**
     * 查询教师列表
     */
    @PreAuthorize("@ss.hasPermi('edu:teachers:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduTeachers eduTeachers)
    {
        startPage();
        List<EduTeachers> list = eduTeachersService.selectEduTeachersList(eduTeachers);
        return getDataTable(list);
    }

    /**
     * 导出教师列表
     */
    @PreAuthorize("@ss.hasPermi('edu:teachers:export')")
    @Log(title = "教师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduTeachers eduTeachers)
    {
        List<EduTeachers> list = eduTeachersService.selectEduTeachersList(eduTeachers);
        ExcelUtil<EduTeachers> util = new ExcelUtil<EduTeachers>(EduTeachers.class);
        util.exportExcel(response, list, "教师数据");
    }

    /**
     * 获取教师详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:teachers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eduTeachersService.selectEduTeachersById(id));
    }

    /**
     * 新增教师
     */
    @PreAuthorize("@ss.hasPermi('edu:teachers:add')")
    @Log(title = "教师", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduTeachers eduTeachers)
    {
        return toAjax(eduTeachersService.insertEduTeachers(eduTeachers));
    }

    /**
     * 修改教师
     */
    @PreAuthorize("@ss.hasPermi('edu:teachers:edit')")
    @Log(title = "教师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduTeachers eduTeachers)
    {
        return toAjax(eduTeachersService.updateEduTeachers(eduTeachers));
    }

    /**
     * 删除教师
     */
    @PreAuthorize("@ss.hasPermi('edu:teachers:remove')")
    @Log(title = "教师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduTeachersService.deleteEduTeachersByIds(ids));
    }
}
