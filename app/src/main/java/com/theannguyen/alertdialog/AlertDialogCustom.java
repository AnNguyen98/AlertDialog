package com.theannguyen.alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogCustom extends AppCompatActivity {

    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_custom);

        buttonLogin = (Button) findViewById(R.id.btnLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog();
            }
        });

    }
    private  void setDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("LOGIN");
        dialog.setContentView(R.layout.login_dialog);

        final EditText edtUser = (EditText) dialog.findViewById(R.id.user);
        final EditText edtPass = (EditText) dialog.findViewById(R.id.pass);
        final Button   btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
        final Button   btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if(user == "An" && pass == "1"){
                    Toast.makeText(AlertDialogCustom.this,"LOGIN SUCCESS!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AlertDialogCustom.this,"LOGIN FAILL!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog.cancel();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
