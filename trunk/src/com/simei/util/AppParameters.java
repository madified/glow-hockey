package com.simei.util;

import android.app.Application;
import android.content.Context;
 /**
 * 系统参数类，游戏里面所有的参数都从这里面读取
 * @author KeTai
 *
 */
public class AppParameters extends Application {
	private boolean audio_parameter;		//声音参数
	private boolean shake_parameter;		//震动参数
	private boolean granule_parameter ;	//粒子参数
	
	private boolean flag = true;   //用来标记是否好需要从文件里面读取参数
	private static Context context;
	private static ShareParameters shareParameters; 
	private static AppParameters appParameters = new AppParameters();
	 
	/**
	 * 私有化构造函数，使用单例
	 */
	private AppParameters(){
		
	}
	
	/**
	 * 获取
	 * @param context
	 * @return
	 */
	public static AppParameters getInstance(Context context){
		   shareParameters =ShareParameters.getInstance(context);  
		return appParameters;
	}
	
	
	/**
	 * 在程序初始化的时候，讲系统所有的参数从文件中读取到这个参数类里
	 */
	protected void init(){
		if(!flag){	//如果flag为false，那么将从文件中初始化参数 
		
 			setAudio_parameter(shareParameters.getAudioParameter());
			setShake_parameter(shareParameters.getShakeParameter());
			setGranule_parameter(shareParameters.getGranuleParameter());
			setFlag(false);
		}
		 
	}

	@Override
	public void onCreate() {
 		super.onCreate();
		shareParameters =ShareParameters.getInstance(context); 
 		init();
	}

	
	public boolean isAudio_parameter() {
		return audio_parameter;
	}

	public boolean isShake_parameter() {
		return shake_parameter;
	}

	public boolean isGranule_parameter() {
		return granule_parameter;
	}

	public boolean isFlag() {
		return flag;
	}

	
	public void setAudio_parameter(boolean audio_parameter) {
		this.audio_parameter = audio_parameter;
		shareParameters.setAudioParameter(audio_parameter);
	}

	public void setShake_parameter(boolean shake_parameter) {
		this.shake_parameter = shake_parameter;
		shareParameters.setShakeParameter(shake_parameter); 
	}

	public void setGranule_parameter(boolean granule_parameter) {
		this.granule_parameter = granule_parameter;
		shareParameters.setGranuleParameter(granule_parameter);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
 
	  
}
