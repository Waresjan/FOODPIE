package lanou.foodpie;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import lanou.foodpie.base.BaseAty;
import lanou.foodpie.eat.EatFragment;
import lanou.foodpie.homepage.HomepageFragment;
import lanou.foodpie.main.MineFragment;


public class MainActivity extends BaseAty implements View.OnClickListener {

    private RadioButton tabHomePage,tabEat,tabMine;
    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tabHomePage = (RadioButton) findViewById(R.id.homepage);
        tabEat = (RadioButton) findViewById(R.id.eat);
        tabMine = (RadioButton) findViewById(R.id.mine);

        tabHomePage.setChecked(true);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_view,new HomepageFragment());
        transaction.commit();

        tabHomePage.setOnClickListener(this);
        tabEat.setOnClickListener(this);
        tabMine.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.homepage:
                transaction.replace(R.id.main_view,new HomepageFragment());
                break;
            case R.id.eat:
                transaction.replace(R.id.main_view,new EatFragment());
                break;
            case R.id.mine:
                transaction.replace(R.id.main_view,new MineFragment());
            break;
        }
        transaction.commit();
    }
}
