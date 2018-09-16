package ma.hf.trending_repos.trending_repos.ui.ui.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;

import ma.hf.trending_repos.trending_repos.R;
import ma.hf.trending_repos.trending_repos.ui.managers.WSManager;
import ma.hf.trending_repos.trending_repos.ui.models.GithubResponse;
import ma.hf.trending_repos.trending_repos.ui.models.Repository;
import ma.hf.trending_repos.trending_repos.ui.ui.adapters.RepositoryRecycleViewAdapter;
import ma.hf.trending_repos.trending_repos.ui.ui.fragments.SettingFragment;
import ma.hf.trending_repos.trending_repos.ui.ui.fragments.TrendingFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    private TrendingFragment mTrendingFragment;
    private SettingFragment mSettingFragment;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        initViews();
        initFragments();
        initListeners();
        showFragment(mTrendingFragment);

    }

    private void initFragments() {
        mTrendingFragment = mTrendingFragment.newInstance();
        mSettingFragment = mSettingFragment.newInstance();

    }

    private void initViews() {
        mFrameLayout = findViewById(R.id.frame_layout);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
    }

    private void initListeners(){
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.trending_item) {
                    showFragment(mTrendingFragment);
                    return true;
                }else {
                    showFragment(mSettingFragment);
                    return true;
                }
            }
        });
    }

    private void showFragment(android.support.v4.app.Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        WSManager.getInstance().cancelAll();
    }
}
