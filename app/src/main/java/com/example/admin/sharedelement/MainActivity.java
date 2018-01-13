package com.example.admin.sharedelement;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imgLogo;
    private ImageView imgProfilePic;
    private TextView txvShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgLogo = (ImageView) findViewById(R.id.imgSmartherdLogo);
        imgProfilePic = (ImageView) findViewById(R.id.imgAnnie);
        txvShared = (TextView) findViewById(R.id.txvSharedElement);
        LinearLayout button = (LinearLayout) findViewById(R.id.shared_element);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                sharedElementTransition(view);
            }
        });
    }
    @SuppressLint("NewApi")
    public void sharedElementTransition(View view) {

        Pair[] pair = new Pair[3];
        pair[0] = new Pair<View, String>(imgLogo, "logo_shared");
        pair[1] = new Pair<View, String>(txvShared, "smartherd_shared");
        pair[2] = new Pair<View, String>(imgProfilePic, "profile_pic_shared");

        @SuppressLint({"NewApi", "LocalSuppress"}) ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent i = new Intent(MainActivity.this, SharedElementTransitions.class);
        overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
        startActivity(i, options.toBundle());
    }
}
