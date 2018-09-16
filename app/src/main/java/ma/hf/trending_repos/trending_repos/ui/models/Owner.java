package ma.hf.trending_repos.trending_repos.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public class Owner {
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    @SerializedName("login")
    @Expose
    private String ownerName;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
