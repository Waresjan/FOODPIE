package lanou.foodpie.eat.index;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
public class IndexFragment extends BaseFragment {

    private RecyclerView recyclerView2;

    @Override
    protected int setLayout() {
        return R.layout.fragment_index;
    }

    @Override
    protected void initView() {
        recyclerView2 = bindView(R.id.index_recyclerview);
    }
    @Override
    protected void initData() {
        GsonRequest<IndexBean>gsonRequest = new GsonRequest<IndexBean>(
                IndexBean.class, UrlValues.INDEX_URL,
                new Response.Listener<IndexBean>() {
                    @Override
                    public void onResponse(IndexBean response) {
                        getRecyclerView(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("IndexFragment", "请求失败");
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);


    }
private void getRecyclerView(IndexBean response){
    ArrayList<IndexBean.FeedsBean>arrayList =
            (ArrayList<IndexBean.FeedsBean>)response.getFeeds();

    IndexAdapter adapter = new IndexAdapter(getActivity());
    adapter.setAdapter(arrayList);
    recyclerView2.setAdapter(adapter);

    LinearLayoutManager manager = new LinearLayoutManager(getActivity());
    recyclerView2.setLayoutManager(manager);
//    StaggeredGridLayoutManager manager =
//            new StaggeredGridLayoutManager
//                    (1,StaggeredGridLayoutManager.VERTICAL);
//    recyclerView.setLayoutManager(manager);

}

}
