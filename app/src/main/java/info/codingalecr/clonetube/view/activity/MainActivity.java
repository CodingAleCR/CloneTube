package info.codingalecr.clonetube.view.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import info.codingalecr.clonetube.R;
import info.codingalecr.clonetube.view.adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar(); // Añadir la toolbar

        // Setear adaptador al viewpager.
        mViewPager = (ViewPager) findViewById(R.id.pager);

        // Preparar las pestañas
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.addTab(tabs.newTab().setIcon(R.drawable.home));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.fire));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.youtube_play));
        tabs.addTab(tabs.newTab().setIcon(R.drawable.account));

        tabs.setTabGravity(TabLayout.GRAVITY_FILL);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabs.getTabCount());
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() != 0) {
                    findViewById(R.id.fab).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.fab).setVisibility(View.VISIBLE);
                }

                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    /**
     * Establece la toolbar como action bar
     */
    private void setToolbar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        final ActionBar ab = getSupportActionBar();
//        if (ab != null) {
//            ab.setDisplayHomeAsUpEnabled(true);
//        }

    }

    /**
     * Muestra una {@link Snackbar} prefabricada
     *
     * @param msg Mensaje a proyectar
     */
    private void showSnackBar(String msg) {
        Snackbar.make(findViewById(R.id.tituloPrincipal), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate( R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    /**
     * Método onClick() del FAB
     *
     * @param v View presionado
     */
    public void onFabClick(View v) {
        showSnackBar("Subir un video mediante este botón...");
    }

    /**
     * Método onClick() del boton de busqueda
     *
     * @param view
     */
    public void onSearchClick(View view) {
        showSnackBar("Mediante este boton podrias buscar diferentes videos...");
    }

    /**
     * Método onClick() del boton de configuracion
     *
     * @param view
     */
    public void onSettingsClick(View view) {
        showSnackBar("Mediante este boton podrias seleccionar las opciones de configuracion...");
    }

    /**
     * Método onClick() del boton de opciones en video
     *
     * @param v
     */
    public void showPopup(View v) {
        showSnackBar("Aqui se mostrarian opciones para el usuario.");
    }
}
