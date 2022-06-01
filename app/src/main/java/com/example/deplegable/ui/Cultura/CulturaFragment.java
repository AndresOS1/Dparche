package com.example.deplegable.ui.Cultura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deplegable.Adaptadores.Adaptador;
import com.example.deplegable.R;
import com.example.deplegable.databinding.FragmentCulturaBinding;
import com.example.deplegable.databinding.FragmentGalleryBinding;
import com.example.deplegable.ui.gallery.GalleryViewModel;

public class CulturaFragment extends Fragment {

    Adaptador adaptador;
    RecyclerView recyclerView;

    private FragmentCulturaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cultura);
        recyclerView = view.findViewByID(R.id.recyclerView);

        /*CulturaViewModel culturaViewModel =
                new ViewModelProvider(this).get(CulturaViewModel.class);

        binding = FragmentCulturaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.recyclerView;
        culturaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}