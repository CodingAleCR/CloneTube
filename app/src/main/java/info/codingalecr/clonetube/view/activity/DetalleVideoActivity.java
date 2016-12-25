package info.codingalecr.clonetube.view.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Util;
import info.codingalecr.clonetube.model.Video;

public class DetalleVideoActivity extends AppCompatActivity {
    private Video mVideo;
    private boolean detailsOn;

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
        TextView nombreCanal = (TextView) findViewById(R.id.nombreCanal);
        nombreCanal.setText(mVideo.getCanal().getNombre());

        // Seteando Nombre del actor
        TextView actor = (TextView) findViewById(R.id.actor);
        actor.setText(mVideo.getCanal().getNombre());

        // Seteando subscripciones del canal
        TextView subscripciones = (TextView) findViewById(R.id.subscripciones);
        subscripciones.setText(mVideo.getCanal().getSeguidores()+" subscriptores");
    }

    /**
     * Muestra una {@link Snackbar} prefabricada
     *
     * @param msg Mensaje a proyectar
     */
    private void showSnackBar(String msg) {
        Snackbar.make(findViewById(R.id.titulo), msg, Snackbar.LENGTH_LONG).show();
    }

    public void onSubscribeClick(View view) {
        showSnackBar("Mediante este boton se puede subscribir al canal");
    }

    public void onCanalClick(View view) {
        showSnackBar("Mediante este boton se puede ir al detalle del canal");
    }

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

    public void onThumbDownClick(View view) {
        showSnackBar("No te gusta el video");
    }

    public void onThumbUpClick(View view) {
        showSnackBar("Te gusta el video");
    }

    public void onCompartirClick(View view) {
        showSnackBar("Con este boton compartes el video");
    }
}
