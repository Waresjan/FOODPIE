//package lanou.foodpie.eat.knowledge;
//
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListView;
//
//import com.handmark.pulltorefresh.library.PullToRefreshBase;
//import com.handmark.pulltorefresh.library.PullToRefreshListView;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//
//import lanou.foodpie.R;
//
///**
// * Created by dllo on 16/11/1.
// */
//public class KonwledgeFragment extends Fragment{
//    private KnowledgeAdapter mAdapter;
//    private ArrayList<KnowledgeBean> mArrayList;
//    private PullToRefreshListView knowledge_lv;
//    private DBtools tools;
//    private  int currItem;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_knowledge,container,false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        knowledge_lv = (PullToRefreshListView)view.findViewById(R.id.knowledge_lv);
//        mArrayList = new ArrayList<>();
//        mAdapter = new KnowledgeAdapter(getActivity());
//        mAdapter.setBeanArrayList(mArrayList);
//        knowledge_lv.setAdapter(mAdapter);
//        final String str = "http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10";
//
//        KnowledgeAsyncTask knowledgeAsyncTask = new KnowledgeAsyncTask();
//        knowledgeAsyncTask.execute(str);
//
//
//        tools = new DBtools(getContext());
//        mArrayList = tools.QueryTableknowledgebean();
//
//        //把Pull  listview转换成listview然后add knowledge
//        ListView listview = knowledge_lv.getRefreshableView();
//        knowledge_lv.setMode(PullToRefreshBase.Mode.BOTH);
//        knowledge_lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
//            @Override
//            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
//                mArrayList.clear();
//                KnowledgeAsyncTask knowledgeAsyncTask1 = new KnowledgeAsyncTask();
//                knowledgeAsyncTask1.execute(str);
//            }
//            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
//                KnowledgeAsyncTask knowledgeAsyncTask1 = new KnowledgeAsyncTask();
//                knowledgeAsyncTask1.execute("http://food.boohee.com/fb/v1/feeds/category_feed?page=1&category=3&per=10");
//
//            }
//        });
//
//
//    }
//
//   class KnowledgeAsyncTask extends AsyncTask<String,Integer,ArrayList<KnowledgeBean>> {
//
//
//       @Override
//       protected ArrayList<KnowledgeBean> doInBackground(String... params) {
//           try {
//               URL url = new URL(params[0]);
//
//               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//               if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                   InputStream is = connection.getInputStream();
//                   InputStreamReader reader = new InputStreamReader(is);
//                   BufferedReader bufferdreader = new BufferedReader(reader);
//                   String line = "";
//                   String result = new String();
//
//                   while ((line = bufferdreader.readLine()) != null) {
//                       result += line;
//                   }
//                   bufferdreader.close();
//                   reader.close();
//                   is.close();
//                   connection.disconnect();
//
//                   JSONObject object = new JSONObject(result);
//
//                   if (object.has("fb/v1/feeds/category_feed")) {
//                       JSONArray array = object.getJSONArray("fb/v1/feeds/category_feed");
//                       for (int i = 0; i < array.length(); i++) {
//                           JSONObject object1 = (JSONObject) array.get(i);
//
//                           KnowledgeBean bean = new KnowledgeBean();
//
//                           if (object1.has("title")) {
//                               bean.setTitle(object1.getString("title"));
//                           }
//                           if (object1.has("imgSrc")) {
//                               bean.setImgUrl(object1.getString("imgsrc"));
//                           }
//                           mArrayList.add(bean);
//                         //  tools.insertknowledge(bean);
//                       }
//                   }
//               }
//
//           } catch (MalformedURLException e) {
//               e.printStackTrace();
//           } catch (IOException e) {
//               e.printStackTrace();
//           } catch (JSONException e) {
//               e.printStackTrace();
//           }
//
//           return mArrayList;
//       }
//
//       }
//}
