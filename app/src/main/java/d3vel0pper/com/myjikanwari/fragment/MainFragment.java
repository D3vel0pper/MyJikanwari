package d3vel0pper.com.myjikanwari.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import d3vel0pper.com.myjikanwari.R;
import d3vel0pper.com.myjikanwari.adapter.ItemAdapter;

/**
 * Created by D3vel0pper on 2016/09/26.
 */
public class MainFragment extends Fragment {

    private static MainFragment instance;

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
