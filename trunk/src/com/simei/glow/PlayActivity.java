package com.simei.glow;


import com.simei.util.Textures;
import com.stickycoding.rokon.DrawPriority;
import com.stickycoding.rokon.RokonActivity;

/**
 * 游戏界面Activity
 * @author KeTai
 *
 */
public class PlayActivity extends RokonActivity{
	//屏幕静态常量 宽度
	private static float GAME_WIDTH = 3.2f;
	//屏幕静态常量 高度
	private static float GAME_HEIGHT = 4.8f;
	
	
	@Override
	public void onCreate() {
 		super.onCreate();
 		
 		debugMode();
		//全屏显示
		forceFullscreen();
		
		forcePortrait();
		//forceLandscape();
		//竖屏显示
		//forcePortrait();
		//设置游戏界面大小
		setGameSize(GAME_WIDTH, GAME_HEIGHT);
		//设置绘图模式 0 -- VBO模式   1 -- 一般模式  openGL 渲染方式之一 priority_vbo
		setDrawPriority(DrawPriority.PRIORITY_VBO);
		//背景图片资源目录文件
		setGraphicsPath("textures/");
		//创建一个引擎
		createEngine();
	
	
	}

	@Override
	public void onLoadComplete() {
 		super.onLoadComplete();
 		
 		//加载图片
		Textures.load();
		//设置场景
		setScene(new GameScene());
	}
		
	
	
	
}
