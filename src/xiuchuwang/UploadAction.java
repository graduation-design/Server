package xiuchuwang;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport implements 
ServletRequestAware,ServletResponseAware{
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_SIZE = 1024;
	HttpServletRequest request;
    HttpServletResponse response;
    private String title;//文件标题
	private File upload;//上传文件域对象
	private String uploadFileName;//上传文件名
	private String uploadContentType;//上传文件类型
	private String savePath;
	private String uploadtext;
	private Map<String,Object> dataMap;
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getUploadtext() {
		return uploadtext;
	}

	public void setUploadtext(String uploadtext) {
		this.uploadtext = uploadtext;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {

		this.request = request;
	}

	public String test(){
		System.out.println("test:"+uploadtext);
		return SUCCESS;
	}
	public String recipe(){
		String dstPath = "D:/myfile"+"/"+this.getUploadFileName();
		File dstFile = new File(dstPath);
		System.out.println(dstPath);
		copy(this.upload,dstFile);
		//System.out.println("testasdsd:"+uploadtext);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		dataMap.put("url", dstPath);
		dataMap.put("success",true);
		return SUCCESS;
	}
	
	
	private void copy(File src,File dst){
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new BufferedInputStream(
				new FileInputStream(src),BUFFER_SIZE);
		
			out = new BufferedOutputStream(
				new FileOutputStream(dst),BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];
			int len=0;
			while((len = in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(null!=in){
					try{
						in.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}


				if(null!=out){
					try{
						out.close();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
		}
}
