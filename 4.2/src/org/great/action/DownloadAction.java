package org.great.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	//private InputStream downloadFile;
	 
	
	public InputStream getDownloadFile()
	{
		
		//downloadFile = ServletActionContext.getServletContext().getResourceAsStream(
				//"/upload/"+fname);
		//更改文件名格式为UTF-8防止下载乱码
		try {
			fname = new String(fname.getBytes("UTF-8"),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ServletActionContext.getServletContext().getResourceAsStream(
				"/upload/"+fname);
	}
	
	/*public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}*/

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
}
