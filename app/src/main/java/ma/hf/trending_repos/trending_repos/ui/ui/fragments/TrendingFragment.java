package ma.hf.trending_repos.trending_repos.ui.ui.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ma.hf.trending_repos.trending_repos.R;
import ma.hf.trending_repos.trending_repos.ui.managers.WSManager;
import ma.hf.trending_repos.trending_repos.ui.models.GithubResponse;
import ma.hf.trending_repos.trending_repos.ui.models.Repository;
import ma.hf.trending_repos.trending_repos.ui.ui.adapters.RepositoryRecycleViewAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TrendingFragment extends Fragment {
    private int PAGE_NUMBER = 1;
    private int PAGE_SIZE = 30;
    private RecyclerView mRecyclerView;
    private RepositoryRecycleViewAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private ArrayList<Repository> mRepositories;

    private boolean isLoading = false;

    public TrendingFragment() {
    }

    public static TrendingFragment newInstance() {
        TrendingFragment fragment = new TrendingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trending, container, false);
        initViews(view);
        initListeners();
        loadData();
        return view;
    }

    private void initListeners() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.e("TAG","");
                int visibleItemCount = mLayoutManager.getChildCount();
                int totalItemCount = mLayoutManager.getItemCount();
                int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                Log.e("visibleItemCount",""+visibleItemCount);
                Log.e("totalItemCount",""+totalItemCount);
                Log.e("firstVisibleIP",""+firstVisibleItemPosition);

                if (!isLoading) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0
                            && totalItemCount >= PAGE_SIZE) {
                            loadData();
                    }
                }
            }
        });
    }

    private void initViews(View rootView) {
        mRecyclerView =  rootView.findViewById(R.id.recycle_view);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                RecyclerView.VERTICAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dividerItemDecoration.setDrawable(getActivity().getDrawable(R.drawable.verticale_divider));
        }
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRepositories = new ArrayList<Repository>();
        mAdapter = new RepositoryRecycleViewAdapter(getActivity(), mRepositories);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadData(){
        isLoading = true;
        WSManager.getInstance().getRepositoriesByPage(PAGE_NUMBER++, new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                if (response.body()!=null) {
                    mRepositories.addAll(response.body().getItems());
                    mAdapter.notifyDataSetChanged();
                    Log.e("TAG",mRepositories.size()+"");
                    isLoading = false;
                }
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {
                Log.e("TAG",t.getMessage());
            }
        });
    }
}
