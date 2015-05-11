package com.example.drkpkg.activofijos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void callReaderActivityAfterButton(View view){
        new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data);

        if (scanResult != null) {
            Toast.makeText(this,scanResult.getContents(),Toast.LENGTH_LONG).show();
            /*
            * Mandar los datos de verificacion via rest
            * */
        }
    }
}
