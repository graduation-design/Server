package xiuchuwang;

import java.text.DateFormat;
import java.util.Date;

public class HelloVelocity {

    private String message;
    private String yuri;
    
     

    public String getYuri() {
		return yuri;
	}


	public void setYuri(String yuri) {
		this.yuri = yuri;
	}


	public void setMessage(String message) {
    this.message = message;
    }


    public String getMessage() {
    return message;
    }


    public String test(){
    	try{
    		 message="Hello World,Now is"+DateFormat.getDateInstance().format(new Date());
    		 yuri="http://172.27.23.5:8080/ServerTest/YURI.jpg";
    	        System.out.println("aaaaaaaaa::::" + message);
    	}catch(Exception e){
    		
    	        System.out.println("sssssssssssssssssssssssssssssssss");
    	}
       
        return "velocity";
    }
    
}
