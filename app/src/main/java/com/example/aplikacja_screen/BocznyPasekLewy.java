package com.example.aplikacja_screen;

import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m.aplikacja_screen.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class BocznyPasekLewy extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView zalogowany_jako;
    //nav_header_main_2 --żeby się dostać do textView -> zalogowany jako
    //bo ten przycisk nie jest w zwykłym Activity
    NavigationView navigationView;
    View headerView;

    //od animacji
    private AnimatorSet mSetRightOut;
    private AnimatorSet mSetLeftIn;
    private boolean mIsBackVisible = false;
    private View mCardFrontLayout;
    private View mCardBackLayout;
    TextView animacja_przod, animacja_tyl;
    View view;
    private InterstitialAd mInterstitialAd;
    AdView ad;
    Button moje_zestawy, wybor, tlumaczenie;

    //od wątków
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //NAVIGATION VIEW
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // animacja_przod = (TextView) findViewById(R.id.animacja_przod);
        // animacja_tyl = (TextView) findViewById(R.id.animacja_tyl);
        //
        // od animacji
        // findViews();
        // loadAnimations();
        // changeCameraDistance();
        // handler.postDelayed(new Runnable() {
        //     @Override
        //     public void run() {
        //         flipCard(view); //create view
        //     }
        // }, 2000);


        //REKLAMA
        ad = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);


        //REKLAMA next
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3337463159086570/2776499557");
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());

        mInterstitialAd.setAdListener(new AdListener(){
            public void onAdClosed(){
                startActivity(new Intent(BocznyPasekLewy.this, Wybor.class));
            }
        });


        wybor = (Button)findViewById(R.id.button3);
        tlumaczenie = (Button)findViewById(R.id.button4);
        moje_zestawy = (Button)findViewById(R.id.button5);

        wybor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BocznyPasekLewy.this,Wybor.class));
            }
        });

        tlumaczenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BocznyPasekLewy.this,Tlumaczenie.class));
            }
        });

        moje_zestawy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BocznyPasekLewy.this,MojeZestawy.class));
            }
        });
    }
 public void startnextActivity(View view){
        if(mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
        else
        {
            startActivity(new Intent(BocznyPasekLewy.this, Wybor.class));
        }
 }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_zestaw) {
            // Handle the camera action
            startActivity(new Intent(BocznyPasekLewy.this, MojeZestawy.class));       //dodano
        } else if (id == R.id.nav_wyloguj) {
            startActivity(new Intent(BocznyPasekLewy.this, MainActivity.class));
            //wylogowanie z konta
        }else if(id==R.id.nav_wybor){
            startActivity(new Intent(BocznyPasekLewy.this, Wybor.class));
        }else if(id==R.id.nav_tlumaczenie){
            startActivity(new Intent(BocznyPasekLewy.this, Tlumaczenie.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // private void changeCameraDistance() {
    //     int distance = 8000;
    //     float scale = getResources().getDisplayMetrics().density * distance;
    //     mCardFrontLayout.setCameraDistance(scale);
    //     mCardBackLayout.setCameraDistance(scale);
    // }
    //
    // @SuppressLint("ResourceType")
    // private void loadAnimations() {
    //     mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.animacja);
    //     mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.anim.animacja2);
    // }
    //
    // private void findViews() {
    //     mCardBackLayout = findViewById(R.id.card_back);
    //     mCardFrontLayout = findViewById(R.id.card_front);
    // }
    //
    // public void flipCard(View view) {
    //     if (!mIsBackVisible) {
    //         mSetRightOut.setTarget(mCardFrontLayout);
    //         mSetLeftIn.setTarget(mCardBackLayout);
    //         mSetRightOut.start();
    //         mSetLeftIn.start();
    //         mIsBackVisible = true;
    //     } else {
    //         mSetRightOut.setTarget(mCardBackLayout);
    //         mSetLeftIn.setTarget(mCardFrontLayout);
    //         mSetRightOut.start();
    //         mSetLeftIn.start();
    //         mIsBackVisible = false;
    //     }
    // }
}
