package com.jey_dev.lib.based;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by JeyHoon on 2017. 4. 21..
 */

public class JeYAboutActivity extends JActivity {

    public static final String LOGO_IS_WHITE="logo_is_black";
    public static final String LOGO_WITH_TITLE="logo_with_title";

    private ImageView logoIv=null;
    private boolean isLogoWhite=false;
    private boolean isLogoWithTitle=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        setContentView(R.layout.activity_jey_about);
        if(getIntent().hasExtra(LOGO_IS_WHITE)){
            isLogoWhite=getIntent().getExtras().getBoolean(LOGO_IS_WHITE,false);
        }
        if(getIntent().hasExtra(LOGO_WITH_TITLE)){
            isLogoWithTitle=getIntent().getExtras().getBoolean(LOGO_WITH_TITLE,false);
        }
        logoIv=(ImageView)findViewById(R.id.jey_about_logo_iv);
        if(isLogoWhite){
            if(isLogoWithTitle){
                logoIv.setImageResource(R.drawable.logo_jdev_title_white_240dp);
            }else {
                logoIv.setImageResource(R.drawable.logo_jdev_white_240dp);
            }
        }else{
            if(isLogoWithTitle){
                logoIv.setImageResource(R.drawable.logo_jdev_title_primary_black_240dp);
            }else {
                logoIv.setImageResource(R.drawable.logo_jdev_primary_240dp);
            }
        }
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
    public void sendAdContact(View v){
        startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:ad@jey-dev.com")));
    }
    public void clickRoot(View v){
        finish();
    }
}
