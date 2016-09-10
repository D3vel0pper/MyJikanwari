package d3vel0pper.com.myjikanwari.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import d3vel0pper.com.myjikanwari.R;

/**
 * Created by D3vel0pper on 2016/09/10.
 */
public class SettingListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<View> viewList;

    public SettingListAdapter(Context context){
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        viewList = new ArrayList<>();
    }

    private static class ViewHolder {
        TextView itemText;
        Spinner itemSpinner;
        CheckBox itemCheckbox;
    }

    @Override
    public int getCount(){
        return 0;
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            switch (position){
                case 0:
                    //choose day of week
                    convertView = mLayoutInflater.inflate(R.layout.checkbox_item, null);
                    holder.itemCheckbox = (CheckBox)convertView.findViewById(R.id.item_checkbox);
                    break;
                case 1:
                    //choose number of periods
                    convertView = mLayoutInflater.inflate(R.layout.spinner_item, null);
                    holder.itemSpinner = (Spinner) convertView.findViewById(R.id.item_spinner);
                    break;
                case 2:
                    //choose notifier time
                    convertView = mLayoutInflater.inflate(R.layout.spinner_item, null);
                    holder.itemSpinner = (Spinner)convertView.findViewById(R.id.item_spinner);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        return convertView;
    }
}
