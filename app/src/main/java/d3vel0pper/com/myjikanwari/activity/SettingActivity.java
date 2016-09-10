package d3vel0pper.com.myjikanwari.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;

import d3vel0pper.com.myjikanwari.R;
import d3vel0pper.com.myjikanwari.adapter.SettingListAdapter;

/**
 * Created by D3vel0pper on 2016/09/10.
 */
public class SettingActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Setting");
        setSupportActionBar(toolbar);

        ListView listView = (ListView)findViewById(R.id.listView);
        SettingListAdapter adapter = new SettingListAdapter(this);
        listView.setAdapter(adapter);

    }
}
