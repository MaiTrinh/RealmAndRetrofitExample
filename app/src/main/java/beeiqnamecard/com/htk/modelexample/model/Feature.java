
package beeiqnamecard.com.htk.modelexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Feature extends RealmObject{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("configurations")
    @Expose
    private RealmList<Configuration> configurations = new RealmList<Configuration>();
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The configurations
     */
    public List<Configuration> getConfigurations() {
        return configurations;
    }

    /**
     * 
     * @param configurations
     *     The configurations
     */
    public void setConfigurations(RealmList<Configuration> configurations) {
        this.configurations = configurations;
    }

    /**
     * 
     * @return
     *     The enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 
     * @param enabled
     *     The enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
