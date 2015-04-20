package com.pwweb.action;

import java.util.HashMap;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.Constant;

public class PushAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1492859033534619859L;
	private HashMap<String, String> jsonData;
	private String data;

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
		try {
			MqttClient sampleClient = new MqttClient(Constant.broker,
					Constant.clientId, Constant.persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			sampleClient.connect(connOpts);
			MqttMessage message = new MqttMessage(data.getBytes());
			message.setQos(Constant.qos);
			sampleClient.publish(Constant.topic, message);
			sampleClient.disconnect();
			jsonData.put("result", "1");
			System.out.println("publish success");
		} catch (MqttException me) {
			me.printStackTrace();
			jsonData.put("code", "-1");
			jsonData.toString().getBytes();
		}
		return SUCCESS;
	}
}
