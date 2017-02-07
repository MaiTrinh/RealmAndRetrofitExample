package beeiqnamecard.com.htk.modelexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import beeiqnamecard.com.htk.modelexample.model.ListOrgResponse;
import beeiqnamecard.com.htk.modelexample.model.LoginResponse;
import beeiqnamecard.com.htk.modelexample.model.Organization;
import beeiqnamecard.com.htk.modelexample.model.User;
import beeiqnamecard.com.htk.modelexample.serverAPI.APIInterface;
import beeiqnamecard.com.htk.modelexample.serverAPI.ApiRetrofit;
import beeiqnamecard.com.htk.modelexample.unit.ResponseList;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPass;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPass = (EditText) findViewById(R.id.edt_pass);

        btLogin = (Button) findViewById(R.id.bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginRequest();
            }
        });
    }

    void loginRequest() {
        String userName = edtUsername.getText().toString();
        String pass = edtPass.getText().toString();
        loginRequest(userName,pass);
    }

    public void loginRequest(String userName, String pass) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(pass);

        APIInterface apiInterface = ApiRetrofit.initAPIService();
        Call<LoginResponse> call = apiInterface.authenticateLogin(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.errorBody() == null) {

                    if (response.code() == 200) {
                        Log.i("MaiTrinh:onResponse","response.code() ="+ response.code());
                        String token = response.raw().headers("x-access-token").get(0);
                        getListOrganizationsRequest(10,1, token);

                    } else {
                        Log.d("MaiTrinh:loginRequest", "fail");
                    }
                } else {
                    Log.i("MaiTrinh:onResponse", "false login api =");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.i("MaiTrinh:onResponse", "false login api =");
            }
        });
    }

    public void getListOrganizationsRequest(int limit, int page, String token) {

        APIInterface apiInterface = ApiRetrofit.initAPIService();

        Call<ResponseList<ArrayList<Organization>>> listCompanyResponseCall = apiInterface.getListOrganizations(limit, page, token);
        listCompanyResponseCall.enqueue(new Callback<ResponseList<ArrayList<Organization>>>() {
            @Override
            public void onResponse(Call<ResponseList<ArrayList<Organization>>> call, Response<ResponseList<ArrayList<Organization>>> response) {
                if (response.isSuccessful() && response.errorBody() == null) {
                    if (response.code() == 200) {
                        saveOrganizationData(response.body().results);
                    } else {
                        Log.i("MaiTrinh:onResponse", "response.code() =" + response.code());
                    }
                } else {
                    Log.i("MaiTrinh:onResponse", "response.code() =" + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseList<ArrayList<Organization>>> call, Throwable t) {
                Log.i("MaiTrinh:onResponse", t.getMessage() + "--" + t.getCause());
            }
        });

//        listCompanyResponseCall.enqueue(new Callback<ListOrgResponse>() {
//            @Override
//            public void onResponse(Call<ListOrgResponse> call, Response<ListOrgResponse> response) {
//
//                if (response.isSuccessful() && response.errorBody() == null) {
//                    if (response.code() == 200) {
//                        saveOrganizationData(response.body().getListOrg());
//                    } else {
//                        Log.i("MaiTrinh:onResponse", "response.code() =" + response.code());
//                    }
//                } else {
//                    Log.i("MaiTrinh:onResponse", "response.code() =" + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ListOrgResponse> call, Throwable t) {
//                Log.i("MaiTrinh:onResponse", t.getMessage() + "--" + t.getCause());
//            }
//        });
    }

    public void saveOrganizationData(List<Organization> listOrganization) {
        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        for (Organization or : listOrganization) {
            or.setName("test");
            or.save();
        }
        realm.close();
        forward();
    }

    public void forward() {
        Intent intent = new Intent(MainActivity.this, ShowResult.class);
        startActivity(intent);
    }
}
