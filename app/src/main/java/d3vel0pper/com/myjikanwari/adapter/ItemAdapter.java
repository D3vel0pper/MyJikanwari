package d3vel0pper.com.myjikanwari.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import d3vel0pper.com.myjikanwari.R;

/**
 * Created by D3vel0pper on 2016/09/04.
 */
public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private final String[] itemStrings = {"first","second","three","four","five","six","seven"};
    private List<String> itemList;

    private static class ViewHolder {
        public TextView ItemText;
    }

    public ItemAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        makeList();
    }

    public int getCount() {
        return itemList.size();
    }

    public Object getItem(int position) {
        return itemList.size();
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.top_item, null);
            holder = new ViewHolder();
            holder.ItemText = (TextView)convertView.findViewById(R.id.top_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.ItemText.setText(this.itemList.get(position));
        return convertView;
    }

    private void makeList(){
        assignList();
        for(int i= 0;i < 42;i++){
            this.itemList.add("-");
        }
    }

    private void assignList(){
        this.itemList = new ArrayList<String>();
    }

}
