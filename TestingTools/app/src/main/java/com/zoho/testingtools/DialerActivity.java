package com.zoho.testingtools;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialerActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1000;

    @Bind(R.id.phoneNumberEditTextView)
    EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.makeACallButton)
    public void makeACallClick() {
        if (TextUtils.isEmpty(phoneNumberEditText.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Not a valid phone number", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumberEditText.getText().toString()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "Please Turn ON CALL_PHONE permission", Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(intent);
    }

    @OnClick(R.id.pickAContact)
    public void pickAContactClick() {
        Intent intent = new Intent(getApplicationContext(), ContactsActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                phoneNumberEditText.setText(data.getExtras().getString(ContactsActivity.KEY_PHONE_NUMBER));
            }
        }
    }
}