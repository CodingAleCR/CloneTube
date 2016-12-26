package info.codingalecr.clonetube.view.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Comentario;
import info.codingalecr.clonetube.model.Util;
import info.codingalecr.clonetube.model.Video;
import info.codingalecr.clonetube.view.adapter.ListaComentariosAdapter;
import info.codingalecr.clonetube.view.adapter.ListaSmallVideoAdapter;
import info.codingalecr.clonetube.view.adapter.ListaVideoAdapter;

public class DetalleVideoActivity extends AppCompatActivity {
    private Video mVideo;
    private boolean detailsOn;
    private ListaComentariosAdapter mComentariosAdapter;
    private ListaSmallVideoAdapter mVideosRelacionadosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_video);

        Util.getInstance().Initialize(getApplicationContext());
        mVideo = Util.getInstance().readVideoInfo("videoSeleccionado");
        detailsOn = false;

        //Informacion del video
        //Seteando Titulo
        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(mVideo.getTitulo());

        //Seteando descripcion
        TextView descripcion = (TextView) findViewById(R.id.descripcionVideo);
        descripcion.setText(mVideo.getDescripcion());

        // Seteando Vistas
        TextView vistas = (TextView) findViewById(R.id.vistas);
        vistas.setText(mVideo.getVistas()+" vistas");

        //Seteando el *video*
        ImageView imagen = (ImageView) findViewById(R.id.prevista);
        Glide.with(imagen.getContext()).load(mVideo.getImagen()).into(imagen);

        //Seteando votos favorables
        TextView favorables = (TextView) findViewById(R.id.votosFavorables);
        favorables.setText(""+mVideo.getVotosFavorables());

        //Seteando votos desfavorables
        TextView desfavorables = (TextView) findViewById(R.id.votosDesfavorables);
        desfavorables.setText(""+mVideo.getVotosDesfavorables());

        // Seteando Tiempo
        TextView tiempo = (TextView) findViewById(R.id.tiempoSubido);
        long now = System.currentTimeMillis();
        tiempo.setText("Publicado "+DateUtils.getRelativeTimeSpanString(mVideo.getFechaSubida().getTime(), now, DateUtils.MINUTE_IN_MILLIS));

        //Seteando Categoria
        TextView categoria = (TextView) findViewById(R.id.categoria);
        categoria.setText(mVideo.getCategoria());

        //Seteando Licencia
        TextView licencia = (TextView) findViewById(R.id.licencia);
        licencia.setText(mVideo.getLicencia());

        //Informacion del canal
        // Seteando Imagen del canal
        ImageView imagenCanal = (ImageView) findViewById(R.id.canal);
        Glide.with(imagenCanal.getContext()).load(mVideo.getCanal().getIdImagen()).into(imagenCanal);

        // Seteando Nombre del canal
        TextView nombreCanal = (TextView) findViewById(R.id.nombreUsuario);
        nombreCanal.setText(mVideo.getCanal().getNombre());

        // Seteando Nombre del actor
        TextView actor = (TextView) findViewById(R.id.actor);
        actor.setText(mVideo.getCanal().getNombre());

        // Seteando subscripciones del canal
        TextView subscripciones = (TextView) findViewById(R.id.subscripciones);
        subscripciones.setText(mVideo.getCanal().getSeguidores()+" subscriptores");

        //Asignamos los videos relacionados al que tenemos en detalle
        mVideosRelacionadosAdapter =  new ListaSmallVideoAdapter(getApplicationContext(), R.layout.small_video_item);
        ListView listaVideosRelacionados = (ListView) findViewById(R.id.listaVideosRelacionados);
        if (listaVideosRelacionados != null) {
            listaVideosRelacionados.setAdapter(mVideosRelacionadosAdapter);
        }

        //Asignamos los comentarios del video
        mComentariosAdapter = new ListaComentariosAdapter(new ArrayList<Comentario>(Arrays.asList(mVideo.getComentarios())), getApplicationContext(), R.layout.comentario_item);
        ListView listaComentarios = (ListView) findViewById(R.id.listaComentarios);
        if (listaComentarios != null) {
            listaComentarios.setAdapter(mComentariosAdapter);
        }

        //Se hace para no perder los scrolls por el uso de dos listviews
        Util.setListViewHeightBasedOnChildren(listaVideosRelacionados);
        Util.setListViewHeightBasedOnChildren(listaComentarios);

        //Verificamos que existe dicha lista y creamos el onClick para cada video relacionado
        if (listaVideosRelacionados != null) {
            listaVideosRelacionados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    showSnackBar("Aqui irias al detalle del otro video");
                }
            });
        }
    }

    /**
     * Muestra una {@link Snackbar} prefabricada
     *
     * @param msg Mensaje a proyectar
     */
    private void showSnackBar(String msg) {
        Snackbar.make(findViewById(R.id.titulo), msg, Snackbar.LENGTH_LONG).show();
    }

    /**
     * Método onClick() del boton de subscripcion rapida al canal del creador del video
     * @param view
     */
    public void onSubscribeClick(View view) {
        showSnackBar("Mediante este boton se puede subscribir al canal");
    }

    /**
     * Método onClick() del boton para ver el canal del creador del video
     * @param view
     */
    public void onCanalClick(View view) {
        showSnackBar("Mediante este boton se puede ir al detalle del canal");
    }

    /**
     * Método onClick() del boton de la descripcion, hace un toggle para esconder dicha
     * descripcion de video u otra informacion del mismo.
     *
     * @param view
     */
    public void onDropClick(View view) {
        ImageView mDropButton = (ImageView) view;
        RelativeLayout detalles = (RelativeLayout) findViewById(R.id.detallesVideo);
        if (!detailsOn) {
            mDropButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_up_drop_circle_grey600_18dp));
            detalles.setVisibility(View.VISIBLE);
            detailsOn = true;
        } else {
            mDropButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_down_drop_circle_grey600_18dp));
            detalles.setVisibility(View.GONE);
            detailsOn = false;
        }
    }

    /**
     * Método onClick() del boton de dislike al video
     * @param view
     */
    public void onThumbDownClick(View view) {
        showSnackBar("No te gusta el video");
    }

    /**
     * Método onClick() del boton de like de video
     * @param view
     */
    public void onThumbUpClick(View view) {
        showSnackBar("Te gusta el video");
    }

    /**
     * Método onClick() del boton de compartir video
     * @param view
     */
    public void onCompartirClick(View view) {
        showSnackBar("Con este boton compartes el video");
    }

    /**
     * Método onClick() del boton de opciones en video
     *
     * @param v
     */
    public void showPopup(View v) {
        showSnackBar("Aqui se mostrarian opciones para el usuario.");
    }

    /**
     * Método onClick() del boton de comentarios en un comentario
     *
     * @param view
     */
    public void onComentarClick(View view) {
        showSnackBar("Con este boton veras comentarios sobre el comentario el video");
    }
}
