package com.example.deplegable.ui.Moteles;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MotelViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MotelViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("PASION");
    }

    public LiveData<String> getText() {
        return mText;
    }
}