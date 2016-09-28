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
import java.util.Iterator;
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

        setUpFragment(view);

        return view;
    }

    private void setUpFragment(View view){
        TextView testText = (TextView)view.findViewById(R.id.testText);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        Set<String> testString = preferences.getStringSet("dayofweek",null);
        String data = "dayofweek = {" ;
        //set will returns numbers -> {sunday -> 0, monday -> 1,tuesday -> 2 .....}
        //Also value of ListPreference shows numbers -> {just started -> 0, 5min -> 1, 10min -> 2 .....}
        if(testString.size() != 0) {
            Iterator iterator = testString.iterator();
            while(iterator.hasNext()) {
                switch(iterator.next().toString()){
                    case "0":
                        data += "sunday";
                        break;
                    case "1":
                        data += "monday";
                        break;
                    case "2":
                        data += "tuesday";
                        break;
                    case "3":
                        data += "wednesday";
                        break;
                    case "4":
                        data += "thursday";
                        break;
                    case "5":
                        data += "friday";
                        break;
                    case "6":
                        data += "saturday";
                        break;
                }
                data += " , ";
            }
        } else {
            data = data + "no-data";
        }
        switch(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("notifier_time","default")){
            case "0":
                data += "}\nnotifier_time = {just started";
                break;
            case "5":
                data += "}\nnotifier_time = {5min";
                break;
            case "10":
                data += "}\nnotifier_time = {10min";
                break;
            case "20":
                data += "}\nnotifier_time = {20min";
                break;
            case "30":
                data += "}\nnotifier_time = {30min";
                break;
        }
//        data = data + "}\nnotifier_time = {" + PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("notifier_time","default");
        data += "}\nnumber_periods = {" + PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("number_periods","default") + "}";
        testText.setText(data);

        GridView gridView = (GridView)view.findViewById(R.id.item_grid);
        //if u want to use 5 columns u should set numColumns
//        gridView.setNumColumns(Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("number_periods","7")));
        gridView.setNumColumns(testString.size());
        try{
            gridView.setAdapter(new ItemAdapter(getActivity()));
        } catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        View view = getActivity().findViewById(R.id.container);
        setUpFragment(view);
    }

}
