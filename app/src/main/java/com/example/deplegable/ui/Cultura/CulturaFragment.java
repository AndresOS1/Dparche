package com.example.deplegable.ui.Cultura;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deplegable.Adaptadores.Adaptador;
import com.example.deplegable.R;
import com.example.deplegable.model.Locati;
import com.example.deplegable.model.Publicaciones;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;

public class CulturaFragment extends Fragment{

    SearchView txtBuscar;
    Adaptador adaptador;
    RecyclerView recyclerViewCul;
    FirebaseFirestore db;
    Query query;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cultura, container, false);
        txtBuscar = view.findViewById(R.id.txt);
        db = FirebaseFirestore.getInstance();

        recyclerViewCul = view.findViewById(R.id.recyclerView);
        recyclerViewCul.setLayoutManager(new LinearLayoutManager(getContext()));

        query = db.collection("Localizacion");

        FirestoreRecyclerOptions<Publicaciones> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Publicaciones>().setQuery(query, Publicaciones.class).build();

        adaptador =  new Adaptador(firestoreRecyclerOptions);
        adaptador.notifyDataSetChanged();
        recyclerViewCul.setAdapter(adaptador);


        buscar();
        return view;
    }


    private void buscar() {
        txtBuscar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                textSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                textSearch(s);
                return false;
            }

        });
    }

    private void textSearch(final String s) {
        FirestoreRecyclerOptions<Publicaciones> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Publicaciones>().setQuery(query.orderBy("latitud").startAt(s).endAt(s+"~"), Publicaciones.class).build();
        adaptador = new Adaptador(firestoreRecyclerOptions);
        adaptador.startListening();
        recyclerViewCul.setAdapter(adaptador);

    }

    @Override
    public void onStart() {
        super.onStart();
        adaptador.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adaptador.stopListening();
    }


}

