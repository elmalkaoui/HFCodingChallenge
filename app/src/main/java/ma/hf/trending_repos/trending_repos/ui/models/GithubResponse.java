package ma.hf.trending_repos.trending_repos.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public class GithubResponse {

    @SerializedName("items")
    private ArrayList<Repository> items;

    public ArrayList<Repository> getItems() {
        return items;
    }

    public void setItems(ArrayList<Repository> items) {
        this.items = items;
    }
}
