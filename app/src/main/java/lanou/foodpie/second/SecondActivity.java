package lanou.foodpie.second;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import lanou.foodpie.DividerItemDecoration;
import lanou.foodpie.R;
import lanou.foodpie.UrlValues;
import lanou.foodpie.base.BaseAty;
import lanou.foodpie.volly.GsonRequest;
import lanou.foodpie.volly.VolleySingleton;


/**
 * Created by dllo on 16/11/9.
 */
public class SecondActivity extends BaseAty implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ImageButton mImageButton;
    private Button mbtns;
    private Button mbtnm;
    private LinearLayout popLayout;
    private PopupWindow popupWindows;
    private PopupWindow popupWindowm;
    private ListView listView;
    private RecyclerView popRecyclerView;
    private ListView popListView;

    private ArrayAdapter<String>arrayAdapter;
    private ArrayList<Integer> subNameArrayList;
    @Override
    protected int setLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
        mImageButton = bindView(R.id.second_activity_ib);
        mbtns = bindView(R.id.popwindou_sml);
        mbtnm = bindView(R.id.popwindou_big);
        popLayout = bindView(R.id.pop_layout);
        listView = bindView(R.id.second_activity_lv);

        mImageButton.setOnClickListener(this);
        mbtns.setOnClickListener(this);
        mbtnm.setOnClickListener(this);


    }



    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.second_activity_ib:
                Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show();
                finish();
                break;

            case R.id.popwindou_big:
                clickPMMethod();
                Toast.makeText(this, "得到数据了", Toast.LENGTH_SHORT).show();

                break;

            case R.id.popwindou_sml:
                Toast.makeText(this, "点击全部", Toast.LENGTH_SHORT).show();
                break;

            case R.id.second_activity_lv:
                Toast.makeText(this, "点击textview", Toast.LENGTH_SHORT).show();
                break;

            default:
                Log.d("SecondActivity", "出错了");
                break;

        }

    }

//点击全部时调用的方法
    private void clickPSMethod(){

        //点击 全部   显示的pop
        if (popupWindows == null || !popupWindows.isShowing()){
            intiPopupWindowFirstMethod();
        }else {
            popupWindows.dismiss();
        }
//点击  全部   关闭 pop
//        if(popupWindows != null && popupWindows.isShowing()){
//            popupWindows.dismiss();
//        }
    }

    // 点击营养素排序 调用的方法
    private void clickPMMethod(){
        if (popupWindowm == null || !popupWindowm.isShowing()){
            Toast.makeText(this, "pop为空", Toast.LENGTH_SHORT).show();
            initPopupWindowSecondMethod();
        }else {
            Toast.makeText(this, "pop不为空", Toast.LENGTH_SHORT).show();
            popupWindowm.dismiss();

            }
//        //点击关闭营养素排序
//        if (popupWindowm != null && popupWindowm.isShowing()){
//                popupWindowm.dismiss();
//        }
    }

    //点击营养素排序时显示的页面
    private void initPopupWindowSecondMethod() {

        //设置菜单栏的大小
        View view = LayoutInflater.from(SecondActivity.this).inflate(R.layout.pop_window_big,null);
        popupWindowm = new PopupWindow (this);
        popupWindowm.setContentView(view);
        popupWindowm.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindowm.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

//        popupWindowm = new PopupWindow();
//        popupWindowm.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindowm.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);


        popRecyclerView = (RecyclerView)view.findViewById(R.id.pop_window_big);
     //  popupWindowm.setContentView(view);
        PMGsonMethod();

        popupWindowm.showAsDropDown(mbtnm);
    }




    //点击全部后显示的页面
    private void intiPopupWindowFirstMethod() {
        popupWindows = new PopupWindow(
          200,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        View view = LayoutInflater.from(this).inflate(R.layout.pop_window_sml,null);
        popListView = (ListView) findViewById(R.id.pop_window_sml);

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(
                SecondActivity.this,
                R.layout.item_pop_smal,
                R.id.item_pop_small_tv,
                subNameArrayList);
        popListView.setAdapter(arrayAdapter);
        popListView.setOnItemClickListener(this);
        popupWindows.setContentView(view);
        popupWindows.showAsDropDown(mbtns);
    }

    private void PMGsonMethod() {
        GsonRequest<PopMBean>gsonRequest = new GsonRequest<>(
                PopMBean.class, UrlValues.POPMBEAN_URL,
                new Response.Listener<PopMBean>() {
                    @Override
                    public void onResponse(PopMBean response) {

                        Log.d("SecondActivity", "response:" + response);

                        ArrayList<PopMBean.TypesBean> beanArrayList =
                                (ArrayList<PopMBean.TypesBean>) response.getTypes();

                        GridLayoutManager manager = new GridLayoutManager(SecondActivity.this, 3);
                        popRecyclerView.setLayoutManager(manager);

                        MyPopAdapter adapter = new MyPopAdapter();
                        adapter.setBeanArrayList(beanArrayList);
                        popRecyclerView.setAdapter(adapter);

                        popRecyclerView.addItemDecoration(new DividerItemDecoration(
                                SecondActivity.this, LinearLayoutManager.VERTICAL
                        ));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("SecondActivity", "请求失败");
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, subNameArrayList.get(i), Toast.LENGTH_SHORT).show();
    }
}
