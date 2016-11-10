package lanou.foodpie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/11/2.
 */
public abstract class BaseAty extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData();
    }

    protected abstract int setLayout();
    protected abstract void initView();
    protected abstract void initData();

    // 简化 findViewById 省去强转的过程
    protected <T extends View>T bindView(int id) {
        return (T)findViewById(id);
    }

    // 方法重载, 指定在哪个 View 里 findViewById
    protected <T extends View> T bindView(View view, int id) {
        return (T)view.findViewById(id);
    }

    // 设置各种点击事件
    protected void setClick(View.OnClickListener onClickListener, View ... views) {
        for (View view : views) {
            view.setOnClickListener(onClickListener);
        }
    }
}