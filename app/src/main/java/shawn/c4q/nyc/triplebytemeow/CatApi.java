package shawn.c4q.nyc.triplebytemeow;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shawn.c4q.nyc.triplebytemeow.model.CatInfo;

/**
 * Created by shawnspeaks on 10/24/17.
 */

public interface CatApi {

    String BASE_URL = "https://chex-triplebyte.herokuapp.com/api/";

    @GET("cats")
    Observable<List<CatInfo>> getCatWithPageNumber(@Query("page") String pageNumber);


}
