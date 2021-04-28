package com.example.mesplanetes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DetecteurDeClicSurRecycler{

    private RecyclerView mRecyclerView;
    private MonRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    CoordinatorLayout mcoordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MonRecyclerViewAdapter(getDataSource());
        mRecyclerView.setAdapter(mAdapter);
        mcoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);


    }

    private ArrayList<Planetes> getDataSource() {
        ArrayList listePlanetes = new ArrayList<Planetes>();
        listePlanetes.add (new Planetes("Mercure" ,"Planete 1 ","4 878 km", "200 m/s" ,R.drawable.mercure));
        listePlanetes.add (new Planetes("Mars" ,"Planet 2" ,"3 245 km", "412 m/s" ,R.drawable.mars));
        listePlanetes.add (new Planetes("Terre" ," Planete 3" ,"7 868 km", "327 m/s" ,R.drawable.earth));
        listePlanetes.add (new Planetes("Uranus" ," Planete 4" ,"2 120 km", "424 m/s" ,R.drawable.uranus));
        listePlanetes.add (new Planetes("Jupiter" ," Planete 5" ,"42 547 km", "784 m/s" ,R.drawable.jupiter));
        listePlanetes.add (new Planetes("Pluton" ," Planete 6" ,"1 547 km", "245 m/s" ,R.drawable.pluton));
        listePlanetes.add (new Planetes("Saturne" ," Planete 6" ,"6 785 km", "358 m/s" ,R.drawable.saturne));
        listePlanetes.add (new Planetes("Vénus" ," Planete 7" ,"8 534 km", "653 m/s" ,R.drawable.venus));
        listePlanetes.add (new Planetes("Neptune" ," Planete 8" ,"3 124 km", "320 m/s" ,R.drawable.neptune));

        return listePlanetes;
    }


    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.setDetecteurDeClicSurRecycler(this);
    }


    public void clicSurRecyclerItem(int position, View v) {
        TextView titre= v.findViewById(R.id.tv_principal);
        Snackbar.make(mcoordinatorLayout, "La planète " + titre.getText(),Snackbar.LENGTH_LONG).show();
    }




}