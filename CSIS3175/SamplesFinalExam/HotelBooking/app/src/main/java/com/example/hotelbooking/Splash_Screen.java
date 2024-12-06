package com.example.hotelbooking;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_Screen extends AppCompatActivity {
    int counter = 3;
    MediaPlayer soundSample = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_hotel);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        Button buttonSample = (Button) findViewById(R.id.ss_button);

        // Change between Images in the countdown
        ImageView img = (ImageView) findViewById(R.id.ss_img);
        Integer[] ImagesCountdown = {R.drawable.icon_one, R.drawable.icon_two, R.drawable.icon_three};
        // Process to create countdown
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(Splash_Screen.this, MainActivity.class));
            }
        };
        timer.schedule(task, 3000);
        TextView counterText = (TextView) findViewById(R.id.ss_counter);
        CountDownTimer countdown = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long l) {
                counterText.setText(String.valueOf(counter));
                img.setImageResource(ImagesCountdown[counter-1]);
                counter--;
            }

            @Override
            public void onFinish() {
                counterText.setText(" ");
                img.setImageResource(0);
            }
        }.start();

        // Button to play sounds
        buttonSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound();
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    // Function to play sounds (Lecture 6)
    private void playSound() {
        if (soundSample != null && soundSample.isPlaying()) {
            soundSample.stop();
            soundSample.release();
        }
        Toast.makeText(Splash_Screen.this, "Sound Playing", Toast.LENGTH_SHORT).show();
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // Create a Ringtone object from the URI and play the sound
        Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), notification);
        ringtone.play();
    }
}