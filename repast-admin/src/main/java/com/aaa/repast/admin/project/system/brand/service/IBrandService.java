package com.aaa.repast.admin.project.system.brand.service;

import com.aaa.repast.admin.project.system.brand.domain.Brand;
import com.aaa.repast.admin.project.system.brand.Vo.BrandManagementVo;
import org.springframework.web.multipart.MultipartFile;

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
	public int insertBrand(MultipartFile[] file,Brand brand);
	
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


	/**
	 * @author WangShaodong
	 * @description
	 * 		单条删除方法
	 * @date 2020/1/2
	 */
	/*public int deleteBrandById(Long id);*/


	/**
	 * @author WangShaodong
	 * @description
	 * 		查询品牌列表
	 * @date 2019/12/30
	 */
	public List<BrandManagementVo> selectBrandAll(BrandManagementVo brandManagementVo);


	/**
	 * @author WangShaodong
	 * @description
	 * 		修改是否显示状态
	 * @date 2020/1/6
	 */
	public int showStatus(Long id,Integer show_status);


	/**
	 * @author WangShaodong
	 * @description
	 * 		是否为品牌制造商
	 * @date 2020/1/6
	 */
	public int factoryStatus (Long id, Integer factory_status);










	/**
	 * @author WangShaodong
	 * @description
	 * 		图片上传
	 * @date 2020/1/3
	 */
//	public List<Map<String, Object>> addUpLoadAjax(MultipartFile[] file,BrandManagementVo brandManagementVo);

	
}
