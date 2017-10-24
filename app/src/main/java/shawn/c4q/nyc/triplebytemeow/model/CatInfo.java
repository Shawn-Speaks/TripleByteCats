package shawn.c4q.nyc.triplebytemeow.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shawnspeaks on 10/24/17.
 */

public class CatInfo {

    private String title;
    private String timestamp;
    @SerializedName("image_url")
    private String imgUrl;
    private String description;


    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }
}
