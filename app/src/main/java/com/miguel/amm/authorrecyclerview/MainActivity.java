package com.miguel.amm.authorrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MyRVAdapter.ItemClickListener {

    List<String> autores;
    List<String> drawables;
    private RecyclerView rvAutores;
    private MyRVAdapter rvAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private boolean autoresLoaded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autores = new ArrayList<String>();
        drawables = new ArrayList<String>();

        autores.add("Arquímedes");
        autores.add("Confucio");
        autores.add("Descartes");
        autores.add("Groucho Marx");
        autores.add("Julio César");
        autores.add("Nietzsche");
        autores.add("Pitágoras");
        autores.add("Platón");
        autores.add("Séneca");
        autores.add("Woody Allen");
        drawables.add("arquimedes");
        drawables.add("confucio");
        drawables.add("descartes");
        drawables.add("groucho_marx");
        drawables.add("julio_cesar");
        drawables.add("nietzsche");
        drawables.add("pitagoras");
        drawables.add("platon");
        drawables.add("seneca");
        drawables.add("woody_allen");


        Button btnLoad = (Button) findViewById(R.id.btnLoad);
        rvAutores = (RecyclerView) findViewById(R.id.rvAutores);


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!autoresLoaded) {
                    // Al gestor de layouts será para LinearLayouts, obtenemos uno.
                    layoutManager = new LinearLayoutManager(getApplicationContext());

                    // Establecemos el gestor para nuestro recycler view.
                    rvAutores.setLayoutManager(layoutManager);

                    // Creamos un nuevo adaptador de nuestra clase
                    rvAdapter = new MyRVAdapter(getApplicationContext(), autores, drawables);

                    // Indicamos que esta activity es el listener de nuestro adapter.
                    rvAdapter.setClickListener(MainActivity.this);

                    // Establecemos el nuevo adaptador para nuestro recyler view.
                    rvAutores.setAdapter(rvAdapter);

                    autoresLoaded = true;
                }
                else{
                    Toast.makeText(getApplicationContext(), "Ya has cargado la lista de autores", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onRVItemClick(View view, int position) {
        Toast.makeText(this, "Has pulsado en " + rvAdapter.getItem(position) + " que es el item número " + position, Toast.LENGTH_SHORT).show();
    }
}
