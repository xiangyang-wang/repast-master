package com.aaa.repast.admin.project.system.productattributecategory.service;

import com.aaa.repast.admin.project.system.productattributecategory.domain.ProductAttributeCategory;
import com.aaa.repast.admin.project.system.productattributecategory.mapper.ProductAttributeCategoryMapper;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品属性分类 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
@Service
public class ProductAttributeCategoryServiceImpl implements IProductAttributeCategoryService 
{
	@Autowired
	private ProductAttributeCategoryMapper productAttributeCategoryMapper;

	/**
     * 查询产品属性分类信息
     * 
     * @param id 产品属性分类ID
     * @return 产品属性分类信息
     */
    @Override
	public ProductAttributeCategory selectProductAttributeCategoryById(Long id)
	{
	    return productAttributeCategoryMapper.selectProductAttributeCategoryById(id);
	}
	
	/**
     * 查询产品属性分类列表
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 产品属性分类集合
     */
	@Override
	public List<ProductAttributeCategory> selectProductAttributeCategoryList(ProductAttributeCategory productAttributeCategory)
	{
	    return productAttributeCategoryMapper.selectProductAttributeCategoryList(productAttributeCategory);
	}
	
    /**
     * 新增产品属性分类
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 结果
     */
	@Override
	public int insertProductAttributeCategory(ProductAttributeCategory productAttributeCategory)
	{
	    return productAttributeCategoryMapper.insertProductAttributeCategory(productAttributeCategory);
	}
	
	/**
     * 修改产品属性分类
     * 
     * @param productAttributeCategory 产品属性分类信息
     * @return 结果
     */
	@Override
	public int updateProductAttributeCategory(ProductAttributeCategory productAttributeCategory)
	{
	    return productAttributeCategoryMapper.updateProductAttributeCategory(productAttributeCategory);
	}

	/**
     * 删除产品属性分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductAttributeCategoryByIds(String ids)
	{
		return productAttributeCategoryMapper.deleteProductAttributeCategoryByIds(Convert.toStrArray(ids));
	}
	
}
