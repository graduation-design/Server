package xiuchuwang;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements 
ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
    HttpServletResponse response;
    private String name;
    private String age;
    private String message;
    private String yuri;
    private List<HashMap<String,String>> listtest;

    
    public List<HashMap<String, String>> getListtest() {
		return listtest;
	}

	public void setListtest(List<HashMap<String, String>> listtest) {
		this.listtest = listtest;
	}

	public String getYuri(){
		return yuri;
	}

	public void setYuri(String yuri) {
		this.yuri = yuri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	//将会被Struts2序列化为JSON字符串的对象
    private Map<String,Object> dataMap;
 
    /**
     * 构造方法
     */
    public LoginAction() {
        //初始化Map对象
        dataMap = new HashMap<String, Object>();
    }
 
    public Map<String, Object> getDataMap() {
        return dataMap;
    }
    
    public String mytest(){
    	 message="Hello World,Now is"+DateFormat.getDateInstance().format(new Date());
    	 yuri = "http://172.27.23.5:8080/ServerTest/YURI.jpg";
    	 listtest = new ArrayList<HashMap<String,String>>();
    	 HashMap<String,String> myhash = new HashMap<String,String>();
    	 myhash.put("material", "hongzao");
    	 myhash.put("dosage", "15g");
    	 listtest.add(myhash);
    	 myhash.put("material", "heizao");
    	 myhash.put("dosage", "45g");
    	 listtest.add(myhash);
    	 
    	 
    	System.out.println(name+":  "+age +" "+message);
    	return "velocity";
    }
    
    public String testByAction() {
        // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
        dataMap.clear();
        User user = new User();
        user.setId("123");
        user.setName("JSONActionStruts2");
        user.setPassword("1aaaaaaaaaaaaa23");
        user.setSay("Hello world !");
        dataMap.put("user", user);
        // 放入一个是否操作成功的标识
        dataMap.put("success", true);
        // 返回结果
        return SUCCESS;
    }
    
    @Override
	
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

//	 public void  login(){  
//        try {
//
//        	HttpServletResponse response=ServletActionContext.getResponse();
//            //以下代码从JSON.java中拷过来的
//            response.setContentType("text/html");
//            PrintWriter out;
//            out = response.getWriter();
//            String jsonString="{\"user\":{\"id\":\"123\",\"name\":\"JSONActionGeneral\",\"say\":\"Hello , i am a action to print a json!\",\"password\":\"JSON\"},\"success\":true}";
//          out.println(jsonString);
//            out.flush();
//            out.close();
//        	
//        	
//        	
//        	
//            
//             
//             
//    //      将要返回的实体对象进行json处理      
////              JSONObject json=JSONObject.fromObject(this.getUsername());     
//            //输出格式如：{"id":1, "username":"zhangsan", "pwd":"123"}      
////               System.out.println(json);       
//           
////               this.response.getWriter().write(json.toString());
//           
////              JSONObject json=new JSONObject(); 
////              json.put("login", "login");
////               response.setContentType("text/html;charset=utf-8");
////              System.out.println(json);
////              byte[] jsonBytes = json.toString().getBytes("utf-8");
////              response.setContentLength(jsonBytes.length);
////              response.getOutputStream().write(jsonBytes);
////              
//           /**
//             JSONObject json=new JSONObject(); 
//              json.put("login", "login");
//              byte[] jsonBytes = json.toString().getBytes("utf-8");
//              response.setContentType("text/html;charset=utf-8");
//              response.setContentLength(jsonBytes.length);
//              response.getOutputStream().write(jsonBytes);
//              response.getOutputStream().flush();
//              response.getOutputStream().close();    
//            **/  
//             
//             
//         }catch(Exception e) { 
//            
//        	 e.printStackTrace();
//            
//        }
//
//}

}
