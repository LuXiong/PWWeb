package com.pwweb.common;

import javax.persistence.Entity;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
/**
 * 
 * @author Dean
 * 
 */
@Entity
public class Constant {
	public final static String SUCCESS = "success";
	public final static String FAILURE = "failure";
	public final static String topic = "PW";
	public final static int qos = 2;
	public final static String broker = "tcp://xlook315.eicp.net:39099";//"tcp://127.0.0.1:1883";
	public final static String clientId = "JavaSample";
	public final static MemoryPersistence persistence = new MemoryPersistence();
	public final static String CoolColor = "cool color";
	public final static String NeutralColor = "neutral color";
	public final static String WarmColor = "warm color";
}
