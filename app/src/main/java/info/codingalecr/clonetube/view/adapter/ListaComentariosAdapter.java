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

import java.util.List;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Comentario;

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

        // Seteando usuario que envio el comentario
        TextView usuario = (TextView) view.findViewById(R.id.nombreUsuario);
        usuario.setText(item.getUsuarioEmisor());

        // Seteando cuerpo del comentario
        TextView cuerpo = (TextView) view.findViewById(R.id.cuerpoComentario);
        cuerpo.setText(item.getCuerpo());

        // Seteando Fecha Comentario
        TextView tiempo = (TextView) view.findViewById(R.id.fechaComentario);
        long now = System.currentTimeMillis();
        tiempo.setText(DateUtils.getRelativeTimeSpanString(item.getFecha().getTime(), now, DateUtils.MINUTE_IN_MILLIS));

        //Hacemos el onClick del boton de dislike
        ImageView dislike = (ImageView) view.findViewById(R.id.accionDislikeComentario);
        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Has indicado que no te gusta el comentario", Snackbar.LENGTH_LONG).show();
            }
        });

        //Hacemos el onClick del boton de like
        ImageView like = (ImageView) view.findViewById(R.id.accionLikeComentario);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Has dado me gusta a un comentario", Snackbar.LENGTH_LONG).show();
            }
        });

        //Hacemos el onClick del boton de ver respuestas
        ImageView respuestas = (ImageView) view.findViewById(R.id.accionVerRespuestas);
        respuestas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Has seleccionado ver las respuestas de un comentario", Snackbar.LENGTH_LONG).show();
            }
        });

        //Hacemos el onClick del boton de ajustes
        ImageView ajustes = (ImageView) view.findViewById(R.id.accionAjustes);
        ajustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Has seleccionado los ajustes de un comentario", Snackbar.LENGTH_LONG).show();
            }
        });

        //Hacemos el onClick de la imagen de perfil de usuario
        ImageView imagenPerfil = (ImageView) view.findViewById(R.id.canalComentador);
        imagenPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Este boton te dirige al perfil del usuario que comento", Snackbar.LENGTH_LONG).show();
            }
        });

        return view;
    }


}
