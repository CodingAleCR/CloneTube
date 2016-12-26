package info.codingalecr.clonetube.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import info.codingalecr.clonetube.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DefaultTabFragment extends Fragment {
    private View rootView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_default_tab, container, false);
        return rootView;
    }
}
