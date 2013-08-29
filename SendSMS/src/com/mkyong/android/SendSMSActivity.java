package com.mkyong.android;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
 
public class SendSMSActivity extends Activity {
 
	Button buttonSend;
	EditText textPhoneNo;
	EditText uid,textSMS,url;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
 
		buttonSend = (Button) findViewById(R.id.buttonSend);
		textPhoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
		textSMS = (EditText) findViewById(R.id.editTextSMS);
		uid = (EditText) findViewById(R.id.uid);
		url = (EditText) findViewById(R.id.url);
 
		buttonSend.setOnClickListener(new OnClickListener() {
 
		//	@Override
			public void onClick(View v) {
 
			  String phoneNo = textPhoneNo.getText().toString();
			  String uname=textSMS.getText().toString();
			  String uid1=uid.getText().toString();
			  String url1=url.getText().toString();
			  String sms = "A-"+uname+"-"+uid1+"-"+url1;
 
			  try {
				  
				  
				//  Intent sendIntent = new Intent(Intent.ACTION_VIEW);
				 // sendIntent.putExtra("sms_body", "default content"); 
				 // sendIntent.setType("vnd.android-dir/mms-sms");
				  //	startActivity(sendIntent);

				  
				  
				  
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phoneNo, null, sms, null, null);
				Toast.makeText(getApplicationContext(), "Registration Request Sent!",
							Toast.LENGTH_LONG).show();
			  } catch (Exception e) {
				Toast.makeText(getApplicationContext(),
					"SMS faild, please try again later!",
					Toast.LENGTH_LONG).show();
				e.printStackTrace();
			  }
 
			}
		});
	}
}
