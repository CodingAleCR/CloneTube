package info.codingalecr.clonetube.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Date;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Video;

/**
 * Created by Alejandro on 12/23/2016.
 */
public class GridAdapter extends BaseAdapter {

    private final Context mContext;
    private final Video[] items;

    public GridAdapter(Context c, Video[] items) {
        mContext = c;
        this.items = items;
    }

    @Override
    public int getCount() {
        // Decremento en 1, para no contar el header view
        return items.length - 1;
    }

    @Override
    public Video getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        Video item = getItem(position);

        // Seteando Imagen
        ImageView imagen = (ImageView) view.findViewById(R.id.prevista);
        Glide.with(imagen.getContext()).load(item.getImagen()).into(imagen);

        // Seteando Imagen del canal
        ImageView imagenCanal = (ImageView) view.findViewById(R.id.canal);
        Glide.with(imagenCanal.getContext()).load(item.getCanal().getIdImagen()).into(imagenCanal);

        // Seteando Titulo
        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        titulo.setText(item.getTitulo());

        // Seteando Nombre del canal
        TextView descripcion = (TextView) view.findViewById(R.id.descripcion);
        descripcion.setText(item.getCanal().getNombre());

        // Seteando Vistas
        TextView vistas = (TextView) view.findViewById(R.id.precio);
        vistas.setText(item.getVistas());

        // Seteando Vistas
        TextView tiempo = (TextView) view.findViewById(R.id.tiempoSubido);
        Date now = new Date();
        tiempo.setText(item.getFechaSubida().compareTo(now));

        return view;
    }
}

