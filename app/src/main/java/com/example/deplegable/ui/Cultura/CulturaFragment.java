package com.example.deplegable.ui.Cultura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.deplegable.databinding.FragmentCulturaBinding;
import com.example.deplegable.databinding.FragmentGalleryBinding;
import com.example.deplegable.ui.gallery.GalleryViewModel;

public class CulturaFragment extends Fragment {

    private FragmentCulturaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CulturaViewModel culturaViewModel =
                new ViewModelProvider(this).get(CulturaViewModel.class);

        binding = FragmentCulturaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textcultura;
        culturaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}