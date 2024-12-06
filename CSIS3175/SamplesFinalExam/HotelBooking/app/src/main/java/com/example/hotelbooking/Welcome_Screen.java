package com.example.hotelbooking;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Welcome_Screen extends AppCompatActivity {
    AnimationDrawable sampleAnimation;
    int frameAnimationStatus = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_screen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_hotel);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        Button button = (Button) findViewById(R.id.ws_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Welcome_Screen.this, Splash_Screen.class));
            }
        });

        // Sample of frame Animation

        Button button_frame_animation = (Button) findViewById(R.id.ws_sampleButton2);
        button_frame_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView ws_image = findViewById(R.id.ws_iv_welcome);
                ws_image.setImageResource(0);

                ws_image.setBackgroundResource(R.drawable.animation);
                sampleAnimation = (AnimationDrawable) ws_image.getBackground();
                if (frameAnimationStatus == 0){
                    sampleAnimation.start();
                    frameAnimationStatus = 1;
                } else {
                    sampleAnimation.stop();
                    frameAnimationStatus = 0;
                }
            }
        });

        // Sample of Tween Animation

        Button button_tween_animation = (Button) findViewById(R.id.ws_sample_button1);
        button_tween_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView ws_image = findViewById(R.id.ws_iv_welcome);
                ws_image.startAnimation(AnimationUtils.loadAnimation(Welcome_Screen.this, R.drawable.rotation));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

// Steps to generate APK
// options -> build -> generate Signed Bundle / APK
// select the right option (bundle) -> next
// create the keys -> next
// debug option -> finish