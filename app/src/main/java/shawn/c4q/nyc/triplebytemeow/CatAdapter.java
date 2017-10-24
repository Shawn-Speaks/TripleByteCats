package shawn.c4q.nyc.triplebytemeow;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import shawn.c4q.nyc.triplebytemeow.model.CatInfo;

/**
 * Created by shawnspeaks on 10/24/17.
 */

public class CatAdapter extends RecyclerView.Adapter<CatViewholder> {

    private ArrayList<CatInfo> catList;

    public CatAdapter(ArrayList<CatInfo> catList) {
        this.catList = catList;
    }


    @Override
    public CatViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_view_holder, parent, false);
        return new CatViewholder(view);
    }

    @Override
    public void onBindViewHolder(CatViewholder holder, int position) {
        final CatInfo cat = catList.get(holder.getAdapterPosition());
        holder.bind(cat);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public void add(CatInfo cat){
        catList.add(cat);
        notifyDataSetChanged();
    }
}
