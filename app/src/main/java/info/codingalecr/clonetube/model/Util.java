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

    /**
     * Ésta clase necesita un contexto, que debido a la naturaleza del patrn Singleton podria
     * brindarse en el método getInstance, sin embargo para evitar hacer varias referencias de
     * Context se utiliza uno separado que solamente se llama al inicio, previo a la utilizacion
     * de la clase.
     * @param ctxt
     */
    public void Initialize(Context ctxt){
        mContext = ctxt;
        //
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    /**
     * Escribe dentro del shared Preferences un objeto de cualquier tipo, en este caso es
     * necesario solamente para Videos por lo que se denomina el método como writeVideoInfo
     *
     * @param key
     * @param value
     */
    public void writeVideoInfo(String key, Object value){
        SharedPreferences.Editor prefsEditor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(value);
        prefsEditor.putString(key, json);
        prefsEditor.commit();
    }

    /**
     * Realiza una lectura en el sharedPreferences de un objeto tipo Video.
     * @param key
     * @return
     */
    public Video readVideoInfo(String key) {
        Gson gson = new Gson();
        String json = mSharedPreferences.getString(key, "");
        Video mVideo = gson.fromJson(json, Video.class);
        return mVideo;
    }

    /**
     * Éste método realiza un calculo sobre la altura que deberia tener un listview
     * en el caso de que se utilicen varios en un mismo fragment/activity.
     *
     * @param listView
     */
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
