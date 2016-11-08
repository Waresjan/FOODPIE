package lanou.foodpie.eat.delicacy;

import android.util.Log;
import android.widget.ListView;

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
public class DelicacyFragment extends BaseFragment {

    private ListView listView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_delicacy;
    }

    @Override
    protected void initData() {

        GsonRequest<DelecacyBean>gsonRequest =new GsonRequest<DelecacyBean>(
                DelecacyBean.class, UrlValues.DELICACY_URL,
                new Response.Listener<DelecacyBean>() {
                    @Override
                    public void onResponse(DelecacyBean response) {
                        getImageView(response);
                    }


                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DelicacyFragment", "出现错误");
            }
        }
        );

        VolleySingleton.getInstance().addRequest(gsonRequest);
    }

    private void getImageView(DelecacyBean response){
        ArrayList<DelecacyBean.FeedsBean>arrayList =
                (ArrayList<DelecacyBean.FeedsBean>)response.getFeeds();

        DelecacyAdapter adapter = new DelecacyAdapter();
        adapter.setBeanArrayList(arrayList);
        listView.setAdapter(adapter);

    }

    @Override
    protected void initView() {
        listView = bindView(R.id.delicacy_lv);

    }
}
