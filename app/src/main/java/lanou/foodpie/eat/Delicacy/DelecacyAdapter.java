package lanou.foodpie.eat.delicacy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import lanou.foodpie.R;

/**
 * Created by dllo on 16/11/4.
 */
public class DelecacyAdapter extends BaseAdapter{

    private ArrayList<DelecacyBean.FeedsBean> beanArrayList;

    public void setBeanArrayList(ArrayList<DelecacyBean.FeedsBean> beanArrayList) {
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
       DelecacyViewHolder viewHolder = null;
if (view == null){
    view = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.item_delicacy,viewGroup,false);

    viewHolder = new DelecacyViewHolder(view);
    view.setTag(viewHolder);
}else {
    viewHolder = (DelecacyViewHolder) view.getTag();
}

        List<String> url = beanArrayList.get(i).getImages();
       

        if (url != null){
            Picasso.with(viewGroup.getContext()).load(url.get(0)).into(viewHolder.imageview);
//        }else {
//            Picasso.with(viewGroup.getContext()).load(url.get(1)).into(viewHolder.imageview);
      }


        String TextX = beanArrayList.get(i).getTitle();
        String TextM = beanArrayList.get(i).getSource();
        String TextS = beanArrayList.get(i).getTail();

        viewHolder.textviewX.setText(TextX);
        viewHolder.textviewM.setText(TextM);
        viewHolder.textviewS.setText(TextS);
        return view;
    }







    private class DelecacyViewHolder {

        private  ImageView imageview;
        private  TextView textviewX;
        private  TextView textviewM;
        private  TextView textviewS;

        public DelecacyViewHolder(View view) {

            imageview = (ImageView)view.findViewById(R.id.delicacy_iv);
            textviewX = (TextView)view.findViewById(R.id.delicacy_tvx);
            textviewM = (TextView)view.findViewById(R.id.delicacy_tvm);
            textviewS = (TextView)view.findViewById(R.id.delicacy_tvs);
        }
    }
}
