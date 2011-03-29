package com.simei.glow;


import com.simei.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartGameActivity extends Activity
{
	
	private Button easyBut = null;//简单
	private Button hardBut = null;//中等
	private Button mediumBut = null;//困难
	private Button insaneBut = null;//艰难
	private Button backBut = null;//返回

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startgame);
		initWidget();
	}
	/**
	 * 初始化控件
	 */
	private void initWidget()
	{
		easyBut = (Button)findViewById(R.id.easyBut);
		hardBut = (Button)findViewById(R.id.hardBut);
		mediumBut = (Button)findViewById(R.id.mediumBut);
		insaneBut = (Button)findViewById(R.id.insaneBut);
		backBut = (Button)findViewById(R.id.gobackBut);
		
		easyBut.setOnClickListener(new ButtonListener());
		hardBut.setOnClickListener(new ButtonListener());
		mediumBut.setOnClickListener(new ButtonListener());
		insaneBut.setOnClickListener(new ButtonListener());
		backBut.setOnClickListener(new ButtonListener());
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
			if(v == easyBut)//简单
			{
			}
			else if(v == hardBut)//中等
			{
			}
			else if(v == mediumBut)//困难
			{
			}
			else if(v == insaneBut)//艰难
			{
			}
			else if(v == backBut)//退出
			{
				StartGameActivity.this.finish();
			}
		}
		
	}
	
	
}
