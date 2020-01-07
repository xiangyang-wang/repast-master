package com.aaa.repast.admin.project.system.productattribute.service;


import com.aaa.repast.admin.project.system.productattribute.domain.ProductCategoryAttributeRelation;

import java.util.List;

/**
 * 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类） 服务层
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
public interface IProductCategoryAttributeRelationService 
{
	/**
     * 查询产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * 
     * @param id 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）ID
     * @return 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     */
	public ProductCategoryAttributeRelation selectProductCategoryAttributeRelationById(Long id);
	
	/**
     * 查询产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）列表
     * 
     * @param productCategoryAttributeRelation 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * @return 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）集合
     */
	public List<ProductCategoryAttributeRelation> selectProductCategoryAttributeRelationList(ProductCategoryAttributeRelation productCategoryAttributeRelation);
	
	/**
     * 新增产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）
     * 
     * @param productCategoryAttributeRelation 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * @return 结果
     */
	public int insertProductCategoryAttributeRelation(ProductCategoryAttributeRelation productCategoryAttributeRelation);
	
	/**
     * 修改产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）
     * 
     * @param productCategoryAttributeRelation 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * @return 结果
     */
	public int updateProductCategoryAttributeRelation(ProductCategoryAttributeRelation productCategoryAttributeRelation);
		
	/**
     * 删除产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductCategoryAttributeRelationByIds(String ids);
	
}
