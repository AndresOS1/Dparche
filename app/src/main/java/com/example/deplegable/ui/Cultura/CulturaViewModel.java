package com.example.deplegable.ui.Cultura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CulturaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CulturaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("EVENTOS CULTURALES");
    }

    public LiveData<String> getText() {
        return mText;
    }
}