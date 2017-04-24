package com.jey_dev.lib.based;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by JeyHoon on 2017. 4. 21..
 */

public class JeYAboutActivity extends JActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        setContentView(R.layout.activity_jey_about);
    }
    public void exitAct(View v){
        finish();
    }
    public void goHomepage(View v){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jey-dev.com")));
    }
    public void sendNorContact(View v){
        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:info@jey-dev.com")));
    }
    public void sendBilContact(View v){
        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:billing@jey-dev.com")));
    }
    public void clickRoot(View v){
        finish();
    }
}
