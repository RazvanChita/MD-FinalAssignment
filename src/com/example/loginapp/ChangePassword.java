package com.example.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

public class ChangePassword extends Activity {
	EditText oldpassword;
	EditText newpassword;
	EditText newpassword2;
	String oldpasswordtxt,newpasswordtxt,newpassword2txt;
	Button accept;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);
		
		oldpassword = (EditText) findViewById(R.id.editText2);
        newpassword = (EditText) findViewById(R.id.editText1);
        newpassword2 = (EditText) findViewById(R.id.editText3);
        
        oldpasswordtxt=oldpassword.getText().toString();
        newpasswordtxt=newpassword.getText().toString();
        newpassword2txt=newpassword2.getText().toString();
		
		accept=(Button)findViewById(R.id.AcceptNewPasswordButton);
		accept.setOnClickListener(new OnClickListener() {
       	 
            public void onClick(View arg0) {
            	if (newpasswordtxt==newpassword2txt) {
            		ParseUser user = ParseUser.getCurrentUser();
            		user.setPassword(newpasswordtxt);
            		user.saveInBackground();
            		
            	}
            }
        });
	}
}
