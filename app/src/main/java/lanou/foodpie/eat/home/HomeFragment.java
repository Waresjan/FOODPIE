package lanou.foodpie.eat.home;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import lanou.foodpie.R;
import lanou.foodpie.UrlValues;
import lanou.foodpie.base.BaseFragment;
import lanou.foodpie.volly.GsonRequest;
import lanou.foodpie.volly.VolleySingleton;

/**
 * Created by dllo on 16/10/31.
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView recyclerView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.home_rv);

    }
    @Override
    protected void initData() {
        GsonRequest<HomeBean>gsonRequest= new GsonRequest<HomeBean>(
                HomeBean.class, UrlValues.HOME_URL,
                new Response.Listener<HomeBean>() {
                    @Override
                    public void onResponse(HomeBean response) {

                        getRecyclerView(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HomeFragment", "出错了");
            }
        }
        );

        VolleySingleton.getInstance().addRequest(gsonRequest);
    }
private void getRecyclerView(HomeBean response){
    ArrayList<HomeBean.FeedsBean>arrayList =
            (ArrayList<HomeBean.FeedsBean>)response.getFeeds();
    HomeAdapter adapter = new HomeAdapter(getActivity());
    adapter.setAdapter(arrayList);
    recyclerView.setAdapter(adapter);

    StaggeredGridLayoutManager manager =
            new StaggeredGridLayoutManager
                    (2,StaggeredGridLayoutManager.VERTICAL);
    recyclerView.setLayoutManager(manager);

          //  添加分割线
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.LayoutManager));


}

}
