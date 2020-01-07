package com.aaa.repast.admin.project.system.product.service;

import com.aaa.repast.admin.project.tool.ftp.FileNewNameUtil;
import com.aaa.repast.admin.project.tool.ftp.FtpProperties;
import com.aaa.repast.admin.project.tool.ftp.FtpUtil;
import com.aaa.repast.common.support.Convert;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import com.aaa.repast.admin.project.system.product.mapper.ProductMapper;
import com.aaa.repast.admin.project.system.product.domain.Product;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品 服务层实现
 * 
 * @author Seven Lee
 * @date 2019-12-27
 */
@Service
public class ProductServiceImpl implements IProductService 
{
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private FtpProperties ftpProperties;
	/**
     * 查询商品信息
     * 
     * @param id 商品ID
     * @return 商品信息
     */
    @Override
	public Product selectProductById(Long id)
	{
	    return productMapper.selectProductById(id);
	}
	
	/**
     * 查询商品列表
     * 
     * @param product 商品信息
     * @return 商品集合
     */
	@Override
	public List<Product> selectProductList(Product product)
	{
	    return productMapper.selectProductList(product);
	}
	
    /**
     * 新增商品
     * 
     * @param product 商品信息
     * @return 结果
     */
	@Override
	public int insertProduct(MultipartFile multipartFile, Product product)
	{
		try {
			//获取文件名
			String oldName = multipartFile.getOriginalFilename();

			//获取文件新的名字
			String newName = FileNewNameUtil.fileName(product.getShopId());
			newName = newName+oldName.substring(oldName.indexOf("."));
			//得到当前时间
			// 5.获取文件的路径(2019/11/13)
			String filePath = new DateTime().toString("yyyy/MM/dd");

			boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername()
					, ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, multipartFile.getInputStream());
			if (ifSuccess){
				filePath=ftpProperties.getHttpPath()+"/"+filePath +"/"+ newName;
				product.setPic(filePath);

				return productMapper.insertProduct(product);


			}
		} catch (IOException e) {
			e.printStackTrace();

		}

		return 0;
	}
	
	/**
     * 修改商品
     * 
     * @param product 商品信息
     * @return 结果
     */
	@Override
	public int updateProduct(Product product)
	{
	    return productMapper.updateProduct(product);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProductByIds(String ids)
	{
		return productMapper.deleteProductByIds(Convert.toStrArray(ids));
	}
	
}
