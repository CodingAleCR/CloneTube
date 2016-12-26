package info.codingalecr.clonetube.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Util;
import info.codingalecr.clonetube.model.Video;
import info.codingalecr.clonetube.view.activity.DetalleVideoActivity;
import info.codingalecr.clonetube.view.adapter.ListaVideoAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabFragment extends ListFragment {

    private Context mContext;
    private ListaVideoAdapter mVideoAdapter;

    public HomeTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getContext();
        this.mVideoAdapter = new ListaVideoAdapter(mContext, R.layout.video_item);
        setListAdapter(mVideoAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_tab, container, false);
        this.mVideoAdapter = new ListaVideoAdapter(mContext, R.layout.video_item);
        TextView titulo = (TextView) getActivity().findViewById(R.id.tituloPrincipal);
        titulo.setText("Inicio");

        return rootView;
    }


    protected int getLayoutFromResource() {
        return R.layout.fragment_home_tab;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    private void showDetails(int position) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), DetalleVideoActivity.class);
        Util.getInstance().Initialize(mContext);
        Util.getInstance().writeVideoInfo("videoSeleccionado", (Video) getListAdapter().getItem(position));
        startActivity(intent);
    }

}
