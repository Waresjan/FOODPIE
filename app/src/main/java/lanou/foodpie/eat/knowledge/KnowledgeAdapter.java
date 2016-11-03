package lanou.foodpie.eat.knowledge;


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
 * Created by dllo on 16/11/3.
 */
public class KnowledgeAdapter extends BaseAdapter{
    private ArrayList<KnowledgeBean.FeedsBean> beanArrayList;


    public void setBeanArrayList(ArrayList<KnowledgeBean.FeedsBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
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
      KnViewHolder knViewHolder = null;
        if(view == null){
       view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.item_knowledge,viewGroup,false);

            knViewHolder = new KnViewHolder(view);
            view.setTag(knViewHolder);

        }else {
            knViewHolder = (KnViewHolder) view.getTag();

        }
        List<String> urls = beanArrayList.get(i).getImages();
        String Text = beanArrayList.get(i).getTitle();
        String Text2 = beanArrayList.get(i).getSource();
        String Text3 = beanArrayList.get(i).getTail();

        if (urls != null){

       Picasso.with(viewGroup.getContext()).load(urls.get(0)).into(knViewHolder.imageView1);
        }


        knViewHolder.textView1.setText(Text);
        knViewHolder.textView2.setText(Text2);
        knViewHolder.textView3.setText(Text3);
        return view;
    }


    private class KnViewHolder {

        private  TextView textView1;
        private  TextView textView2;
        private  TextView textView3;
        private  ImageView imageView1;


        public KnViewHolder(View view) {

            textView1 = (TextView)view.findViewById(R.id.knowledge_item_tv);
            textView2 = (TextView)view.findViewById(R.id.knowledge_item_tvs);
            textView3 = (TextView)view.findViewById(R.id.knowledge_item_tvss);
            imageView1 = (ImageView)view.findViewById(R.id.knowledge_item_iv);


        }
    }
}
