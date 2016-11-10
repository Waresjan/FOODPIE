package lanou.foodpie.login;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import lanou.foodpie.R;
import lanou.foodpie.base.BaseAty;


/**
 * Created by dllo on 16/11/8.
 */
public class LoginActivity extends BaseAty implements View.OnClickListener {
    private ImageView imageView ;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
//        imageButton = (Button) findViewById(R.id.btnfanhui);
//        imageButton.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.btnfanhui);
        imageView.setOnClickListener(this);


    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        manager =getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.btnfanhui:
                Intent intent = new Intent();
                finish();
             //transaction.replace(R.id.btnfanhui,new MineFragment());

               // FragmentTransaction hide = transaction.add(R.id.btnfanhui, MineFragment.class);
                break;
//                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                intent.putExtra("id",1);
//                startActivities(intent);


        }
        transaction.commit();
    }
}
