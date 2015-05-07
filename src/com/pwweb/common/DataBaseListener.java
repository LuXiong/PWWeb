package com.pwweb.common;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class DataBaseListener<T> {
	public void onSuccess(T t){
		
	}
	public void onStart(){
		
	}
	public void onFailure(String reason){
		
	}
	public void onSuccess(ArrayList<T> list){
		
	}
	public void onFinish(){
		
	}
	public void onSuccess(List<T> list){
		
	}
}
