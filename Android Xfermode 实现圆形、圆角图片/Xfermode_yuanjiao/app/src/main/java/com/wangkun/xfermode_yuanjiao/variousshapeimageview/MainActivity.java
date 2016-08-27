package com.wangkun.xfermode_yuanjiao.variousshapeimageview;

import android.app.Activity;
import android.os.Bundle;

import com.wangkun.xfermode_yuanjiao.R;
import com.wangkun.xfermode_yuanjiao.view.RoundImageView;


public class MainActivity extends Activity
{
	private RoundImageView mQiQiu;
	private RoundImageView mMeiNv ; 

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*mQiQiu = (RoundImageView) findViewById(R.id.id_qiqiu);
		mMeiNv = (RoundImageView) findViewById(R.id.id_meinv);
		
		mQiQiu.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				mQiQiu.setType(RoundImageView.TYPE_ROUND);
			}
		});
		
		mMeiNv.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				mMeiNv.setBorderRadius(90);
			}
		});*/
	}

}
