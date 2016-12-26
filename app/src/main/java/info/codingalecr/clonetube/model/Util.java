package info.codingalecr.clonetube.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;


/**
 * Created by Alejandro on 12/23/2016.
 */
public class Util {
    private static Util mInstance;
    private Context mContext;
    private SharedPreferences mSharedPreferences;

    private Util(){ }

    public static Util getInstance(){
        if (mInstance == null) mInstance = new Util();
        return mInstance;
    }

    public void Initialize(Context ctxt){
        mContext = ctxt;
        //
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    public void writeVideoInfo(String key, Object value){
        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }

    public Video readVideoInfo(String key) {
        Gson gson = new Gson();
        String json = mSharedPreferences.getString(key, "");
        Video mVideo = gson.fromJson(json, Video.class);
        return mVideo;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
