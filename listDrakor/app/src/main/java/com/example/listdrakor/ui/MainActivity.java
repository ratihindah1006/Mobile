package com.example.listdrakor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listdrakor.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements DramaItemClickListener {



    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView DramaRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderpager = findViewById(R.id.slider_pager) ;
        indicator= findViewById(R.id.indicator);
        DramaRV = findViewById(R.id.rv_drama);

        lstSlides = new ArrayList<>() ;
        lstSlides.add(new Slide(R.drawable.slide1,"Start Up"));
        lstSlides.add(new Slide(R.drawable.slide2,"18 Again"));
        lstSlides.add(new Slide(R.drawable.slide3,"Search"));
        lstSlides.add(new Slide(R.drawable.slide4,"Tale of the Nine Tiled"));
        lstSlides.add(new Slide(R.drawable.slide5,"Private Lives"));
        lstSlides.add(new Slide(R.drawable.slide6,"Vagabond"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);

        indicator.setupWithViewPager(sliderpager,true);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(), 4000, 3000);

        List<Drama> lstDrama = new ArrayList<>();
        lstDrama.add(new Drama("18 Again",R.drawable.eighteen_again));
        lstDrama.add(new Drama("Start Up",R.drawable.start_up));
        lstDrama.add(new Drama("Search",R.drawable.search));
        lstDrama.add(new Drama("Vagabond",R.drawable.vagabond));
        lstDrama.add(new Drama("Private Lives",R.drawable.private_lives));
        lstDrama.add(new Drama("More Than Friend",R.drawable.more_than_friend));
        lstDrama.add(new Drama("Tale of The Nine Tiled",R.drawable.tale_of_the_nine_tailed));

        DramaAdapter dramaAdapter = new DramaAdapter(this, lstDrama, this);
        DramaRV.setAdapter(dramaAdapter);
        DramaRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDramaClick(Drama drama, ImageView dramaImageView) {

        //mengirim informasi drama ke detail activity
        Intent intent = new Intent(this,DramaDetailActivity.class);
        intent.putExtra("title", drama.getTitle());
        intent.putExtra("imgURL", drama.getThumbnail());
        startActivity(intent);

        //membuat animasi
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                                    dramaImageView,"sharedName");
        startActivity(intent, options.toBundle());

        //membuat tulisan kita mengklik apa
        Toast.makeText(this,"Membuka : " + drama.getTitle(), Toast.LENGTH_LONG).show();

    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }



}