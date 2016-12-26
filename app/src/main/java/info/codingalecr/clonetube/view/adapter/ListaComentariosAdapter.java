package info.codingalecr.clonetube.view.adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import info.codingalecr.clonetube.R;
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
        return items.size();
    }

    @Override
    public Comentario getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.comentario_item, parent, false);
        }

        Comentario item = getItem(position);

        // Seteando Titulo
        TextView usuario = (TextView) view.findViewById(R.id.nombreUsuario);
        usuario.setText(item.getUsuarioEmisor());

        // Seteando Titulo
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpoComentario);
        cuerpo.setText(item.getCuerpo());

        // Seteando Fecha Comentario
        TextView tiempo = (TextView) view.findViewById(R.id.fechaComentario);
        long now = System.currentTimeMillis();
        tiempo.setText(DateUtils.getRelativeTimeSpanString(item.getFecha().getTime(), now, DateUtils.MINUTE_IN_MILLIS));

        return view;
    }
}
