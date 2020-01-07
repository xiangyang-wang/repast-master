package com.aaa.repast.admin.project.system.productattributecategory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.aaa.repast.admin.framework.web.domain.BaseEntity;

/**
 * 产品属性分类表 pms_product_attribute_category
 * 
 * @author Seven Lee
 * @date 2019-12-30
 */
public class ProductAttributeCategory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/**  */
	private Long shopId;
	/**  */
	private String name;
	/** 属性数量 */
	private Integer attributeCount;
	/** 参数数量 */
	private Integer paramCount;

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
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setAttributeCount(Integer attributeCount) 
	{
		this.attributeCount = attributeCount;
	}

	public Integer getAttributeCount() 
	{
		return attributeCount;
	}
	public void setParamCount(Integer paramCount) 
	{
		this.paramCount = paramCount;
	}

	public Integer getParamCount() 
	{
		return paramCount;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("name", getName())
            .append("attributeCount", getAttributeCount())
            .append("paramCount", getParamCount())
            .toString();
    }
}
