package info.codingalecr.clonetube.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.model.Util;
import info.codingalecr.clonetube.model.Video;
import info.codingalecr.clonetube.view.activity.DetalleVideoActivity;
import info.codingalecr.clonetube.view.adapter.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeTabFragment extends Fragment {
    private Context mContext;
    private ListAdapter adapter;
    private View rootView;

    public HomeTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getContext();

    }

    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View rootView = super.onCreateView(inflater, container, savedInstanceState);
//        this.rootView = rootView;
//
//        Context context = getActivity();
//        int idLayout = R.layout.grid_item;
//        this.adapter = new ListAdapter(context, idLayout);
//
//        final ListView list_view = (ListView) rootView.findViewById(R.id.listaViewVideos);
//        list_view.setAdapter(adapter);


        return inflater.inflate(R.layout.fragment_home_tab, container, false);
    }


    protected int getLayoutFromResource() {
        return R.layout.fragment_home_tab;
    }


}
