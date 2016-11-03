package lanou.foodpie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lanou.foodpie.R;

/**
 * Created by dllo on 16/11/1.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (setLayout() == 0){
            return inflater.inflate(R.layout.fragment_null,container,false);
        }

        return inflater.inflate(setLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract int setLayout();
    protected abstract void initData();
    protected abstract void initView();

    // 简化 findViewById 省去强转的过程
    protected <T extends View> T bindView(int id) {
        return (T)getView().findViewById(id);
    }

    // 方法重载, 指定在哪个 View 里 findViewById
    protected <T extends View> T bindView(View view, int id) {
        return (T)view.findViewById(id);
    }

    // 设置各种点击事件
    protected void setClick(View.OnClickListener onClickListener, View ... views){
        for (View view : views) {
            view.setOnClickListener(onClickListener);
        }
    }
}
