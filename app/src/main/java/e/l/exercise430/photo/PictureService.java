package e.l.exercise430.photo;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by LiXiuXing on 2019/4/30
 */
public interface PictureService {

    @POST("upload")
    @Headers({"User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0", "Connection: keep-alive"})
    Call<ResponseBody> getimage (@QueryMap Map<String,String> map);

}
