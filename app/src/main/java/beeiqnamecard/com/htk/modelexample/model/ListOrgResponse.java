
package beeiqnamecard.com.htk.modelexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListOrgResponse {

    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("results")
    @Expose
    private List<Organization> listOrg = new ArrayList<Organization>();

    /**
     * @return The metadata
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * @param metadata The metadata
     */
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    /**
     * @return The listOrg
     */
    public List<Organization> getListOrg() {
        return listOrg;
    }

    /**
     * @param listOrg The listOrg
     */
    public void setListOrg(List<Organization> listOrg) {
        this.listOrg = listOrg;
    }

}
