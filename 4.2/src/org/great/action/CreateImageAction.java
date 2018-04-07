package org.great.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import MyUnitl.GraphicHelper;

/** 
* @author  作者 E-mail: 郭智雄
* @date 创建时间：2018年3月21日 下午4:49:00 
* @version 1.0 
* @parameter  生成验证码图片的Action
* @since  
* @return  
*/
public class CreateImageAction extends BaseAction{

	private OutputStream imageStream;
	
	public String execute(){
		//创建验证码图片
		final int width = 180; // 图片宽度
		final int height = 40; // 图片高度
		final String imgType = "jpeg"; // 指定图片格式 (不是指MIME类型)
		Map<String,BufferedImage> imageMap = GraphicHelper.create(width, height, imgType);
//		final OutputStream output = response.getOutputStream(); // 获得可以向客户端返回图片的输出流
		
		// 创建验证码图片并返回图片上的字符串
		String code = imageMap.keySet().iterator().next();
		System.out.println("验证码内容: " + code); 
		//取出验证码，放入session
		session.put("imageCode", code);
		//取出图片
		BufferedImage image = imageMap.get(code);
		
		try {  
	        ImageIO.write(image, imgType, imageStream);  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
		// (字节流)
		return "success";
		
	}
	//将图片转换为输入流
	public static InputStream getInputStream(BufferedImage image){
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
//		InputStream in = new ByteArrayInputStream(imageBts);
		InputStream in = null;
		return in ;
	}

	public OutputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(OutputStream imageStream) {
		this.imageStream = imageStream;
	}

	
}
