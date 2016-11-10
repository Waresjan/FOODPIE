package lanou.foodpie;

import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import lanou.foodpie.base.BaseAty;

/**
 * Created by dllo on 16/11/9.
 */
public class StartActivity extends BaseAty implements View.OnClickListener {
 private ImageView mImageView;
    private CountDownTimer timer;

    @Override
    protected int setLayout() {
        return R.layout.acticity_start;
    }

    @Override
    protected void initView() {
    mImageView = bindView(R.id.start_iv);
     setClick(this,mImageView);
    }

    @Override
    protected void initData() {
        timer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {

            }



            @Override
            public void onFinish() {
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_iv:
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                timer.cancel();
                break;

            default:
                Log.d("StartActivity", "失败");
                break;

        }

    }
}
