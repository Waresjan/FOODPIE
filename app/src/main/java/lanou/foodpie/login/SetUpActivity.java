package lanou.foodpie.login;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

import lanou.foodpie.R;
import lanou.foodpie.base.BaseAty;

/**
 * Created by dllo on 16/11/9.
 */
public class SetUpActivity extends BaseAty implements View.OnClickListener {
    private ImageButton button;
    @Override
    protected int setLayout() {
        return R.layout.activity_setup;
    }

    @Override
    protected void initView() {
        button = (ImageButton) findViewById(R.id.setup_fanhui);
        setClick(this,button);
       // button.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.setup_fanhui:
                Intent intent2 = new Intent();
                finish();
                break;
        }
    }
}
