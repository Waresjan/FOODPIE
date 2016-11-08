package lanou.foodpie.eat.index;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lanou.foodpie.R;

/**
 * Created by dllo on 16/11/3.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndexViewHolder> {

    private ArrayList<IndexBean.FeedsBean> arrayList;

    public IndexAdapter(Context mContext) {
        this.mContext = mContext;
    }

    private Context mContext ;

    public void setAdapter(ArrayList<IndexBean.FeedsBean> arrayList) {
        this.arrayList = arrayList;
    }


    @Override
    public IndexAdapter.IndexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_index,parent,false);

        IndexViewHolder indexViewHolder = new IndexViewHolder(view);

        return indexViewHolder ;
    }

    @Override
    public void onBindViewHolder(IndexAdapter.IndexViewHolder holder, int position) {

        String url = arrayList.get(position).getBackground();
        Picasso.with(mContext).load(url).into(holder.imageView);


        String Text =arrayList.get(position).getSource();
        String Text2 =arrayList.get(position).getTitle();
        String Text3 =arrayList.get(position).getTail();

        holder.textView1.setText(Text);
        holder.textView2.setText(Text2);
        holder.textView3.setText(Text3);
    }

    @Override
    public int getItemCount() {
        return arrayList ==null ? 0 : arrayList.size();
    }


    public class IndexViewHolder extends RecyclerView.ViewHolder {


        private  TextView textView1;
        private  TextView textView2;
        private  TextView textView3;
        private  ImageView imageView;

        public IndexViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView)itemView.findViewById(R.id.index_tv1);
            textView2 = (TextView)itemView.findViewById(R.id.index_tv2);
            textView3 = (TextView)itemView.findViewById(R.id.index_tv3);
            imageView = (ImageView)itemView.findViewById(R.id.index_iv);
        }
    }



}


