package d3vel0pper.com.myjikanwari.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Space;

import java.util.List;

import d3vel0pper.com.myjikanwari.R;
import d3vel0pper.com.myjikanwari.adapter.SettingListAdapter;
import d3vel0pper.com.myjikanwari.fragment.PrefFragment;
import d3vel0pper.com.myjikanwari.fragment.SettingFragment;

/**
 * Created by D3vel0pper on 2016/09/10.
 */
public class SettingActivity extends AppCompatActivity {

    public Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Setting");
        setSupportActionBar(toolbar);

        getFragmentManager().beginTransaction()
                .replace(R.id.container,new PrefFragment()).commit();
    }

}
