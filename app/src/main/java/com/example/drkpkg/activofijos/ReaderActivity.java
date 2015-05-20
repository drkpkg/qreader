package com.example.drkpkg.activofijos;

import android.app.Activity;
import android.os.Bundle;

import com.google.zxing.integration.android.IntentIntegrator;


public class ReaderActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);
        new IntentIntegrator(this).initiateScan();
    }
}
