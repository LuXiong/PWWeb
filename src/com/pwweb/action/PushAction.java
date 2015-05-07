package com.pwweb.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Message;
import com.pwweb.service.MessageService;

@Entity
public class PushAction extends ActionSupport {
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private static final long serialVersionUID = -1492859033534619859L;
	private JSONObject jsonObj;
	private HashMap<String, String> jsonData;
	private String data;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public HashMap<String, String> getJsonData() {
		return jsonData;
	}

	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String pushData() {
		jsonData = new HashMap<String, String>();
		MessageService ms = new MessageService();
		ms.saveMessage(Constant.topic, data, new DataBaseListener<Message>() {
			@Override
			public void onSuccess(Message msg) {
				try {
					MqttClient sampleClient = new MqttClient(Constant.broker,
							Constant.clientId, Constant.persistence);
					MqttConnectOptions connOpts = new MqttConnectOptions();
					connOpts.setCleanSession(true);
					sampleClient.connect(connOpts);
					// jsonObj = new JSONObject();
					// jsonObj.put("content", data);
					// jsonObj.put("id", String.valueOf(msg.getId()));
					jsonData.put("content", "\"" + data + "\"");
					jsonData.put("id", "\"" + String.valueOf(msg.getId())
							+ "\"");
					String result = new String(jsonData.toString().getBytes("ISO-8859-1"),
							"GBK");
					MqttMessage message = new MqttMessage(result.getBytes());
					message.setQos(Constant.qos);
					sampleClient.publish(Constant.topic, message);
					sampleClient.disconnect();
				} catch (MqttException me) {
					me.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		jsonObj.put("result", "1");
		System.out.println("publish success");

		return SUCCESS;
	}
}
