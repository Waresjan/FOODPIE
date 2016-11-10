package lanou.foodpie.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import lanou.foodpie.volly.VolleySingleton;

/**
 * 通用的 ViewHolder
 * 方法功能: 设置文字, 设置图片, 设置圆形图片
 */

public class CommonViewHolder extends RecyclerView.ViewHolder{
    // SparseArray 用法和HashMap 相似
    // 但是 Key 固定是 int 类型
    // 用他来存放所有的 View , key 就是 View 的 id

    private SparseArray<View> views;
    private View itemView; // 行布局

    public CommonViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;
        views = new SparseArray<>();
    }

    /**
     * 通过View的id来获得指定的View
     * 如果该View没有赋值,就先执行findViewById
     * 然后把它放到View的集合里
     * 使用泛型来取消强转
     * @param id
     * @return 指定 View
     */
    public<T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            // 证明 SparseArray 里没有这个 View
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    /** 专门给 ListView 使用的方法 */
    public static CommonViewHolder getViewHolder(View itemView, ViewGroup parent, int layoutItemId) {
        CommonViewHolder commonVH;
        if (itemView == null) {
            Context context = parent.getContext();
            itemView = LayoutInflater.from(context).inflate(layoutItemId, parent, false);
            commonVH = new CommonViewHolder(itemView);
            itemView.setTag(commonVH);
        } else {
            commonVH = (CommonViewHolder) itemView.getTag();
        }
        return commonVH;
    }

    /** 构造方法的重载, 专门给 RecyclerView 的Adapter 使用的方法 */
    public static CommonViewHolder getViewHolder(ViewGroup parent, int layoutItemId) {
        return getViewHolder(null, parent, layoutItemId);
    }

    /** 返回(获取)行布局 */
    public View getItemView() {
        return itemView;
    }


    /*** ViewHolder 设置数据的方法 */
    // 设置文字
    public CommonViewHolder setText(int id, String text) {
        TextView textView = getView(id);
        textView.setText(text);

        return this;
    }

    /** 设置图片, 图片是 mipmap里的 */
    public CommonViewHolder setImage(int imageViewId, int imgId) {
        ImageView imageView = getView(imageViewId);
        imageView.setImageResource(imgId);

        return this;
    }

    /** 设置图片, 图片需要网络请求 */
    public CommonViewHolder setImage(int imageViewId, String imgUrl) {
        ImageView imageView = getView(imageViewId);
        // Picasso 这种写法不行, 应用时出错
//        Picasso.with(MyApp.getContext()).load(imgUrl);
        VolleySingleton.getInstance().getImage(imgUrl, imageView);
        return this;
    }

    /** 显示圆形图片 */
    public CommonViewHolder setCircleImage(final int imageViewId, String imgUrl) {

        ImageView imageView = getView(imageViewId);
        VolleySingleton.getInstance().getImage(imgUrl,imageView);

        return this;
    }

    /** 设置 View 的点击事件 */
    public CommonViewHolder setViewClick(int id, View.OnClickListener onClickListener) {
        getView(id).setOnClickListener(onClickListener);

        return this;
    }

    /** 为行布局设置点击事件 */
    public CommonViewHolder setItemClick (View.OnClickListener onClickListener) {
        itemView.setOnClickListener(onClickListener);

        return this;
    }

}
