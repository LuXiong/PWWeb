package com.pwweb.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ListIterator;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.Constant;
import com.pwweb.service.PassService;
import javax.persistence.Entity;

@Entity
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private String username;
	private String password;
	// private JSONArray result;
	private HashMap<String, Object> jsonData;
	private ArrayList<HashMap<String, Object>> arrayData;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//
	// public JSONArray getResult() {
	// return result;
	// }
	//
	// public void setResult(JSONArray result) {
	// this.result = result;
	// }

	public HashMap<String, Object> getJsonData() {
		return jsonData;
	}

	public void setJsonData(HashMap<String, Object> jsonData) {
		this.jsonData = jsonData;
	}

	public ArrayList<HashMap<String, Object>> getArrayData() {
		return arrayData;
	}

	public void setArrayData(ArrayList<HashMap<String, Object>> arrayData) {
		this.arrayData = arrayData;
	}

	public String execute() throws Exception {

		return "json";
	}

	public String test(){
		jsonData = new HashMap<String, Object>();
		System.out.println(this.username);
		jsonData.put("msg", this.username);
		return SUCCESS;
	}
	public String ActionLogin() {
		// JSONObject obj = new JSONObject();
		jsonData = new HashMap<String, Object>();
		arrayData = new ArrayList<HashMap<String, Object>>();
		PassService ps = new PassService();
		String result = ps.login(getUsername(), getPassword());
		if (result.equals(Constant.FAILURE)) {
			jsonData.put("code", "-1");
		} else {
			jsonData.put("access_token", result);
		}
		arrayData.add(jsonData);
		return SUCCESS;
	}
}
