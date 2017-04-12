package org.jiang.COC.common;




import java.io.File;

import java.io.FileOutputStream;

import org.jiang.COC.common.PropertiesUtil;
import org.springframework.web.multipart.MultipartFile;



/**
 * 文件上传工具类
 * @author 
 *
 */
public class UploadUtil {
	
	public static String uploadFile(MultipartFile file, String realPath) {
		String result = null;
		if (file.isEmpty()) {
			
			return result;
		}
		String fileName = file.getOriginalFilename();//获得文件的名字
		//重新命名，确保唯一性
		fileName = Long.toString(System.currentTimeMillis())+ StringUtil.getRandom(8) + fileName.substring(fileName.lastIndexOf('.'),fileName.length());
		//设置存储路径；读取配置的总的绝对路径+此目录下创建的文件夹路径
		String path = PropertiesUtil.getProperties("uploadPath") + "/"+ realPath + "/";
		File folder = new File(path);//获得好路径后，需要照着去新建文件夹
		if (!folder.exists()) {
			folder.mkdir();//如果不存在就新建
		}
			try {
				FileOutputStream outputStream = new FileOutputStream(path+fileName);//获得输出流对象
				outputStream.write(file.getBytes());//保存file的字节数据
				outputStream.close();//关闭输出流
				result = realPath + "/" + fileName;
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		
	}
}