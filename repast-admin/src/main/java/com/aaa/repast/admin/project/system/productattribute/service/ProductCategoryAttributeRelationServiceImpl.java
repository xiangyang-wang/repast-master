package com.aaa.repast.admin.project.system.productattribute.service;

import com.aaa.repast.admin.project.system.productattribute.domain.ProductCategoryAttributeRelation;
import com.aaa.repast.admin.project.system.productattribute.mapper.ProductCategoryAttributeRelationMapper;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类） 服务层实现
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
@Service
public class ProductCategoryAttributeRelationServiceImpl implements IProductCategoryAttributeRelationService 
{
	@Autowired
	private ProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;

	/**
     * 查询产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * 
     * @param id 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）ID
     * @return 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     */
    @Override
	public ProductCategoryAttributeRelation selectProductCategoryAttributeRelationById(Long id)
	{
	    return productCategoryAttributeRelationMapper.selectProductCategoryAttributeRelationById(id);
	}
	
	/**
     * 查询产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）列表
     * 
     * @param productCategoryAttributeRelation 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * @return 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）集合
     */
	@Override
	public List<ProductCategoryAttributeRelation> selectProductCategoryAttributeRelationList(ProductCategoryAttributeRelation productCategoryAttributeRelation)
	{
	    return productCategoryAttributeRelationMapper.selectProductCategoryAttributeRelationList(productCategoryAttributeRelation);
	}
	
    /**
     * 新增产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）
     * 
     * @param productCategoryAttributeRelation 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * @return 结果
     */
	@Override
	public int insertProductCategoryAttributeRelation(ProductCategoryAttributeRelation productCategoryAttributeRelation)
	{
	    return productCategoryAttributeRelationMapper.insertProductCategoryAttributeRelation(productCategoryAttributeRelation);
	}
	
	/**
     * 修改产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）
     * 
     * @param productCategoryAttributeRelation 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）信息
     * @return 结果
     */
	@Override
	public int updateProductCategoryAttributeRelation(ProductCategoryAttributeRelation productCategoryAttributeRelation)
	{
	    return productCategoryAttributeRelationMapper.updateProductCategoryAttributeRelation(productCategoryAttributeRelation);
	}

	/**
     * 删除产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductCategoryAttributeRelationByIds(String ids)
	{
		return productCategoryAttributeRelationMapper.deleteProductCategoryAttributeRelationByIds(Convert.toStrArray(ids));
	}
	
}
