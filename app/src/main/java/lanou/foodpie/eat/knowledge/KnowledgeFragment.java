package lanou.foodpie.eat.knowledge;

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
 * Created by dllo on 16/11/3.
 */
public class KnowledgeFragment extends BaseFragment {

    private ListView listView;

    @Override
    protected int setLayout() {
        return R.layout.fragment_knowledge;
    }


    @Override
    protected void initView() {
        listView = bindView(R.id.knowledge_lv);
    }


    @Override
    protected void initData() {
        GsonRequest<KnowledgeBean>gsonRequest = new GsonRequest<KnowledgeBean>(
                KnowledgeBean.class, UrlValues.KNOWLEDGE_URL,
                new Response.Listener<KnowledgeBean>() {
                    @Override
                    public void onResponse(KnowledgeBean response) {
                        getImageview(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("KnowledgeFragment", "出错了");
            }
        }
        );
        VolleySingleton.getInstance().addRequest(gsonRequest);

    }
    //得到网络数据
    private void getImageview(KnowledgeBean response){
        ArrayList<KnowledgeBean.FeedsBean>arrayList =
                (ArrayList<KnowledgeBean.FeedsBean>)response.getFeeds();

        KnowledgeAdapter adapter = new KnowledgeAdapter();
        adapter.setBeanArrayList(arrayList);
        listView.setAdapter(adapter);
    }
}
