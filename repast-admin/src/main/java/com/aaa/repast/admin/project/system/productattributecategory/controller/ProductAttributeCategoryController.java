package com.aaa.repast.admin.project.system.productattributecategory.controller;

import java.util.List;
import com.aaa.repast.admin.framework.aspectj.lang.annotation.Log;
import com.aaa.repast.admin.framework.aspectj.lang.enums.BusinessType;
import com.aaa.repast.admin.framework.poi.ExcelUtil;
import com.aaa.repast.admin.framework.web.controller.BaseController;
import com.aaa.repast.admin.framework.web.domain.AjaxResult;
import com.aaa.repast.admin.framework.web.page.TableDataInfo;
import com.aaa.repast.admin.project.system.productattribute.domain.ProductAttribute;
import com.aaa.repast.admin.project.system.productattribute.service.IProductAttributeService;
import com.aaa.repast.admin.project.system.productattributecategory.domain.ProductAttributeCategory;
import com.aaa.repast.admin.project.system.productattributecategory.service.IProductAttributeCategoryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 产品属性分类 信息操作处理
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
@Controller
@RequestMapping("/system/productAttributeCategory")
public class ProductAttributeCategoryController extends BaseController
{
    private String prefix = "system/productAttributeCategory";
	@Autowired
	private IProductAttributeService productAttributeService;
	@Autowired
	private IProductAttributeCategoryService productAttributeCategoryService;
	
	@RequiresPermissions("system:productAttributeCategory:view")
	@GetMapping()
	public String productAttributeCategory()
	{
	    return prefix + "/productAttributeCategory";
	}
	
	/**
	 * 查询产品属性分类列表
	 */
	@RequiresPermissions("system:productAttributeCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProductAttributeCategory productAttributeCategory)
	{
		startPage();
        List<ProductAttributeCategory> list = productAttributeCategoryService.selectProductAttributeCategoryList(productAttributeCategory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出产品属性分类列表
	 */
	@RequiresPermissions("system:productAttributeCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ProductAttributeCategory productAttributeCategory)
    {
    	List<ProductAttributeCategory> list = productAttributeCategoryService.selectProductAttributeCategoryList(productAttributeCategory);
        ExcelUtil<ProductAttributeCategory> util = new ExcelUtil<ProductAttributeCategory>(ProductAttributeCategory.class);
        return util.exportExcel(list, "productAttributeCategory");
    }
	
	/**
	 * 新增产品属性分类
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存产品属性分类
	 */
	@RequiresPermissions("system:productAttributeCategory:add")
	@Log(title = "产品属性分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProductAttributeCategory productAttributeCategory)
	{		
		return toAjax(productAttributeCategoryService.insertProductAttributeCategory(productAttributeCategory));
	}

	/**
	 * 修改产品属性分类
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		ProductAttributeCategory productAttributeCategory = productAttributeCategoryService.selectProductAttributeCategoryById(id);
		mmap.put("productAttributeCategory", productAttributeCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存产品属性分类
	 */
	@RequiresPermissions("system:productAttributeCategory:edit")
	@Log(title = "产品属性分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProductAttributeCategory productAttributeCategory)
	{		
		return toAjax(productAttributeCategoryService.updateProductAttributeCategory(productAttributeCategory));
	}
	
	/**
	 * 删除产品属性分类
	 */
	@RequiresPermissions("system:productAttributeCategory:remove")
	@Log(title = "产品属性分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(productAttributeCategoryService.deleteProductAttributeCategoryByIds(ids));
	}
	/**
	 * 查询商品参数列表
	 */

	@GetMapping("/attributeList")
	@ResponseBody
	public TableDataInfo attributeList(Long  type,Long  attributeId)
	{
		startPage();
		List<ProductAttribute> productAttributeList = productAttributeService.selectAttributeList(type,attributeId);
		return getDataTable(productAttributeList);
	}
	/**
	 * 查询产品属性分类列表
	 */
	@GetMapping("/listAttr")
	@ResponseBody
	public List<ProductAttributeCategory> listAttr(ProductAttributeCategory productAttributeCategory)
	{

		List<ProductAttributeCategory> list = productAttributeCategoryService.selectProductAttributeCategoryList(productAttributeCategory);
		return list;
	}
	@GetMapping("/categoryList")
	@ResponseBody
	public List<ProductAttributeCategory> categoryList(ProductAttributeCategory productAttributeCategory)
	{

		List<ProductAttributeCategory> list = productAttributeCategoryService.selectProductAttributeCategoryList(productAttributeCategory);
		return list;
	}

}
