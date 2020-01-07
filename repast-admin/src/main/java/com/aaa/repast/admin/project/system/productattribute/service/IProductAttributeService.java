package com.aaa.repast.admin.project.system.productattribute.service;


import com.aaa.repast.admin.project.system.productattribute.domain.ProductAttribute;

import java.util.List;

/**
 * 商品属性参数 服务层
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
public interface IProductAttributeService 
{
	/**
     * 查询商品属性参数信息
     * 
     * @param id 商品属性参数ID
     * @return 商品属性参数信息
     */
	public ProductAttribute selectProductAttributeById(Long id);
	
	/**
     * 查询商品属性参数列表
     * 
     * @param productAttribute 商品属性参数信息
     * @return 商品属性参数集合
     */
	public List<ProductAttribute> selectProductAttributeList(ProductAttribute productAttribute);
	
	/**
     * 新增商品属性参数
     * 
     * @param productAttribute 商品属性参数信息
     * @return 结果
     */
	public int insertProductAttribute(ProductAttribute productAttribute);
	
	/**
     * 修改商品属性参数
     * 
     * @param productAttribute 商品属性参数信息
     * @return 结果
     */
	public int updateProductAttribute(ProductAttribute productAttribute);
		
	/**
     * 删除商品属性参数信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProductAttributeByIds(String ids);

	/**
	 * 查询商品属性列表
	 *
	 * @param
	 * @return 商品属性参数集合
	 */
	public List<ProductAttribute> selectAttributeList(Long type, Long attributeId);

}
