package com.zoho.testingtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @Bind(R.id.screenTwoTxtView)
    TextView textView;

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        text = getIntent().getExtras().getString("text");
        init();
    }

    //  init
    private void init() {
        textView.setText(text);
    }

    @OnClick(R.id.screenTwoTxtView)
    public void textViewClick() {
        startActivity(new Intent(getApplicationContext(), DialerActivity.class));
    }
}