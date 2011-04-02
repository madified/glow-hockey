package com.simei.glow;

import com.simei.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HockeyActivity extends Activity
{

	private Button startBut = null;//开始游戏
	private Button setBut = null;//设置游戏
	private Button aboutBut = null;//关于游戏
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initWidget();//初始化控件
	}
	
	/**
	 * @author Addy
	 * 
	 * 初始化控件
	 */
	private void initWidget()
	{
		startBut = (Button)findViewById(R.id.startBut);
		setBut = (Button)findViewById(R.id.setBut);
		aboutBut = (Button)findViewById(R.id.aboutBut);
		
		startBut.setOnClickListener(new ButtonListener());
		setBut.setOnClickListener(new ButtonListener());
		aboutBut.setOnClickListener(new ButtonListener());
		
	}
	
	/**
	 * 
	 * @author Addy
	 *按钮点击事件类
	 */
	private class ButtonListener implements OnClickListener
	{

		
		@Override
		public void onClick(View v)
		{
			Intent intent = null;
			if(v == startBut)//开始游戏
			{
				intent = new Intent(HockeyActivity.this,StartGameActivity.class);
			}
			else if(v == setBut)//设置游戏
			{
				intent = new Intent(HockeyActivity.this,SettingGameActivity.class);
			}
			else if(v == aboutBut)//关于游戏
			{
				intent = new Intent(HockeyActivity.this,AboutGameActivity.class);
			}
			startActivity(intent);
			overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
		}
		
	}
	
}
