package com.example.deplegable.ui.Moteles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.deplegable.databinding.FragmentGalleryBinding;
import com.example.deplegable.databinding.FragmentMotelBinding;
import com.example.deplegable.ui.gallery.GalleryViewModel;

public class MotelFragment extends Fragment {

    private FragmentMotelBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MotelViewModel motelViewModel=
                new ViewModelProvider(this).get(MotelViewModel.class);

        binding = FragmentMotelBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMotel;
        motelViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    
}