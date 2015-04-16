package xiuchuwang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class Recipe extends ActionSupport implements 
ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;
    HttpServletResponse response;
    private String recipename;
    private String recipeimg;
    private String recipebg;
    private List<HashMap<String,String>> materials;
    private List<HashMap<String,String>> steps;
    private JSONObject jsonrecipe;
    private JSONArray jsonsteps;
    
   
//    public void test(){
//    	jsonrecipe = new JSONObject();
//    	jsonsteps = new JSONArray();
//    	jsonrecipe.put("name", "recipe");
//    	for(int i=0; i<3;i++){
//    			JSONObject temp = new JSONObject();
//    			temp.put("step", "this is "+i+" step");
//    			temp.put("img", "this is "+i+" img");
//    			jsonsteps.add(temp);
//    	}
//    	jsonrecipe.put("steps", jsonsteps);
//    	
//    	System.out.println("jjjsssoonnn:"+jsonrecipe.toString());
//    	
//    }
    
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

	public String assign(){
		recipename = "11";
		recipeimg = "http://cp1.douguo.net/upload/caiku/6/3/7/600x400_632832a729e5d3218af37da09283e967.jpg";
		recipebg = "22";
		materials = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> myhash = new HashMap<String,String>();
		myhash.put("material","33");
		myhash.put("dosage","44");
		materials.add(myhash);
		myhash.clear();
		myhash.put("material","55");
		myhash.put("dosage","66");
		materials.add(myhash);
		myhash.put("material","55");
		myhash.put("dosage","66");
		materials.add(myhash);
		myhash.put("material","55");
		myhash.put("dosage","66");
		materials.add(myhash);
		myhash.put("material","55");
		myhash.put("dosage","66");
		materials.add(myhash);



		steps = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> myhash2 = new HashMap<String,String>();
		myhash2.put("step","this is step1");
		myhash2.put("stepimg","http://cp1.douguo.net/upload/caiku/3/b/4/200_3b0525c5f9506791b63352ac27e4a834.jpg");
		steps.add(myhash2);
		myhash2.clear();
		myhash2.put("step","这个好呀好呀");
		myhash2.put("stepimg","http://cp1.douguo.net/upload/caiku/4/4/5/200_44effd928cc7cd37864fbcba1cd26d55.jpg");
		steps.add(myhash2);
		

		System.out.println(materials.toString());
		System.out.println(steps.toString());


		jsonrecipe = new JSONObject();
    	jsonsteps = new JSONArray();
    	jsonrecipe.put("name", "recipe");
    	for(int i=0; i<3;i++){
    			JSONObject temp = new JSONObject();
    			temp.put("step", "this is "+i+" step");
    			temp.put("img", "this is "+i+" img");
    			jsonsteps.add(temp);
    	}
    	jsonrecipe.put("steps", jsonsteps);
    	
    	System.out.println("jjjsssoonnn:"+jsonrecipe.toString());
		
		return "velocity";

	}

	public String getRecipename() {
		return recipename;
	}

	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}

	public String getRecipeimg() {
		return recipeimg;
	}

	public void setRecipeimg(String recipeimg) {
		this.recipeimg = recipeimg;
	}

	public String getRecipebg() {
		return recipebg;
	}

	public void setRecipebg(String recipebg) {
		this.recipebg = recipebg;
	}

	public List<HashMap<String, String>> getMaterials() {
		return materials;
	}

	public void setMaterials(List<HashMap<String, String>> materials) {
		this.materials = materials;
	}

	public List<HashMap<String, String>> getSteps() {
		return steps;
	}

	public void setSteps(List<HashMap<String, String>> steps) {
		this.steps = steps;
	}
	
	
}
