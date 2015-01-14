package com.example.loginapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ChangePassword extends Activity {
	EditText oldpassword;
	EditText newpassword;
	EditText newpassword2;
	String oldpasswordtxt,newpasswordtxt,newpassword2txt;
	Button changePass;
	
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
		
		changePass=(Button)findViewById(R.id.ChangePassButton);
		changePass.setOnClickListener(new OnClickListener() {
       	 
            public void onClick(View arg0) {
            	
                
               // Log.println(TRIM_MEMORY_RUNNING_CRITICAL, newpasswordtxt, newpassword2txt);
                
            	if (newpasswordtxt.equalsIgnoreCase(newpassword2txt)) {
            		ParseUser user = ParseUser.getCurrentUser();
            		user.setPassword(newpasswordtxt);
            		user.saveInBackground(new SaveCallback() {
            		    public void done(ParseException e) {
            		        if (null == e) {
            		        	Toast.makeText(getApplicationContext(),
                                        "Successfully Changed password",
                                        Toast.LENGTH_LONG).show();
            		        } else {
            		        	Toast.makeText(getApplicationContext(),
                                        "Unable to change password",
                                        Toast.LENGTH_LONG).show();
            		        }
            		    }
            		});
            		
            	}
            }
        });
	}
}
