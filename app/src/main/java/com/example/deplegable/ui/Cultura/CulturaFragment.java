package com.example.deplegable.ui.Cultura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deplegable.Adaptadores.Adaptador;
import com.example.deplegable.R;
import com.example.deplegable.databinding.FragmentCulturaBinding;
import com.example.deplegable.databinding.FragmentGalleryBinding;
import com.example.deplegable.model.Publicaciones;
import com.example.deplegable.ui.gallery.GalleryViewModel;

import java.util.ArrayList;

public class CulturaFragment extends Fragment {

    Adaptador adaptador;
    RecyclerView recyclerViewCul;
    ArrayList<Publicaciones> listaPubli;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cultura, container, false);
        recyclerViewCul = view.findViewById(R.id.recyclerView);

        listaPubli = new ArrayList<>();
        //cargar la lista
        cargarLista();
        //mostrar datos
        mostrarDatos();

        return view;
    }
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
    public void cargarLista(){
        listaPubli.add(new Publicaciones(R.drawable.agregar,"sisisisiis","esta sera "));
        listaPubli.add(new Publicaciones(R.drawable.bar,"sisisisiis","esta sera "));
        listaPubli.add(new Publicaciones(R.drawable.casa,"sisisisiis","esta sera "));
        listaPubli.add(new Publicaciones(R.drawable.club,"sisisisiis","esta sera "));
        listaPubli.add(new Publicaciones(R.drawable.campestre,"Steven lo logramos","sena"));
    }

    public void mostrarDatos(){
        recyclerViewCul.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptador = new Adaptador(getContext(), listaPubli);
        recyclerViewCul.setAdapter(adaptador);
    }

    /*@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }*/

}