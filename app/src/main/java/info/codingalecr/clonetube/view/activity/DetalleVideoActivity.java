package info.codingalecr.clonetube.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Util;
import info.codingalecr.clonetube.model.Video;

public class DetalleVideoActivity extends AppCompatActivity {
    private Video mVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_video);
        Util.getInstance().Initialize(getApplicationContext());
        mVideo = Util.getInstance().readVideoInfo("videoSeleccionado");

        TextView titulo = (TextView) findViewById(R.id.titulo);
        titulo.setText(mVideo.getTitulo());

        ImageView imagen = (ImageView) findViewById(R.id.prevista);
        Glide.with(imagen.getContext()).load(mVideo.getImagen()).into(imagen);
        // Seteando Imagen del canal
        ImageView imagenCanal = (ImageView) findViewById(R.id.canal);
        Glide.with(imagenCanal.getContext()).load(mVideo.getCanal().getIdImagen()).into(imagenCanal);


        // Seteando Nombre del canal
        TextView descripcion = (TextView) findViewById(R.id.nombreCanal);
        descripcion.setText(mVideo.getCanal().getNombre());

        // Seteando Vistas
        TextView vistas = (TextView) findViewById(R.id.vistas);
        vistas.setText(mVideo.getVistas()+" vistas");

        // Seteando Vistas
        TextView tiempo = (TextView) findViewById(R.id.tiempoSubido);
        long now = System.currentTimeMillis();
        tiempo.setText(DateUtils.getRelativeTimeSpanString(mVideo.getFechaSubida().getTime(), now, DateUtils.MINUTE_IN_MILLIS));
    }
}
