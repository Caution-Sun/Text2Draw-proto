package org.techtown.capston_sample_1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    boolean login = false;
    String id = "";
    String text = "";
    String style = "";

    Button buttonRetry;

    ProgressDialog dialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Intent intent = getIntent();
        processIntent(intent);

        dialog = new ProgressDialog(ResultActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("이미지를 만드는 중입니다.");
        dialog.setCancelable(false);

        //dialog.show();

        //dialog.dismiss();

        buttonRetry = findViewById(R.id.buttonRetry);
        buttonRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);

                finish();
            }
        });



    }

    private void processIntent(Intent intent){

        if(intent != null){
            Bundle bundle = intent.getExtras();
            login = bundle.getBoolean("login");
            id = bundle.getString("id");
            text = bundle.getString("text");
            style = bundle.getString("style");
        }
    }

}
