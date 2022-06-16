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

        FirestoreRecyclerOptions<Locati> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Locati>().setQuery(query, Locati.class).build();

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
        FirestoreRecyclerOptions<Locati> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Locati>().setQuery(query.orderBy("latitud").startAt(s).endAt(s+"~"), Locati.class).build();
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

/*
public class CulturaFragment extends Fragment{

    Adaptador adaptador;
    RecyclerView recyclerViewCul;
    FirebaseFirestore db;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cultura, container, false);
        db = FirebaseFirestore.getInstance();
        recyclerViewCul = view.findViewById(R.id.recyclerView);
        recyclerViewCul.setLayoutManager(new LinearLayoutManager(getContext()));

        Query query = db.collection("Localizacion");

        FirestoreRecyclerOptions<Locati> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Locati>().setQuery(query, Locati.class).build();

        adaptador = new Adaptador(firestoreRecyclerOptions);
        adaptador.notifyDataSetChanged();
        recyclerViewCul.setAdapter(adaptador);

        return view;
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
    
}*/
    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CulturaViewModel culturaViewModel =
                new ViewModelProvider(this).get(CulturaViewModel.class);

        binding = FragmentCulturaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textcultura;
        culturaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }*/
    /*public void cargarLista(){

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Localizacion").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot document: task.getResult()){
                        Log.d(TAG, document.getId() + "=>" + document.getData());
                        String adapter = document.getData().toString();
                        try {
                            adap = Double.parseDouble(adapter);
                        }catch (NumberFormatException e) {

                        }
                        Locati locati = new Locati();
                        locati.setLatitud(adap);
                        locati.setLongitud(adap);
                        listaPubli.add(locati);
                        adaptador.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    public void mostrarDatos(){
        recyclerViewCul.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptador = new Adaptador(getContext(), listaPubli);
        recyclerViewCul.setAdapter(adaptador);
    }
*/
    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/
