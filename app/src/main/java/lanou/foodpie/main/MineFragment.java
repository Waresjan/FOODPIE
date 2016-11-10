package lanou.foodpie.main;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import lanou.foodpie.R;
import lanou.foodpie.base.BaseFragment;
import lanou.foodpie.login.LoginActivity;
import lanou.foodpie.login.SetUpActivity;

/**
 * Created by dllo on 16/10/31.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
private Button mImageButton;
    private ImageButton imageButton;
    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
   mImageButton =bindView(R.id.btn_login);
   imageButton = bindView(R.id.setup);

        setClick(this,imageButton,mImageButton);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_analyse_default);
//        CircleDrawable drawable = new CircleDrawable(bitmap);
//        iconIV.setImageDrawable(drawable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                Intent intent = new Intent(getActivity(),LoginActivity.class );
                startActivity(intent);
                break;

            case R.id.setup:
                Intent intent1 = new Intent(getActivity(), SetUpActivity.class);
                startActivity(intent1);
                break;



        }


    }
}
