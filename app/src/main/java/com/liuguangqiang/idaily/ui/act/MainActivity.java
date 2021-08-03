package com.liuguangqiang.idaily.ui.act;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.liuguangqiang.idaily.R;
import com.liuguangqiang.idaily.databinding.ActivityMainBinding;
import com.liuguangqiang.idaily.domain.RetrofitClient;
import com.liuguangqiang.idaily.domain.entity.BaseEntity;
import com.liuguangqiang.idaily.domain.entity.Daily;
import com.liuguangqiang.idaily.domain.entity.Story;
import com.liuguangqiang.idaily.domain.service.DailyService;
import com.liuguangqiang.idaily.domain.service.StoryService;
import com.liuguangqiang.idaily.ui.adapter.StoriesAdapter;
import com.liuguangqiang.idaily.ui.adapter.StoryAdapter;
import com.liuguangqiang.idaily.ui.adapter.page.TopStoryAdapter;
import com.liuguangqiang.idaily.ui.model.MainModel;
import com.liuguangqiang.idaily.ui.viewmodel.MainViewModel;
import com.liuguangqiang.idaily.utils.events.TopStoriesEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

//    private CollapsingToolbarLayout collapsingToolbar;
//    private TopStoryAdapter topStoryAdapter;
    private List<Story> topStories = new ArrayList<>();

    private ActivityMainBinding binding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel = new MainViewModel(getApplication());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
//        if (!EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().register(this);
//        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().unregister(this);
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                binding.drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private StoriesAdapter adapter;

    private void initToolbar() {
//        setSupportActionBar(binding.toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_menu);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        collapsingToolbar = binding.collapsingToolbar;
//        collapsingToolbar.setTitle(getString(R.string.app_name));
//        collapsingToolbar.setExpandedTitleColor(Color.WHITE);
//        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
//        collapsingToolbar.setExpandedTitleTextAppearance(R.style.CollapsingToolbarTitle);
    }

    private void initViews() {
        adapter = new StoriesAdapter(new ArrayList<>());
        binding.rvNews.setLayoutManager(new LinearLayoutManager(this));
        binding.rvNews.setAdapter(adapter);
        mainViewModel.getLiveData().observe(this, new Observer<List<BaseEntity>>() {
            @Override
            public void onChanged(List<BaseEntity> baseEntities) {
                Timber.d("list onChanged:"+baseEntities.size());
                adapter.setList(baseEntities);
//                adapter.notifyDataSetChanged();
            }
        });
        mainViewModel.getStories();


//        topStoryAdapter = new TopStoryAdapter(getSupportFragmentManager(), topStories);
//        binding.viewPager.setAdapter(topStoryAdapter);
//        binding.indicator.setViewPager(binding.viewPager);
//        binding.indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                collapsingToolbar.setTitle(topStories.get(position).getTitle());
//                setTitle(topStories.get(position).getTitle());
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        binding.rvNews.setAdapter(mainViewModel.getStories(););
    }

    @Subscribe
    public void onEvent(TopStoriesEvent event) {
//        if (event.stories != null) {
//            topStories.addAll(event.stories);
//            topStoryAdapter.notifyDataSetChanged();
//            collapsingToolbar.setTitle(topStories.get(0).getTitle());
//        }
    }

}
