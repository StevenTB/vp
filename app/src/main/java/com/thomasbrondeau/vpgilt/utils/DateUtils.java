package com.thomasbrondeau.vpgilt.utils;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import timber.log.Timber;

/**
 * Created by THOMASBRONDEAU_Steven on 20/04/2018.
 */

public class DateUtils {
    public static String getFormattedDate(Context context, String val){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = sdf.parse(val);
            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
            return dateFormat.format(date);
        } catch (Exception e){
            Timber.e("Error while trying to parse date", e);
        }
        return "";
    }
}
