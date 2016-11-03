package lanou.foodpie.homepage;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import lanou.foodpie.R;
import lanou.foodpie.UrlValues;
import lanou.foodpie.base.BaseFragment;
import lanou.foodpie.volly.GsonRequest;
import lanou.foodpie.volly.VolleySingleton;

/**
 * Created by dllo on 16/11/2.
 */
public class HomepageFragment extends BaseFragment implements View.OnClickListener{

    private Button search;
    private Button analysis;
    private Button compare;
    private Button scancompare;
    private GridView sort;
    private GridView brand;
    private GridView drink;

    @Override
    protected int setLayout() {
    return R.layout.fragment_homepage  ;
    }


    @Override
    protected void initView() {
        search =  bindView(R.id.library_btn_search);
        analysis =  bindView(R.id.library_btn_analysis);
        compare = bindView(R.id.library_btn_compare);
        scancompare = bindView(R.id.library_btn_scancompare);

        sort = bindView(R.id.library_grid1_sort);
        brand = bindView(R.id.library_grid2_brand);
        drink = bindView(R.id.library_grid3_drink);

    }


    @Override
    protected void initData() {

        setClick(this, search, analysis, compare, scancompare);
        GsonRequest<LibraryBean> gsonRequest = new GsonRequest<LibraryBean>(
                LibraryBean.class, UrlValues.LIBRARY_URL,
                new Response.Listener<LibraryBean>() {
                    @Override
                    public void onResponse(LibraryBean response) {
                        getSortDataAndShow(response);
                        getBrandDataAndShow(response);
                        getDrinkDataAndShow(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //访问失败
                Log.d("HomepageFragment", "无法访问");
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);
    }


    /*
    获取食物百科 连锁餐饮 数据并进行浦建
     */
    private void getDrinkDataAndShow(LibraryBean response) {
        ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList2 =
                (ArrayList<LibraryBean.GroupBean.CategoriesBean>)
                        response.getGroup().get(2).getCategories();

        MyLibraryGvAdapter adapter = new MyLibraryGvAdapter();
        adapter.setBeanArrayList(beanArrayList2);
        drink.setAdapter( adapter);
    }
        /* 用于获取 食物百科 热门品牌 数据并进行铺建 */

        private void getBrandDataAndShow(LibraryBean response) {
            ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList1 =
                    (ArrayList<LibraryBean.GroupBean.CategoriesBean>)
                            response.getGroup().get(1).getCategories();

            MyLibraryGvAdapter adapter = new MyLibraryGvAdapter();
            adapter.setBeanArrayList(beanArrayList1);
            brand.setAdapter( adapter);
        }

        /* 用于获取 食物百科 食物分类 数据并进行铺建 */

        private void getSortDataAndShow(LibraryBean response) {
            // 访问成功, 第一个 GridView 的内容
            ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList =
                    (ArrayList<LibraryBean.GroupBean.CategoriesBean>)
                            response.getGroup().get(0).getCategories();

            MyLibraryGvAdapter adapter = new MyLibraryGvAdapter();
            adapter.setBeanArrayList(beanArrayList);
            sort.setAdapter( adapter);

        }


    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }

    }
}
