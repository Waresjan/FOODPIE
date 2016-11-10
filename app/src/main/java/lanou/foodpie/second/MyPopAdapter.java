package lanou.foodpie.second;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

import lanou.foodpie.R;
import lanou.foodpie.base.CommonViewHolder;

/**
 * Created by dllo on 16/11/10.
 */
public class MyPopAdapter extends RecyclerView.Adapter {

    private ArrayList<PopMBean.TypesBean> beanArrayList;

    public void setBeanArrayList(ArrayList<PopMBean.TypesBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CommonViewHolder commonViewHolder =
                CommonViewHolder.getViewHolder(parent, R.layout.item_pop_big);
        return commonViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
     CommonViewHolder commonViewHolder =
        (CommonViewHolder) holder;
        String name = beanArrayList.get(position).getName();
        commonViewHolder.setText(R.id.item_pop_big_tv,name);

    }

    @Override
    public int getItemCount() {
        return beanArrayList == null ? 0 : beanArrayList.size();
    }


}
