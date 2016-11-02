package lanou.foodpie.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by dllo on 16/11/1.
 */
public abstract class BaseFragment extends Fragment {


    @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initData();
        initView();
    }
    protected abstract int setLayout();
    protected abstract void initData();
    protected abstract void initView();

}
