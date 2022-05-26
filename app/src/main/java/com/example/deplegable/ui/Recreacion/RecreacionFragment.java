package com.example.deplegable.ui.Recreacion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.deplegable.databinding.FragmentGalleryBinding;
import com.example.deplegable.databinding.FragmentRecreBinding;
import com.example.deplegable.ui.gallery.GalleryViewModel;

public class RecreacionFragment extends Fragment {

    private FragmentRecreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecreacionViewModel recreacionFragment =
                new ViewModelProvider(this).get(RecreacionViewModel.class);

        binding = FragmentRecreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMotel;
        recreacionFragment.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    
}