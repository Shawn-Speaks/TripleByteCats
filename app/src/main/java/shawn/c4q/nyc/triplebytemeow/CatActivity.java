package shawn.c4q.nyc.triplebytemeow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import shawn.c4q.nyc.triplebytemeow.model.CatInfo;

public class CatActivity extends AppCompatActivity {

    RecyclerView catRecycler;
    int pageNumber = 0;
    CatAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);
        catRecycler = (RecyclerView) findViewById(R.id.cat_recycler);
        adapter = new CatAdapter(new ArrayList<CatInfo>());
        catRecycler.setLayoutManager(new LinearLayoutManager(this));
        catRecycler.setAdapter(adapter);

        CatApi service = RestClient.getInstance();
        Observable<List<CatInfo>> observable = service.getCatWithPageNumber(String.valueOf(pageNumber));
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this::success, this::error);


    }

    private void error(Throwable throwable) {
        Toast.makeText(this, "ERROR LOADING CATS :(", Toast.LENGTH_SHORT).show();
    }

    private void success(List<CatInfo> catInfos) {
        for(CatInfo cat: catInfos){
            adapter.add(cat);
        }
    }
}
