package com.thomasbrondeau.vpgilt.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class Sale implements Serializable {

    private final static String DIMENS_2544x1344 = "2544x1344";

    @SerializedName("sale_id")
    public int saleId;

    @SerializedName("sale_key")
    public String saleKey;

    @SerializedName("name")
    public String saleName;

    @SerializedName("store")
    public String store;

    @SerializedName("sale_url")
    public String saleUrl;

    @SerializedName("begins")
    public String begins;

    @SerializedName("ends")
    public String ends;

    @SerializedName("description")
    public String description;

    @SerializedName("size")
    public int size;

    // products
    @SerializedName("products")
    public List<String> products;

    // images urls
    @SerializedName("image_urls")
    public HashMap<String, List<ImageUrlItem>> imageUrlList;

    //GETTERS
    public String getSaleName() {
        return saleName;
    }

    public String getSaleUrl() {
        return saleUrl;
    }

    public String getBegins() {
        return begins;
    }

    public String getEnds() {
        return ends;
    }

    public String getDescription() {
        return description;
    }

    public HashMap<String, List<ImageUrlItem>> getImageUrlList() {
        return imageUrlList;
    }


    // Utils methods
    public String getImageUrlByDimens(){
        return getImageUrlByDimens(DIMENS_2544x1344);
    }

    public String getImageUrlByDimens(String dimens){
        if (getImageUrlList().containsKey(dimens)){
            List<ImageUrlItem> itemList = getImageUrlList().get(dimens);
            ImageUrlItem item = itemList.get(0); // we used to retrieve the first time

            if (item.url != null && !item.url.equals("")) {
                return item.url;
            }
        }
        return "";
    }
}

class ImageUrlItem implements Serializable {
    // images urls
    @SerializedName("url")
    public String url;

    // width & height are here not used
}
