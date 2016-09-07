package d3vel0pper.com.myjikanwari.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import d3vel0pper.com.myjikanwari.R;

/**
 * Created by D3vel0pper on 2016/09/04.
 */
public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private String[] itemStrings = {"first","second","three","four","five","six","seven"};

    private static class ViewHolder {
        public TextView ItemText;
    }

    public ItemAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return itemStrings.length;
    }

    public Object getItem(int position) {
        return itemStrings[position];
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.items, null);
            holder = new ViewHolder();
            holder.ItemText = (TextView)convertView.findViewById(R.id.item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.ItemText.setText(itemStrings[position]);
        return convertView;
    }

}
