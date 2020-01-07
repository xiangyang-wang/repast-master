package com.aaa.repast.admin.project.system.brand.service;

import com.aaa.repast.admin.project.system.brand.domain.Brand;
import java.util.List;

/**
 * 品牌 服务层
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
public interface IBrandService 
{
	/**
     * 查询品牌信息
     * 
     * @param id 品牌ID
     * @return 品牌信息
     */
	public Brand selectBrandById(Long id);
	
	/**
     * 查询品牌列表
     * 
     * @param brand 品牌信息
     * @return 品牌集合
     */
	public List<Brand> selectBrandList(Brand brand);
	
	/**
     * 新增品牌
     * 
     * @param brand 品牌信息
     * @return 结果
     */
	public int insertBrand(Brand brand);
	
	/**
     * 修改品牌
     * 
     * @param brand 品牌信息
     * @return 结果
     */
	public int updateBrand(Brand brand);
		
	/**
     * 删除品牌信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBrandByIds(String ids);
	
}