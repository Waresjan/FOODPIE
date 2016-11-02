//package lanou.foodpie.eat.knowledge;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//import lanou.foodpie.R;
//
///**
// * Created by dllo on 16/11/1.
// */
//public class KnowledgeAdapter extends BaseAdapter{
//
//
//    private ArrayList<KnowledgeBean> beanArrayList;
//
//    public KnowledgeAdapter(Context mcontext) {
//        this.mcontext = mcontext;
//    }
//
//    Context mcontext;
//
//    public void setmBeanArrayList(ArrayList<KnowledgeBean> mBeanArrayList) {
//        this.mBeanArrayList = mBeanArrayList;
//    }
//
//    ArrayList<KnowledgeBean>mBeanArrayList;
//
//    @Override
//    public int getCount() {
//        return mBeanArrayList == null ? 0 : mBeanArrayList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mBeanArrayList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//       MyViewHolder viewHolder = null;
//        if(convertView == null){
//            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_knowledge,parent,false);
//            viewHolder = new MyViewHolder(convertView);
//            convertView.setTag(viewHolder);
//
//        }else {
//            viewHolder = (MyViewHolder)convertView.getTag();
//
//        }
//        viewHolder.tv.setText(mBeanArrayList.get(position).getTitle());
//        Picasso.with(mcontext).load(mBeanArrayList.get(position).getImgUrl()).into(viewHolder.iv);
//
//        return convertView;
//    }
//
//    public void setBeanArrayList(ArrayList<KnowledgeBean> beanArrayList) {
//        this.beanArrayList = beanArrayList;
//    }
//
//    private class MyViewHolder {
//        private  TextView tv;
//        private  ImageView iv;
//
//        public  MyViewHolder(View convertView){
//            iv = (ImageView)convertView.findViewById(R.id.item_iv);
//            tv = (TextView)convertView.findViewById(R.id.item_tv);
//        }
//    }
//}
