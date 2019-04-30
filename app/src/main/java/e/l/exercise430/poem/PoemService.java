package e.l.exercise430.poem;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public interface PoemService {

    @POST("getTangPoetry ")
    Call<PoemBean> getsrc(@QueryMap Map<String,Integer> map);
}
