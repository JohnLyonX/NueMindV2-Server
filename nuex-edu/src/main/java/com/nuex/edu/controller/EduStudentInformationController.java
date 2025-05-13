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
import com.nuex.edu.domain.EduStudentInformation;
import com.nuex.edu.service.IEduStudentInformationService;
import com.nuex.common.utils.poi.ExcelUtil;
import com.nuex.common.core.page.TableDataInfo;

/**
 * 学生档案Controller
 *
 * @author john
 * @date 2025-04-02
 */
@RestController
@RequestMapping("/edu/studentInformation")
public class EduStudentInformationController extends BaseController
{
    @Autowired
    private IEduStudentInformationService eduStudentInformationService;

    /**
     * 查询学生档案列表
     */
    @PreAuthorize("@ss.hasPermi('edu:studentInformation:list')")
    @GetMapping("/list")
    public TableDataInfo list(EduStudentInformation eduStudentInformation)
    {
        startPage();
        List<EduStudentInformation> list = eduStudentInformationService.selectEduStudentInformationList(eduStudentInformation);
        return getDataTable(list);
    }

    /**
     * 导出学生档案列表
     */
    @PreAuthorize("@ss.hasPermi('edu:studentInformation:export')")
    @Log(title = "学生档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, EduStudentInformation eduStudentInformation)
    {
        List<EduStudentInformation> list = eduStudentInformationService.selectEduStudentInformationList(eduStudentInformation);
        ExcelUtil<EduStudentInformation> util = new ExcelUtil<EduStudentInformation>(EduStudentInformation.class);
        util.exportExcel(response, list, "学生档案数据");
    }

    /**
     * 获取学生档案详细信息
     */
    @PreAuthorize("@ss.hasPermi('edu:studentInformation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(eduStudentInformationService.selectEduStudentInformationById(id));
    }

    /**
     * 新增学生档案
     */
    @PreAuthorize("@ss.hasPermi('edu:studentInformation:add')")
    @Log(title = "学生档案", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EduStudentInformation eduStudentInformation)
    {
        return toAjax(eduStudentInformationService.insertEduStudentInformation(eduStudentInformation));
    }

    /**
     * 修改学生档案
     */
    @PreAuthorize("@ss.hasPermi('edu:studentInformation:edit')")
    @Log(title = "学生档案", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EduStudentInformation eduStudentInformation)
    {
        return toAjax(eduStudentInformationService.updateEduStudentInformation(eduStudentInformation));
    }

    /**
     * 删除学生档案
     */
    @PreAuthorize("@ss.hasPermi('edu:studentInformation:remove')")
    @Log(title = "学生档案", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eduStudentInformationService.deleteEduStudentInformationByIds(ids));
    }
}
