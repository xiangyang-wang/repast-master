package com.aaa.repast.admin.project.tool.ftp;

import java.util.Random;

/**
 * 文件生成新名字工具类
 * @author pc
 */
public class FileNewNameUtil {

    public static String fileName(Long id ){
        // 1.获取当前系统时间的毫秒数
        long currentTimeMillis = System.currentTimeMillis();
        // 2.创建随机数对象
        Random random = new Random();
        // 3.生成随机数(在0-999之间进行随机)
        int randomNum = random.nextInt(999);
        // 4.开始格式化
        // %:占位符  d:数字  03:如果不够三位，自动向前补0
        String format = String.format("%03d", randomNum);
        // 5.生成新的文件名
        String fileName = id + currentTimeMillis + format;
        // 6.返回文件的名称
        return fileName;

    }
}
