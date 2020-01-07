package com.aaa.repast.admin.project.system.productattribute.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

/**
 * 产品的分类和属性的关系，用于设置分类筛选条件（只支持一级分类）表 pms_product_category_attribute_relation
 * 
 * @author Seven Lee
 * @date 2020-01-03
 */
public class ProductCategoryAttributeRelation extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private Long shopId;
	/**  */
	private Long productCategoryId;
	/**  */
	private Long productAttributeId;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setShopId(Long shopId) 
	{
		this.shopId = shopId;
	}

	public Long getShopId() 
	{
		return shopId;
	}
	public void setProductCategoryId(Long productCategoryId) 
	{
		this.productCategoryId = productCategoryId;
	}

	public Long getProductCategoryId() 
	{
		return productCategoryId;
	}
	public void setProductAttributeId(Long productAttributeId) 
	{
		this.productAttributeId = productAttributeId;
	}

	public Long getProductAttributeId() 
	{
		return productAttributeId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("productCategoryId", getProductCategoryId())
            .append("productAttributeId", getProductAttributeId())
            .toString();
    }
}
