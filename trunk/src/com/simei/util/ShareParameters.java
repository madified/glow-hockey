package com.simei.util;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 关于获取或者设置系统参数的公共类
 * @author 吴庆彬
 *
 */
public class ShareParameters {
	private static SharedPreferences spf;	
 	private static Editor editor; // 编辑器
	private static String audio_parameter = "audio";
	private static String shake_parameter = "shake";
	private static String granule_parameter = "granule";
 	private static ShareParameters  shareParameters = new ShareParameters(); 
 
 	/**私有化构造方法，使用单例
 	 * 
 	 */
	private ShareParameters(){
 		
 	}
 	
	/**
	 * 获取ShareParameters的实例化
	 * @param context
	 * @return
	 */
	public static ShareParameters getInstance(Context context){
 		spf = context.getSharedPreferences("GlowHockey", Context.MODE_WORLD_READABLE+Context.MODE_WORLD_WRITEABLE);
		editor = spf.edit();
 		return shareParameters;
	}
	
	
	
 
	
	/**
	 * 设置音效参数的值
	 */
	public void setAudioParameter(boolean value){
		this.setBooleanParameter(audio_parameter, value);
	 }
	
	/**
	 * 设置震动参数的值
	 * @param bool
	 */
	public void setShakeParameter(boolean value){
		this.setBooleanParameter(shake_parameter, value);
		
	}
	
	/**
	 * 设置粒子参数的值
	 * @param value
	 */
	public void setGranuleParameter(boolean value){
		this.setBooleanParameter(granule_parameter, value);
	}
	
	/**
	 * 获得音乐参数的值
	 * @return
	 */
	public boolean getAudioParameter(){
		
		return this.getBooleanParameter(audio_parameter);
	}
	
	/**
	 * 获得震动参数的值
	 * @return
	 */
	public boolean getShakeParameter(){
		
		return this.getBooleanParameter(shake_parameter);
	}
	
	/**
	 * 获得粒子参数的值
	 * @return
	 */
	public boolean getGranuleParameter(){
		
		return this.getBooleanParameter(granule_parameter);
	}
	
	
	
	
	/**
	 * 设置游戏中所有布尔值参数的基础方法
	 * @param parmName
	 * @param value
	 */
	public void setBooleanParameter(String parmName,boolean value){
		  editor.clear();
		  editor.putBoolean(parmName, value);
		  editor.commit();
	
		
	} 
	
	/**
	 * 获得游戏中所有布尔值参数的基础方法
	 * @param parameter
	 * @return
	 */
	public boolean getBooleanParameter(String parameter){ 
		return spf.getBoolean(parameter, true);	
		
	}
	
	
	/** 
	 * 这个方法要在游戏开始的时候调用
	 * 
	 */  
	public void beforStart(){
		this.setAudioParameter(this.getAudioParameter());
		this.setShakeParameter(this.getShakeParameter());
		this.setGranuleParameter(this.getGranuleParameter()); 
		
	}
	
	
}
