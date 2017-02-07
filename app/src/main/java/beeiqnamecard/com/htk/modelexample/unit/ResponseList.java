package beeiqnamecard.com.htk.modelexample.unit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import beeiqnamecard.com.htk.modelexample.model.Metadata;

/**
 * Created by trinh on 07/02/2017.
 */

public class ResponseList<T> {
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("results")
    @Expose
    public T results;
}
