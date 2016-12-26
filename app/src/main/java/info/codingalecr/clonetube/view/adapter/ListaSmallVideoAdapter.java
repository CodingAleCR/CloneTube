package info.codingalecr.clonetube.view.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.text.format.DateUtils;
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
public class ListaSmallVideoAdapter extends BaseAdapter {

    private final Context mContext;
    private List<Video> items;
    private int mLayout;

    public ListaSmallVideoAdapter(Context c, int layout, List<Video> items) {
        mContext = c;
        this.items = items;
        this.mLayout = layout;
    }

    public ListaSmallVideoAdapter(Context c, int layout) {
        mContext = c;
        this.mLayout = layout;
        getDummyContent();
    }

    /**
     * Método que proporciona contenido a la aplicacion como una demostracion de la misma
     * en el detalle de un video.
     */
    private void getDummyContent() {
        this.items =  new ArrayList<Video>();
        Canal c1 = new Canal("Canalero01","Canalero01", R.drawable.ic_account_circle_black_18dp, 55000, "Federico L");
        Canal c2 = new Canal("JulianJuega", "JulianJuega", R.drawable.ic_account_circle_black_18dp, 25000, "JJulian");
        Canal c3 = new Canal("ESPN","ESPN", R.drawable.ic_account_circle_black_18dp, 1500, "ESPN Network");
        Canal c4 = new Canal("NBA", "NBA", R.drawable.ic_account_circle_black_18dp, 155000, "NBA");

        Comentario[] comentarios = new Comentario[6];
        comentarios[0] = new Comentario("Hola mundo", new Date(), "Marcos");
        comentarios[1] = new Comentario("Bienvenido a Clonetube", new Date(), "MeLlamoJaime");
        comentarios[2] = new Comentario("Need some help coding?", new Date(), "MenaM");
        comentarios[3] = new Comentario("Buen Video este", new Date(), "Marcos");
        comentarios[4] = new Comentario("Que bueno encontrar este tipo de herramientas", new Date(), "MartaCanta");
        comentarios[5] = new Comentario("Help me!", new Date(), "Estebannnn");

        String[] dateStrings = new String[6];
        dateStrings[0] = "12/24/2016 11:49:00 AM";
        dateStrings[1] = "12/20/2016 11:49:00 AM";
        dateStrings[2] = "10/24/2016 11:49:00 AM";
        dateStrings[3] = "12/25/2016 11:49:00 AM";
        dateStrings[4] = "12/26/2016 11:49:00 AM";
        dateStrings[5] = "12/26/2016 11:49:00 AM";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        Date[] convertedDates = new Date[6];
        try {
            convertedDates[0] = dateFormat.parse(dateStrings[0]);
            convertedDates[1] = dateFormat.parse(dateStrings[1]);
            convertedDates[2] = dateFormat.parse(dateStrings[2]);
            convertedDates[3] = dateFormat.parse(dateStrings[3]);
            convertedDates[4] = dateFormat.parse(dateStrings[4]);
            convertedDates[5] = dateFormat.parse(dateStrings[5]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        items.add(new Video(c2, "Comedia", comentarios, "Este es mi primer video de ejemplo, espero os guste!", convertedDates[0], "744896321", "https://goo.gl/mgwoHf", "MIT", "Hello Mundo!", 100, 2, 5));
        items.add(new Video(c1, "Deportes", comentarios, "Mira esta atrapada, es increible lo que logr hacer!", convertedDates[0], "786+9443", "https://goo.gl/ccgW4i", "MIT", "Mira esta atrapada!", 100, 2, 5));
        items.add(new Video(c3, "Drama", comentarios, "Y si el mundo termina", convertedDates[1], "876786767", "https://goo.gl/JNIJXa", "MIT", "Y si el mundo termina!", 100, 7, 21));
        items.add(new Video(c3, "Drama", comentarios, "Tienes que ver esto!", convertedDates[2], "435555545", "https://goo.gl/MUay9i", "MIT", "Tienes que ver esto!", 100, 42, 55));
        items.add(new Video(c4, "Deportes", comentarios, "BEST DUNKS OF 2016", convertedDates[3], "423497799", "https://goo.gl/LcvFZ1", "MIT", "DUNK MIX 2016!", 1000, 12, 50));
        items.add(new Video(c2, "Comedia", comentarios, "No le mola la rocola", convertedDates[4], "763243777", "https://goo.gl/rRMH7Y", "MIT", "No le mola la rocola!", 10000, 20, 500));
        items.add(new Video(c4, "Deportes", comentarios, "Greatest Hits 1970s", convertedDates[5], "123745678", "https://goo.gl/lHu1YN", "MIT", "Greatest Hits 1970s!", 250, 13, 75));
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
            view = inflater.inflate(R.layout.small_video_item, viewGroup, false);
        }

        Video item = getItem(position);

        // Seteando Imagen
        ImageView imagen = (ImageView) view.findViewById(R.id.prevista);
        Glide.with(imagen.getContext()).load(item.getImagen()).into(imagen);

        // Seteando Titulo
        TextView titulo = (TextView) view.findViewById(R.id.titulo);
        titulo.setText(item.getTitulo());

        // Seteando Nombre del canal
        TextView descripcion = (TextView) view.findViewById(R.id.nombreUsuario);
        descripcion.setText(item.getCanal().getNombre());

        // Seteando Vistas
        TextView vistas = (TextView) view.findViewById(R.id.vistas);
        vistas.setText(item.getVistas()+" vistas");

        //Hacemos el onClick del boton de opciones
        ImageView acciones = (ImageView) view.findViewById(R.id.accionVideoRelacionado);
        acciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Has seleccionado los ajustes de un video relacionado", Snackbar.LENGTH_LONG).show();
            }
        });

        return view;
    }
}

