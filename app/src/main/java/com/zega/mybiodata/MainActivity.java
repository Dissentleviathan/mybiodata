package com.zega.mybiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Utilities utilities = new Utilities();
    private TextView tvUsername;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tv_username);
        btnLogout = findViewById(R.id.btn_loguot);

        if (!utilities.isLogin(this, "xUsername")) {
            Intent Intent = new Intent(this, LoginActivity.class);
            startActivity(Intent);
            finish();
        } else {
            String username = utilities.getPref(this, "xUsername");
            tvUsername.setText(username);
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utilities.setPref(MainActivity.this, "xUsername", null);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}