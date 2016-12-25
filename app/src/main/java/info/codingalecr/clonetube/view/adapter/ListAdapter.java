package info.codingalecr.clonetube.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Canal;
import info.codingalecr.clonetube.model.Comentario;
import info.codingalecr.clonetube.model.Video;

/**
 * Created by Alejandro on 12/23/2016.
 */
public class ListAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Video> items;
    private int mLayout;

    public ListAdapter(Context c, int layout, List<Video> items) {
        mContext = c;
        this.items = items;
        this.mLayout = layout;
    }

    public ListAdapter(Context c, int layout) {
        mContext = c;
        this.mLayout = layout;
        getDummyContent();
    }

    private void getDummyContent() {
        this.items =  new ArrayList<Video>();
        Canal c1 = new Canal("Canalero01", R.drawable.account, 55000, "Federico L");
        Canal c2 = new Canal("JulianJuega", R.drawable.account, 55000, "JJulian");
        Canal c3 = new Canal("ESPN", R.drawable.account, 55000, "ESPN Network");
        Canal c4 = new Canal("NBA", R.drawable.account, 55000, "NBA");

        Comentario[] comentarios = new Comentario[6];
        comentarios[0] = new Comentario("Hola mundo", new Date(), "Marcos");
        comentarios[1] = new Comentario("Bienvenido a Clonetube", new Date(), "MeLlamoJaime");
        comentarios[2] = new Comentario("Need some help coding?", new Date(), "MenaM");
        comentarios[3] = new Comentario("Buen Video este", new Date(), "Marcos");
        comentarios[4] = new Comentario("Que bueno encontrar este tipo de herramientas", new Date(), "MartaCanta");
        comentarios[5] = new Comentario("Help me!", new Date(), "Estebannnn");

        String dateString = "03/26/2012 11:49:00 AM";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        items.add(new Video(c2, "Comedia", comentarios, "Este es mi primer video de ejemplo, espero os guste!", convertedDate, "744896321", R.drawable.fire, "MIT", "Hello Mundo!", 100, 2, 5));
        items.add(new Video(c1, "Deportes", comentarios, "Mira esta atrapada, es increible lo que logr hacer!", convertedDate, "786+9443", R.drawable.fire, "MIT", "Mira esta atrapada!", 100, 2, 5));
        items.add(new Video(c3, "Drama", comentarios, "Y si el mundo termina", convertedDate, "876786767", R.drawable.fire, "MIT", "Y si el mundo termina!", 100, 7, 21));
        items.add(new Video(c3, "Drama", comentarios, "Tienes que ver esto!", convertedDate, "435555545", R.drawable.fire, "MIT", "Tienes que ver esto!", 100, 42, 55));
        items.add(new Video(c4, "Musica", comentarios, "POP MUSIC MIX 2016", convertedDate, "423497799", R.drawable.fire, "MIT", "POP MUSIC MIX 2016!", 1000, 12, 50));
        items.add(new Video(c2, "Comedia", comentarios, "No le mola la rocola", convertedDate, "763243777", R.drawable.fire, "MIT", "No le mola la rocola!", 10000, 20, 500));
        items.add(new Video(c4, "Musica", comentarios, "Greatest Hits 1970s", convertedDate, "123745678", R.drawable.fire, "MIT", "Greatest Hits 1970s!", 250, 13, 75));
    }

    @Override
    public int getCount() {
        // Decremento en 1, para no contar el header view
        return items.size();
    }

    @Override
    public Video getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
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
        TextView descripcion = (TextView) view.findViewById(R.id.nombreCanal);
        descripcion.setText(item.getCanal().getNombre());

        // Seteando Vistas
        TextView vistas = (TextView) view.findViewById(R.id.vistas);
        vistas.setText(item.getVistas());

        // Seteando Vistas
        TextView tiempo = (TextView) view.findViewById(R.id.tiempoSubido);
        Date now = new Date();
        tiempo.setText(item.getFechaSubida().compareTo(now));

        return view;
    }
}

