package ma.hf.trending_repos.trending_repos.ui.api;

import java.util.ArrayList;

import ma.hf.trending_repos.trending_repos.ui.models.GithubResponse;
import ma.hf.trending_repos.trending_repos.ui.models.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public interface TrendingInterface {
    @GET("/search/repositories?q=created:%3E2017-10-22&sort=stars&order=desc")
    Call<GithubResponse> getRepositories();

    @GET("/search/repositories?q=created:%3E2017-10-22&sort=stars&order=desc")
    Call<GithubResponse> getRepositoriesByPage(@Query("page") int page);

}
