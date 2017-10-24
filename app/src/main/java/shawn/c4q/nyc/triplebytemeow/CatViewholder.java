package shawn.c4q.nyc.triplebytemeow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import shawn.c4q.nyc.triplebytemeow.model.CatInfo;

/**
 * Created by shawnspeaks on 10/24/17.
 */

public class CatViewholder extends RecyclerView.ViewHolder {

    private TextView timeStampTv;
    private ImageView catIv;
    private TextView catNameTv;
    private TextView catDescriptionTv;
    private Context context;

    public CatViewholder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        timeStampTv = (TextView) itemView.findViewById(R.id.cat_timestamp_tv);
        catIv = (ImageView) itemView.findViewById(R.id.cat_iv);
        catNameTv = (TextView) itemView.findViewById(R.id.cat_name_tv);
        catDescriptionTv = (TextView) itemView.findViewById(R.id.cat_description_tv);
    }

    public void bind(final CatInfo cat){
        Glide.with(context).load(cat.getImgUrl()).into(catIv);
        timeStampTv.setText(cat.getTimestamp());
        catNameTv.setText(cat.getTitle());
        catDescriptionTv.setText(cat.getDescription());
    }


}
