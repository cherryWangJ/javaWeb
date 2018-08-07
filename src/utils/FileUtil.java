package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUtil {
	
	/**
	 * 文件上传
	 * @throws IOException 
	 */
	public static String fileUpload(HttpServletRequest request,HttpServletResponse response,String PATH_FOLDER,String TEMP_FOLDER ) throws IOException{
		long MAX_SIZE = 10 * 1024 * 1024;// 设置上传文件最大为 10M
		// 允许上传的文件格式的列表
		String[] allowtype = new String[] {"png","JPG","jpg","jpeg","gif","txt","doc","docx","mp3","wma","m4a","xls"};
		 
		// 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
	    DiskFileItemFactory dfif = new DiskFileItemFactory();
	    dfif.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
	    dfif.setRepository(new File(TEMP_FOLDER));// 设置存放临时文件的目录,web根目录下的uploadtemp目录
	    // 用以上工厂实例化上传组件
	    ServletFileUpload sfu = new ServletFileUpload(dfif);
	    // 设置最大上传尺寸
	    sfu.setSizeMax(MAX_SIZE);
	 
	    PrintWriter out = response.getWriter();
	    // 从request得到 所有 上传域的列表
	    List<FileItem> fileList = null;
	    try {
	      fileList = sfu.parseRequest(request);
	    } catch (FileUploadException e) {// 处理文件尺寸过大异常
	      if (e instanceof SizeLimitExceededException) {
	        out.println("{message:'文件尺寸超过规定大小:"+MAX_SIZE+"字节'}");
	        return null;
	      }
	      e.printStackTrace();
	    }
	    // 没有文件上传
	    if (fileList == null || fileList.size() == 0) {
	      out.println("{message:'请选择上传文件'}");
	      return null;
	    }
	    // 得到所有上传的文件
	    @SuppressWarnings("rawtypes")
		Iterator fileItr = fileList.iterator();
	    // 循环处理所有文件
	    while (fileItr.hasNext()) {
	      FileItem fileItem = null;
	      String path = null;
	      long size = 0;
	      // 得到当前文件
	      fileItem = (FileItem) fileItr.next();
	      // 忽略简单form字段而不是上传域的文件域(<input type="text" />等)
	      if (fileItem == null || fileItem.isFormField()) {
	        continue;
	      }
	      // 得到文件的完整路径
	      path = fileItem.getName();
	      // 得到文件的大小
	      size = fileItem.getSize();
	      if ("".equals(path) || size == 0) {
	        out.println("{message:'请选择上传文件'}");
	        return null;
	      }
	 
	      // 得到去除路径的文件名
	      String t_name = path.substring(path.lastIndexOf("\\") + 1);
	      // 得到文件的扩展名(无扩展名时将得到全名)
	      String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
	      // 拒绝接受规定文件格式之外的文件类型
	      int allowFlag = 0;
	      int allowedExtCount = allowtype.length;
	      for (; allowFlag < allowedExtCount; allowFlag++) {
	        if (allowtype[allowFlag].equals(t_ext))
	          break;
	      }
	      if (allowFlag == allowedExtCount) {
	        String message = "";
	        for (allowFlag = 0; allowFlag < allowedExtCount; allowFlag++){
	          message+="*." + allowtype[allowFlag]
	                        + " ";
	        }
	        out.println("{message:'请上传以下类型的文件"+message+"'}");
	        return null;
	      }
	 
	      long now = System.currentTimeMillis();
	      // 根据系统时间生成上传后保存的文件名
	      String prefix = String.valueOf(now);
	      // 保存的最终文件完整路径,保存在web根目录下的upload目录下
	      /*String u_name = PATH_FOLDER
	          + prefix + "." + t_ext;*/
	      
	      try {
	        // 保存文件
	    	// 保存后的文件名
			String saveName = new Date().getTime()+"." + t_ext;
				
	        fileItem.write(new File(PATH_FOLDER,saveName));
	        response.setStatus(200);
	        out.println("{message:\"文件上传成功. 已保存为: " + prefix + "." + t_ext
	            + " 文件大小: " + size + "字节\"}");
	        return saveName;
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }
	    return null;
	}
	
	
	/**
	 * 图片异步上传并回显
	 */
	public static void uploadImgNoReturn(HttpServletRequest request,HttpServletResponse response,String PATH_FOLDER,String TEMP_FOLDER ){
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// 提交上来的信息都在这个list里面
			// 这意味着可以上传多个文件
			// 请自行组织代码
			List<FileItem> list = upload.parseRequest(request);
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			// 获取文件名
			String filename = getUploadFileName(item);
			// 保存后的文件名
			String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
			// 保存后图片的浏览器访问路径
			String picUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload/"+saveName;

			/*System.out.println("存放目录:" + PATH_FOLDER);
			System.out.println("文件名:" + filename);
			System.out.println("浏览器访问路径:" + picUrl);*/

			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName)); // 第三方提供的
			
			PrintWriter writer = response.getWriter();
			
			writer.print("{");
			writer.print("msg:\"文件大小:"+item.getSize()+",文件名:"+filename+"\"");
			writer.print(",picUrl:\"" + picUrl + "\"");
			writer.print("}");
			
			writer.close();
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 图片异步上传并回显
	 */
	public static String uploadImg(HttpServletRequest request,HttpServletResponse response,String PATH_FOLDER,String TEMP_FOLDER ){
		// 获得磁盘文件条目工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
		// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
		/**
		 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
		 * 格式的 然后再将其真正写到 对应目录的硬盘上
		 */
		factory.setRepository(new File(TEMP_FOLDER));
		// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
		factory.setSizeThreshold(1024 * 1024);

		// 高水平的API文件上传处理
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			// 提交上来的信息都在这个list里面
			// 这意味着可以上传多个文件
			// 请自行组织代码
			List<FileItem> list = upload.parseRequest(request);
			// 获取上传的文件
			FileItem item = getUploadFileItem(list);
			// 获取文件名
			String filename = getUploadFileName(item);
			// 保存后的文件名
			String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
			// 保存后图片的浏览器访问路径
			String picUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload/"+saveName;

			/*System.out.println("存放目录:" + PATH_FOLDER);
			System.out.println("文件名:" + filename);
			System.out.println("浏览器访问路径:" + picUrl);*/

			// 真正写到磁盘上
			item.write(new File(PATH_FOLDER, saveName)); // 第三方提供的
			
			PrintWriter writer = response.getWriter();
			
			writer.print("{");
			writer.print("msg:\"文件大小:"+item.getSize()+",文件名:"+filename+"\"");
			writer.print(",picUrl:\"" + picUrl + "\"");
			writer.print("}");
			
			writer.close();
			return saveName;
		
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private static FileItem getUploadFileItem(List<FileItem> list) {
		for (FileItem fileItem : list) {
			if(!fileItem.isFormField()) {
				return fileItem;
			}
		}
		return null;
	}
	
	private static String getUploadFileName(FileItem item) {
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("/");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);
		return filename;
	}
	
	
	public static void downLoadFile(HttpServletResponse response,String path) throws IOException{
		//处理请求  
        //读取要下载的文件  
		File f = new File(path);  
        if(f.exists()){  
            @SuppressWarnings("resource")
			FileInputStream  fis = new FileInputStream(f);  
            String filename=URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题  
            byte[] b = new byte[fis.available()];  
            fis.read(b);  
            response.setCharacterEncoding("utf-8");  
            response.setHeader("Content-Disposition","attachment; filename="+filename+"");  
            //获取响应报文输出流对象  
            ServletOutputStream  out =response.getOutputStream();  
            //输出  
            out.write(b);  
            out.flush();  
            out.close(); 
        }
	}
}
