package com.zoho.testingtools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;

    @Bind(R.id.editText)
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    //  init
    private void init() {
        editText.setText("Hi, hello?");
    }

    @OnClick(R.id.button)
    public void showButtonClick() {
        if (TextUtils.isEmpty(editText.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Greeting text cannot be empty!", Toast.LENGTH_SHORT).show();
            return;
        }
        textView.setText("Hello, " + editText.getText().toString().trim() + " !");
    }

    @OnClick(R.id.button2)
    public void nextButtonClick() {
        startActivity(new Intent(getApplicationContext(), SecondActivity.class).putExtra("text", editText.getText().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //  for unit test
    public boolean checkPalindrome(String text) {
        int i, j;
        for (i = 0, j = text.length() - 1; i <= text.length() / 2; i++, j--) {
            if (text.charAt(i) == text.charAt(j)) {
                continue;
            }
            return false;
        }
        return true;
    }

    //  for mockito unit test
    public String getTestingString() {
        return getString(R.string.testingString);
    }
}