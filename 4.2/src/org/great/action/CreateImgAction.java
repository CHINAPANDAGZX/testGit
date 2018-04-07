package org.great.action;


import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import MyUnitl.ImageUtil;


public class CreateImgAction extends BaseAction {

	private InputStream imageStream;
	
	public String execute() {
		System.out.println("进入验证码函数");
		Map<String, BufferedImage> imageMap = ImageUtil.createImage();
		String code = imageMap.keySet().iterator().next();
		session.put("imageCode", code); // 验证码，session
 
		BufferedImage image = imageMap.get(code);
		try {
			// 将图片转变为输入流
			imageStream = ImageUtil.getInputStream(image);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}

		return "success";
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}
	
	
	
	
	
}
