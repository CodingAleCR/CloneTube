package info.codingalecr.clonetube.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import info.codingalecr.clonetube.model.Comentario;
import info.codingalecr.clonetube.model.Video;

/**
 * Created by Alejandro on 12/25/2016.
 */
public class ListaComentariosAdapter extends BaseAdapter {
    private final Context mContext;
    private List<Comentario> items;
    private int mLayout;

    public ListaComentariosAdapter(Context mContext, int mLayout) {
        this.mContext = mContext;
        this.mLayout = mLayout;
    }

    public ListaComentariosAdapter(List<Comentario> items, Context mContext, int mLayout) {
        this.items = items;
        this.mContext = mContext;
        this.mLayout = mLayout;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
