package e.l.exercise430.poem;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import e.l.exercise430.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public class PoemActivity extends AppCompatActivity implements XRecyclerView.LoadingListener{

    private XRecyclerView poem_xRecyclerView;
    private PoemAdapter adapter;
    private int page = 1;
    private PoemDataBase dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem);
        initView();

        dao = new PoemDataBase(this);

        poem_xRecyclerView.setLoadingListener(this);
        poem_xRecyclerView.setLoadingMoreEnabled(true);
        poem_xRecyclerView.setPullRefreshEnabled(true);

        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(ContentUrl.Base_Url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        Map<String,Integer> map = new HashMap<>();
        map.put("page",page);
        map.put("count",10);

        PoemService service = retrofit.create(PoemService.class);
        Call<PoemBean> call = service.getsrc(map);
        call.enqueue(new Callback<PoemBean>() {
            @Override
            public void onResponse(Call<PoemBean> call, Response<PoemBean> response) {
                List<PoemBean.ResultBean> result = response.body().getResult();
                adapter.refresh(result);
                ContentValues values = new ContentValues();
                for(int i =0;i<result.size();i++){
                    values.put("title",result.get(i).getTitle());
                    values.put("author",result.get(i).getAuthors());
                    values.put("content",result.get(i).getContent());
                    dao.insert(PoemDBHelper.POEM,null,values);
                }
            }

            @Override
            public void onFailure(Call<PoemBean> call, Throwable t) {

            }
        });
    }

    private void initView() {
        poem_xRecyclerView = (XRecyclerView) findViewById(R.id.poem_xRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        poem_xRecyclerView.setLayoutManager(manager);

        adapter = new PoemAdapter();
        poem_xRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {

        poem_xRecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ContentUrl.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String,Integer> map = new HashMap<>();
        map.put("page",page);
        map.put("count",10);

        PoemService service = retrofit.create(PoemService.class);
        Call<PoemBean> call = service.getsrc(map);
        call.enqueue(new Callback<PoemBean>() {
            @Override
            public void onResponse(Call<PoemBean> call, Response<PoemBean> response) {
                List<PoemBean.ResultBean> result = response.body().getResult();
                adapter.refresh(result);
                ContentValues values = new ContentValues();
                for(int i =0;i<result.size();i++){
                    values.put("title",result.get(i).getTitle());
                    values.put("author",result.get(i).getAuthors());
                    values.put("content",result.get(i).getContent());
                    dao.insert(PoemDBHelper.POEM,null,values);
                }
            }

            @Override
            public void onFailure(Call<PoemBean> call, Throwable t) {

            }
        });

        poem_xRecyclerView.loadMoreComplete();

    }
}
