package d3vel0pper.com.myjikanwari.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
            convertView = mLayoutInflater.inflate(R.layout.items, null);
            holder = new ViewHolder();
            holder.ItemText = (TextView)convertView.findViewById(R.id.item_text);
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
            this.itemList.add("");
        }
    }

    private void assignList(){
        this.itemList = new List<String>() {
            @Override
            public void add(int location, String object) {

            }

            @Override
            public boolean add(String object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends String> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public String get(int location) {
                return null;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<String> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<String> listIterator(int location) {
                return null;
            }

            @Override
            public String remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public String set(int location, String object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<String> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
    }

}
