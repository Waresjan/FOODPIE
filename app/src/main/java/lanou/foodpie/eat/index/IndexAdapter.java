package lanou.foodpie.eat.index;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import lanou.foodpie.R;

/**
 * Created by dllo on 16/11/3.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndxViewHolder> {

    private ArrayList<IndexBean.FeedsBean> adapter;

    public IndexAdapter(Context mContext) {
        this.mContext = mContext;
    }

    private Context mContext ;

    public void setAdapter(ArrayList<IndexBean.FeedsBean> adapter) {
        this.adapter = adapter;
    }


    @Override
    public IndexAdapter.IndxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_index,parent,false);
        IndxViewHolder indexViewHolder = new IndxViewHolder(view);

        return indexViewHolder ;
    }

    @Override
    public void onBindViewHolder(IndexAdapter.IndxViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return adapter ==null ? 0 : adapter.size();
    }


    public class IndxViewHolder extends RecyclerView.ViewHolder {


        public IndxViewHolder(View itemView) {
            super(itemView);
            TextView
        }
    }



}


