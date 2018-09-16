package ma.hf.trending_repos.trending_repos.ui.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import ma.hf.trending_repos.trending_repos.ui.models.Repository;
import ma.hf.trending_repos.trending_repos.ui.ui.views.RepositoryView;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public class RepositoryRecycleViewAdapter extends RecyclerView.Adapter<RepositoryRecycleViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Repository> mRepositories;

    public RepositoryRecycleViewAdapter(Context context, ArrayList<Repository> repositories) {
        mContext = context;
        mRepositories = repositories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RepositoryView repositoryView = new RepositoryView(mContext);
        RepositoryRecycleViewAdapter.ViewHolder viewHolder   = new RepositoryRecycleViewAdapter.ViewHolder(repositoryView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        if(position < getItemCount()) {
            Repository repository = mRepositories.get(position);
            viewHolder.fillData(repository);
        }
    }

    @Override
    public int getItemCount() {
        return mRepositories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RepositoryView mRepositoryView;
        public ViewHolder(RepositoryView repositoryView) {
            super(repositoryView);
            mRepositoryView = repositoryView;
        }

        public void fillData(Repository repository) {
            mRepositoryView.fillData(repository);
        }
    }
}
