package ma.hf.trending_repos.trending_repos.ui.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by THINKPAD T450 on 15/09/2018.
 */

public class Repository {

    @SerializedName("name")
    @Expose
    private String repositoryName;

    @SerializedName("description")
    @Expose
    private String repositoryDescritpion;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    @SerializedName("stargazers_count")
    @Expose
    private double starstNumber;

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryDescritpion() {
        return repositoryDescritpion;
    }

    public void setRepositoryDescritpion(String repositoryDescritpion) {
        this.repositoryDescritpion = repositoryDescritpion;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public double getStarstNumber() {
        return starstNumber;
    }

    public void setStarstNumber(double starstNumber) {
        this.starstNumber = starstNumber;
    }
}
