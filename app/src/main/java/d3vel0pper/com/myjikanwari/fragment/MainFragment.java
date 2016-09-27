package d3vel0pper.com.myjikanwari.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

import d3vel0pper.com.myjikanwari.R;
import d3vel0pper.com.myjikanwari.activity.MainActivity;
import d3vel0pper.com.myjikanwari.adapter.ItemAdapter;

/**
 * Created by D3vel0pper on 2016/09/26.
 */
public class MainFragment extends Fragment {

    private static MainFragment instance;
//    private MainActivity parent;

    public static MainFragment getInstance(){
        if(instance == null){
            return new MainFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main,container,false);

        TextView testText = (TextView)view.findViewById(R.id.testText);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Set<String> testString = preferences.getStringSet("dayofweek",null);
//        PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("dayofweek","");
//        PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("notifier_time","default");
//        PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("number_periods","default");
        String data = "dayofweek = {" ;
        if(testString.size() != 0) {
            for (int i = 0; i < testString.size(); i++) {
                data = data + testString.toString();
            }
        } else {
            data = data + "no-data";
        }
        data = data + "}\nnotifier_time = {" + PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("notifier_time","default")
                + "}\nnumber_periods = {" + PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("number_periods","default") + "}";
        testText.setText(data);

        GridView gridView = (GridView)view.findViewById(R.id.item_grid);
        //if u want to use 5 columns u should set numColumns
//        gridView.setNumColumns(5);
        try{
            gridView.setAdapter(new ItemAdapter(getActivity()));
        } catch(NullPointerException e){
            e.printStackTrace();
        }

        return view;
    }
}
