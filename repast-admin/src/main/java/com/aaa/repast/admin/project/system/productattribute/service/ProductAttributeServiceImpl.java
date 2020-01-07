package com.aaa.repast.admin.project.system.productattribute.service;

import com.aaa.repast.admin.project.system.productattribute.domain.ProductAttribute;
import com.aaa.repast.admin.project.system.productattribute.domain.ProductCategoryAttributeRelation;
import com.aaa.repast.admin.project.system.productattribute.mapper.ProductAttributeMapper;
import com.aaa.repast.admin.project.system.productattribute.mapper.ProductCategoryAttributeRelationMapper;
import com.aaa.repast.common.support.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性参数 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
@Service
public class ProductAttributeServiceImpl implements IProductAttributeService 
{
	@Autowired
	private ProductAttributeMapper productAttributeMapper;
	@Autowired
	private ProductCategoryAttributeRelationMapper productCategoryAttributeRelationMapper;
	/**
     * 查询商品属性参数信息
     * 
     * @param id 商品属性参数ID
     * @return 商品属性参数信息
     */
    @Override
	public ProductAttribute selectProductAttributeById(Long id)
	{
	    return productAttributeMapper.selectProductAttributeById(id);
	}
	
	/**
     * 查询商品属性参数列表
     * 
     * @param productAttribute 商品属性参数信息
     * @return 商品属性参数集合
     */
	@Override
	public List<ProductAttribute> selectProductAttributeList(ProductAttribute productAttribute)
	{
	    return productAttributeMapper.selectProductAttributeList(productAttribute);
	}
	
    /**
     * 新增商品属性参数
     * 
     * @param productAttribute 商品属性参数信息
     * @return 结果
     */
	@Override
	public int insertProductAttribute(ProductAttribute productAttribute)
	{
		int count = productAttributeMapper.insertProductAttribute(productAttribute);
		if (count>0){
			List<ProductAttribute> productAttributeList = productAttributeMapper.selectProductAttributeList(productAttribute);
			ProductAttribute productAttribute1 = productAttributeList.get(0);
			ProductCategoryAttributeRelation productCategoryAttributeRelation = new ProductCategoryAttributeRelation();
			productCategoryAttributeRelation.setShopId(productAttribute1.getShopId());
			productCategoryAttributeRelation.setProductAttributeId(productAttribute1.getId());
			productCategoryAttributeRelation.setProductCategoryId(productAttribute1.getProductAttributeCategoryId());
			productCategoryAttributeRelationMapper.insertProductCategoryAttributeRelation(productCategoryAttributeRelation);
		}

	    return count;
	}
	
	/**
     * 修改商品属性参数
     * 
     * @param productAttribute 商品属性参数信息
     * @return 结果
     */
	@Override
	public int updateProductAttribute(ProductAttribute productAttribute)
	{
	    return productAttributeMapper.updateProductAttribute(productAttribute);
	}

	/**
     * 删除商品属性参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductAttributeByIds(String ids)
	{
		return productAttributeMapper.deleteProductAttributeByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ProductAttribute> selectAttributeList(Long type, Long attributeId) {
		return productAttributeMapper.selectAttributeList( type,  attributeId);
	}



}
