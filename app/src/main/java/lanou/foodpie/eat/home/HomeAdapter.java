package lanou.foodpie.eat.home;

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
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private ArrayList<HomeBean.FeedsBean> arrayList;
   private Context mContext;

    public void setAdapter(ArrayList<HomeBean.FeedsBean> arrayList) {
        this.arrayList =arrayList;
    }

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
    }




    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {


        String url1 = arrayList.get(position).getPublisher_avatar();
        String url2 = arrayList.get(position).getCard_image();


        Picasso.with(mContext).load(url2).into(holder.imageView1);
        Picasso.with(mContext).load(url1).into(holder.imageView2);



        String Text1 = arrayList.get(position).getTitle();
        String Text2 = arrayList.get(position).getPublisher();
        int Text3 = arrayList.get(position).getItem_id();

        holder.textView1.setText(Text1);
        holder.textView2.setText(Text2);
//       holder.textView3.setText(Text3);

    }




    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }


    public class HomeViewHolder extends RecyclerView.ViewHolder {

        private  ImageView imageView1;
        private  ImageView imageView2;
        private  TextView textView1;
        private  TextView textView2;
        private  TextView textView3;

        public HomeViewHolder(View itemView) {
            super(itemView);
            imageView1 = (ImageView)itemView.findViewById(R.id.home_item_ivx);
            imageView2 = (ImageView)itemView.findViewById(R.id.home_item_ivs);
            textView1 = (TextView)itemView.findViewById(R.id.home_item_tvx);
            textView2 = (TextView)itemView.findViewById(R.id.home_item_tvm);
            textView3 = (TextView)itemView.findViewById(R.id.home_item_tvs);
        }
    }
}
