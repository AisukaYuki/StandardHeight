package com.hkun.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText edtw;
	Button btnc1=null,btnc2=null;
	TextView res=null,restv;
	RadioGroup rg=null;
	RadioButton rbm=null,rbf=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		
		edtw=(EditText) findViewById(R.id.edtw);
		res=(TextView) findViewById(R.id.res);
		btnc1=(Button) findViewById(R.id.btnC1);
		btnc2=(Button) findViewById(R.id.btnC2);
		rg=(RadioGroup) findViewById(R.id.rg1);
		rbm=(RadioButton) findViewById(R.id.rbm);
		rbf=(RadioButton) findViewById(R.id.rbf);

		final String str1 = res.getText().toString();
		
		btnc1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String str = edtw.getText().toString();
				float height = 0;
				if(TextUtils.isEmpty(str)){
					edtw.setError("请输入你的体重");
					edtw.requestFocus();
					return;
				}
				
				float weight = Float.parseFloat(str);
				
				if(rg.getCheckedRadioButtonId()==rbm.getId()){
					height=(float) (170-(62-weight)/0.6);
				}
				if(rg.getCheckedRadioButtonId()==rbf.getId()){
					height=(float) (158-(52-weight)/0.5);
				}
				DecimalFormat df= new DecimalFormat(".00");
				df.format(height);
				res.setText(str1+String.valueOf(df.format(height))+"CM");
				edtw.setText(null);
			}
		});
	
		btnc2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				edtw.setText(null);
				res.setText(str1);
				
			}
		});
	}
}
