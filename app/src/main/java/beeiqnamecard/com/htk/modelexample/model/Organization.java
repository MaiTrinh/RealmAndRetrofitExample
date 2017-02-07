package beeiqnamecard.com.htk.modelexample.model;

import android.graphics.Color;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by trinh on 07/02/2017.
 */

public class Organization extends RealmObject {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("subdomain")
    @Expose
    private String subdomain;

    @SerializedName("createdBy")
    @Expose
    private String createdBy;

    @SerializedName("customFields")
    @Expose
    private RealmList<CustomField> customFields = new RealmList<CustomField>();

    @SerializedName("features")
    @Expose
    private RealmList<Feature> features = new RealmList<Feature>();

    @SerializedName("users")
    @Expose
    private RealmList<User> users = new RealmList<User>();

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("active")
    @Expose
    private Boolean active;

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;

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
     *     The subdomain
     */
    public String getSubdomain() {
        return subdomain;
    }

    /**
     *
     * @param subdomain
     *     The subdomain
     */
    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    /**
     *
     * @return
     *     The createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy
     *     The createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return
     *     The customFields
     */
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    /**
     *
     * @param customFields
     *     The customFields
     */
    public void setCustomFields(RealmList<CustomField> customFields) {
        this.customFields = customFields;
    }

    /**
     *
     * @return
     *     The features
     */
    public List<Feature> getFeatures() {
        return features;
    }

    /**
     *
     * @param features
     *     The features
     */
    public void setFeatures(RealmList<Feature> features) {
        this.features = features;
    }

    /**
     *
     * @return
     *     The users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     *     The users
     */
    public void setUsers(RealmList<User> users) {
        this.users = users;
    }

    /**
     *
     * @return
     *     The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     *
     * @param logo
     *     The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     *
     * @return
     *     The active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     *
     * @param active
     *     The active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     *
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    public void save() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(this);
        realm.commitTransaction();
    }

    public static Organization findWith(String id) {
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Organization.class).equalTo("id", id).findFirst();
    }
}
