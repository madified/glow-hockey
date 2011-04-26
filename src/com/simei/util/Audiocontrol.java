package com.simei.util;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

/**
 * 播放音效的工具类
 * @author 吴庆彬
 *
 */
public class Audiocontrol {
	
 	private MediaPlayer mp ;		//音乐播放器对象
	private AssetFileDescriptor afd;	//获取assets文件夹里文件的对象
	private ShareParameters parameterUtil;
	private Context context;

	
	//下面是各种因为音乐文件
	private static String menu_select = "menu_select.mp3";
	private static String menu_canel = "menu_cancel.mp3";
	private static String pause = "pause.mp3";
	private static String my_puck_hit = "puck_hit1.mp3";
	private static String pic_puck_hit = "puck_hit2.mp3";
	private static String winner = "loser.mp3";
	private static String loser = "loser.mp3";
	private static String goal = "goal.mp3";
	private static String placing_puck = "placing_puck.mp3";
	private static String hit_paddle = "hit_paddle1.mp3";
 
	
	
	
	/**
	 * 在构造方法里面纯如上下文，并实例化音乐播放器
	 * @param context
	 */
	public Audiocontrol(Context context){
		this.context = context;
		mp = new MediaPlayer();
		parameterUtil =  ShareParameters.getInstance(context);
	
	}
	
	/**
	 * 获取系统是否静音，true为静音，暂定系统参数存放在sharePreferences中
	 * @return
	 */
	public boolean getParameter(){
		
		return parameterUtil.getAudioParameter();
	}
	 
	
	
	/**
	 * 确认、取消或暂定。不传参时为暂停的音乐；传一个参数时为菜单按钮或者是在暂停中确认或者取消,ture为确认，false为取消；
	 * @param bool
	 * @throws Exception
	 */
	public void selectOrCanelAudio(boolean... bool) throws Exception{
		
		if(bool.length<=0){
			this.play(pause); 
		}else if(bool[0]){
			this.play(menu_select);
		}else{
			 this.play(menu_canel);
 		}   
	}
	
	/**
	 * 球被击打调用的音乐方法，可以不传参或传一个boolean值。当球击打墙壁时，不传参；true为自己击打球，false为电脑击打球。
	 * @param bools
	 * @throws Exception
	 */
	public void hitPuck(boolean... bools) throws Exception{
		if(bools.length<=0){
			 this.play(hit_paddle);
		}if(bools[0]){
			 this.play(my_puck_hit); 
		}else{
			 this.play(pic_puck_hit);		
		}
		
	} 
	
	/**
	 * 赢或输的音乐，true为赢，false为输球
	 * @param bool
	 * @throws Exception
	 */
	public void winOrLose(boolean bool) throws Exception{
		if(bool){
			this.play(winner);
		}else{
			this.play(loser);
		}
		
	}
	
	/**
	 * 进球或者是把球放置在场上时的音乐，ture为进球，放置球为false
	 * @param bool
	 */
	public void goalOrPlacing_puck(boolean bool) throws Exception{
		if(bool){
			this.play(goal);
		}else{
			this.play(placing_puck);
		} 
	}
	 
	 
	/**
	 * 播放音乐，是各个播放方法都要调用的这个方法
	 * @param filename
	 * @throws Exception
	 */
	public void play(String filename)throws Exception{ 
		
		if(this.getParameter()){ 	//如果系统的参数为真的是很，播放音乐
			afd = this.context.getAssets().openFd(filename);
		 	mp.reset();
			mp.setDataSource(afd.getFileDescriptor());
			mp.prepare();
			mp.start();	
		}
		
	}	 
	
	
}
