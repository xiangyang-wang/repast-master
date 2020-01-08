package com.aaa.repast.admin.project.system.brand.service;

import com.aaa.repast.admin.project.ftp.FileNameUtil;
import com.aaa.repast.admin.project.ftp.FtpProperties;
import com.aaa.repast.admin.project.ftp.FtpUtil;
import com.aaa.repast.admin.project.system.brand.Vo.BrandManagementVo;
import com.aaa.repast.common.support.Convert;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import com.aaa.repast.admin.project.system.brand.mapper.BrandMapper;
import com.aaa.repast.admin.project.system.brand.domain.Brand;
import org.springframework.web.multipart.MultipartFile;

/**
 * 品牌 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-28
 */
@Service
public class BrandServiceImpl implements IBrandService
{
	/*注入图片上传的配置类、组件*/
	@Autowired
	private FtpProperties ftpProperties;
	@Autowired
	private BrandMapper brandMapper;

	/**
     * 查询品牌信息
     * 
     * @param id 品牌ID
     * @return 品牌信息
     */
    @Override
	public Brand selectBrandById(Long id)
	{
	    return brandMapper.selectBrandById(id);
	}
	
	/**
     * 查询品牌列表
     * 
     * @param brand 品牌信息
     * @return 品牌集合
     */
	@Override
	public List<Brand> selectBrandList(Brand brand)
	{
	    return brandMapper.selectBrandList(brand);
	}
	
    /**
     * 新增品牌
     * 
     * @param brand 品牌信息
     * @return 结果
     */
	@Override
	public int insertBrand(MultipartFile[] files,Brand brand)
	{


		int i = 1;
		for (
				MultipartFile file : files) {
			String oldName = file.getOriginalFilename();
			if (null == oldName || ("").equals(oldName)) {

				i++;
				continue;
			}
			try {
				String newName = FileNameUtil.getFileName(Long.valueOf(brand.getSort()));
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				String filePath = new DateTime().toString("yyyy/MM/dd");

				boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
						ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
				if (ifSuccess) {
					String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
					if (i == 1) {
						brand.setLogo(headPic);
					} else if (i == 2) {
						brand.setBigPic(headPic);
					}
					i++;
				} else {
					return 0;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


	    return brandMapper.insertBrand(brand);
	}
	
	/**
     * 修改品牌
     * 
     * @param brand 品牌信息
     * @return 结果
     */
	@Override
	public int updateBrand(Brand brand)
	{
	    return brandMapper.updateBrand(brand);
	}

	/**
     * 删除品牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBrandByIds(String ids)
	{
		return brandMapper.deleteBrandByIds(Convert.toStrArray(ids));
	}



	/**
	 * @author WangShaodong
	 * @description
	 * 		删除单条语句
	 * @date 2020/1/2
	 */
	/*@Override
	public int deleteBrandById(Long id) {
		return brandMapper.deleteBrandById(id);
	}*/


	/**
	 * @author WangShaodong
	 * @description
	 * 		查询品牌列表
	 * @date 2019/12/30
	 */
	@Override
	public List<BrandManagementVo> selectBrandAll(BrandManagementVo brandManagementVo) {
		return brandMapper.selectBrandAll(brandManagementVo);
	}

	/**
	 * @author WangShaodong
	 * @description
	 * 		修改是否显示状态
	 * @date 2020/1/6
	 */
	@Override
	public int showStatus(Long id, Integer show_status) {
		if(show_status == 1){
			show_status = 0;
		}else if(show_status == 0) {
			show_status = 1;
		}
		return brandMapper.showStatus(id,show_status);
	}




	/**
	 * @author WangShaodong
	 * @description
	 * 		是否为品牌制造商
	 * @date 2020/1/6
	 */
	@Override
	public int factoryStatus (Long id, Integer factory_status){
		if(factory_status == 1){
			factory_status = 0;
		}else if(factory_status == 0){
			factory_status = 1;
		}
		return brandMapper.factoryStatus(id,factory_status);
	}





	/**
	 * @author WangShaodong
	 * @description
	 * 		图片上传
	 * @date 2020/1/3
	 */
	/*@Override
	public List<Map<String, Object>> addUpLoadAjax(MultipartFile[] file,BrandManagementVo brandManagementVo) {
		List<Map<String, Object>> list = new ArrayList<>();
		for(MultipartFile m : file){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			try {
				String oldName = m.getOriginalFilename();
				// 3.生成新的文件名(315678163781256812975498)
				String newName= FileNameUtil.getFileName(Long.valueOf(brandManagementVo.getId()));
				// 4.截取原始文件名的后缀,拼接到新的名称上--->获取新的文件名
				newName = newName + oldName.substring(oldName.lastIndexOf("."));
				// 5.获取文件的路径(2019/11/13)
				String filePath = new DateTime().toString("yyyy/MM/dd");
				// 6.调用上传文件的工具类
				boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(),
						ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, m.getInputStream());
				if(ifSuccess){
					//上传成功
					BrandManagementVo brandManagementVo1 = new BrandManagementVo();
					String headPic = ftpProperties.getHttpPath()+"/"+filePath+"/"+newName;
					brandManagementVo1.setLogo(headPic);
					Integer result =  brandMapper.ftpPathAdds(brandManagementVo);

					if(result>0){
						// 说明更新成功
						resultMap.put("code", "200");
						resultMap.put("msg", "上传成功！");
						resultMap.put("datas", headPic);
						list.add(resultMap);
					} else {
						resultMap.put("code", "500");
						resultMap.put("msg", "图片路径更新失败！");
						list.add(resultMap);
					}
				}else {
					resultMap.put("code", "500");
					resultMap.put("msg", "上传失败！");
					list.add(resultMap);
				}


			}catch (Exception e){
				resultMap.put("code", "500");
				resultMap.put("msg", "上传失败！");
				list.add(resultMap);
				e.printStackTrace();
			}

		}
		return list;
	}*/


}
