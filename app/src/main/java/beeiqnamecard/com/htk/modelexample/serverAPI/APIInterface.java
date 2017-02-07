package beeiqnamecard.com.htk.modelexample.serverAPI;

/**
 * Created by nguyen on 27/07/2016.
 */


import java.util.ArrayList;
import java.util.Map;

import beeiqnamecard.com.htk.modelexample.model.ListOrgResponse;
import beeiqnamecard.com.htk.modelexample.model.Login;

import beeiqnamecard.com.htk.modelexample.model.LoginResponse;
import beeiqnamecard.com.htk.modelexample.model.Organization;
import beeiqnamecard.com.htk.modelexample.model.User;
import beeiqnamecard.com.htk.modelexample.unit.ResponseList;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIInterface {

    // TODO AUTHOR
    @POST("https://beeiq.co/login")
    Call<LoginResponse> authenticateLogin(@Body User user);

    // TODO UPDATE PROFILE
    @PUT("https://beeiq.co/api/v1/users/me/")
    Call<User> updateProfile(@Header("x-access-token") String token, @Body User user);

    // TODO GET LIST ORGANIZATION
    @GET("https://beeiq.co/api/v1/organizations/")
    Call<ResponseList<ArrayList<Organization>>> getListOrganizations(@Query("limit") int limitNumber,
                                                                                    @Query("page") int pageNumber,
                                                                                    @Header("x-access-token") String token);

}