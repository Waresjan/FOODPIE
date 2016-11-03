package lanou.foodpie.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lanou.foodpie.R;

/**
 * Created by dllo on 16/11/2.
 */
public class MyLibraryGvAdapter extends BaseAdapter{
    private ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList;

    public void setBeanArrayList(ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList) {
        this.beanArrayList = beanArrayList;


    }

    @Override
    public int getCount() {
        return beanArrayList == null ? 0 : beanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return beanArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder = null;

        if(view == null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.item_library_gridview,viewGroup,false);

            myViewHolder = new MyViewHolder(view);
            view.setTag(myViewHolder);

        }else {
            myViewHolder = (MyViewHolder) view.getTag();

        }

        String url = beanArrayList.get(i).getImage_url();
        String text = beanArrayList.get(i).getName();

        Picasso.with(viewGroup.getContext()).load(url).into(myViewHolder.imageview);
        myViewHolder.textView.setText(text);
        return view;
    }

    private class MyViewHolder {
        public ImageView imageview;
        private  TextView textView;

        public MyViewHolder(View view) {
            imageview = (ImageView)view.findViewById(R.id.item_library_grid_view_iv);
            textView = (TextView)view.findViewById(R.id.item_library_grid_view_tv);


        }


    }

}
