package ma.hf.trending_repos.trending_repos.ui.ui.views;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import ma.hf.trending_repos.trending_repos.R;
import ma.hf.trending_repos.trending_repos.ui.models.Repository;
import ma.hf.trending_repos.trending_repos.ui.utils.Util;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public class RepositoryView extends FrameLayout{

    private TextView mRepositoryNameTV,mRepositoryDescriptionTV, mOwnerNameTV, mStarNaumberTV;
    private ImageView mOwnerAvatarIV;

    private Context mContext;


    public RepositoryView(@NonNull Context context) {
        super(context);
        mContext = context;
        initViews();
    }

    public RepositoryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initViews();
    }

    public RepositoryView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initViews();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RepositoryView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mContext = context;
        initViews();
    }

    private void initViews() {
        inflate(getContext(), R.layout.view_repository, this);
        mRepositoryNameTV = findViewById(R.id.repos_name_TV);
        mRepositoryDescriptionTV = findViewById(R.id.repos_description_TV);
        mOwnerAvatarIV = findViewById(R.id.owner_avatar_IV);
        mOwnerNameTV = findViewById(R.id.owner_name_TV);
        mStarNaumberTV = findViewById(R.id.stars_number_TV);
    }

    public void fillData(Repository repository){
        mRepositoryNameTV.setText(repository.getRepositoryName());
        mRepositoryDescriptionTV.setText(repository.getRepositoryDescritpion());
        Picasso.with(mContext).load(repository.getOwner().getAvatarUrl()).into(mOwnerAvatarIV);
        mOwnerNameTV.setText(repository.getOwner().getOwnerName());
        mStarNaumberTV.setText(Util.formatStarNumbers(repository.getStarstNumber())+"K");
    }

}

