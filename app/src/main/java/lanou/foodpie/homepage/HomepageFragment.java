//package lanou.foodpie.homepage;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.GridView;
//
//import lanou.foodpie.R;
//
///**
// * Created by dllo on 16/10/31.
// */
//public class HomepageFragment extends BaseFragment implements View.OnClickListener {
//    private Button btnSearch;
//    private Button btnCompare;
//    private Button btnScanCompare;
//    private Button btnAnalysis;
//
//    private GridView gridViewSort;
//    private GridView gridViewBrand;
//    private GridView gridViewDrink;
//
////    @Nullable
////    @Override
////    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////        return inflater.inflate(R.layout.fragment_homepage,container,false);
//
//
//
//        @Override
//        protected void initViews() {
//            btnSearch = bindView(R.id.library_btn_search);
//
//            btnAnalysis = bindView(R.id.library_btn_analysis);
//            btnCompare = bindView(R.id.library_btn_compare);
//            btnScanCompare = bindView(R.id.library_btn_scancompare);
//
//            gridViewSort = bindView(R.id.library_grid1_sort);
//            gridViewBrand = bindView(R.id.library_grid2_brand);
//            gridViewDrink = bindView(R.id.library_grid3_drink);
//
//        }
//
//
//
//    @Override
//        protected void initData() {
//            setClick(this, btnSearch, btnAnalysis, btnCompare, btnScanCompare);
//
//            GsonRequest<LibraryBean> gsonRequest = new GsonRequest<LibraryBean>(
//                    LibraryBean.class, UrlValues.LIBRARY_URL,
//                    new Response.Listener<LibraryBean>() {
//                        @Override
//                        public void onResponse(LibraryBean response) {
//
//                            getSortDataAndShow(response);
//
//                            getBrandDataAndShow(response);
//
//                            getDrinkDataAndShow(response);
//                        }
//                    }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    // 访问失败
//                    Log.d("LibraryFragment", "出错啦!");
//                }
//            });
//            VolleySingleton.getInstance().addRequest(gsonRequest);
//        }
//
//        /** 用于获取 食物百科 连锁餐饮 数据并进行铺建 */
//        private void getDrinkDataAndShow(LibraryBean response) {
//            ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList2 =
//                    (ArrayList<LibraryBean.GroupBean.CategoriesBean>)
//                            response.getGroup().get(2).getCategories();
//
//            MyLibraryGvAdapter adapter = new MyLibraryGvAdapter();
//            adapter.setBeanArrayList(beanArrayList2);
//            gridViewDrink.setAdapter(adapter);
//        }
//
//        /** 用于获取 食物百科 热门品牌 数据并进行铺建 */
//        private void getBrandDataAndShow(LibraryBean response) {
//            ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList1 =
//                    (ArrayList<LibraryBean.GroupBean.CategoriesBean>)
//                            response.getGroup().get(1).getCategories();
//
//            MyLibraryGvAdapter adapter = new MyLibraryGvAdapter();
//            adapter.setBeanArrayList(beanArrayList1);
//            gridViewBrand.setAdapter(adapter);
//        }
//
//        /** 用于获取 食物百科 食物分类 数据并进行铺建 */
//        private void getSortDataAndShow(LibraryBean response) {
//            // 访问成功, 第一个 GridView 的内容
//            ArrayList<LibraryBean.GroupBean.CategoriesBean> beanArrayList =
//                    (ArrayList<LibraryBean.GroupBean.CategoriesBean>)
//                            response.getGroup().get(0).getCategories();
//
//            MyLibraryGvAdapter adapter = new MyLibraryGvAdapter();
//            adapter.setBeanArrayList(beanArrayList);
//            gridViewSort.setAdapter(adapter);
//
//        }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//}
//}
