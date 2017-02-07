
package beeiqnamecard.com.htk.modelexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject{

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("invitedBy")
    @Expose
    private String invitedBy;
    @SerializedName("username")
    @Expose
    private String username;
    private String password;

    @SerializedName("extension")
    @Expose
    private String extension;
    @SerializedName("hasExport")
    @Expose
    private Boolean hasExport;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("new")
    @Expose
    private Boolean _new;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("invitedAt")
    @Expose
    private String invitedAt;

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private String id;



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     *     The user
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     *     The user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     *     The invitedBy
     */
    public String getInvitedBy() {
        return invitedBy;
    }

    /**
     *
     * @param invitedBy
     *     The invitedBy
     */
    public void setInvitedBy(String invitedBy) {
        this.invitedBy = invitedBy;
    }

    /**
     *
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     *
     * @return
     *     The extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     *
     * @param extension
     *     The extension
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     *
     * @return
     *     The hasExport
     */
    public Boolean getHasExport() {
        return hasExport;
    }

    /**
     *
     * @param hasExport
     *     The hasExport
     */
    public void setHasExport(Boolean hasExport) {
        this.hasExport = hasExport;
    }

    /**
     *
     * @return
     *     The role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     *     The role
     */
    public void setRole(String role) {
        this.role = role;
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
     *     The _new
     */
    public Boolean getNew() {
        return _new;
    }

    /**
     *
     * @param _new
     *     The new
     */
    public void setNew(Boolean _new) {
        this._new = _new;
    }

    /**
     *
     * @return
     *     The avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     *     The avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     *     The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     *     The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     *     The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     *     The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     *     The invitedAt
     */
    public String getInvitedAt() {
        return invitedAt;
    }

    /**
     *
     * @param invitedAt
     *     The invitedAt
     */
    public void setInvitedAt(String invitedAt) {
        this.invitedAt = invitedAt;
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

}
