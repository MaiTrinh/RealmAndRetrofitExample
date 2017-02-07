package beeiqnamecard.com.htk.modelexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import beeiqnamecard.com.htk.modelexample.model.Organization;
import io.realm.Realm;
import io.realm.RealmResults;

public class ShowResult extends AppCompatActivity {

    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);

        tvCount = (TextView) findViewById(R.id.tv_count);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Organization> realmResults = realm.where(Organization.class).findAll();
        tvCount.setText("total organization : " + realmResults.size());
    }
}
