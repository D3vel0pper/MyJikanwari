package d3vel0pper.com.myjikanwari.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import d3vel0pper.com.myjikanwari.R;

/**
 * Created by D3vel0pper on 2016/09/18.
 */
public class PrefFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{

    private Context context;

    public PrefFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
        context = getActivity().getBaseContext();
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences preferences,String key){
        Log.d("PreferenceManage","key = " + key + "changed to"
                + PreferenceManager.getDefaultSharedPreferences(context).getString(key,"default"));
    }

}
