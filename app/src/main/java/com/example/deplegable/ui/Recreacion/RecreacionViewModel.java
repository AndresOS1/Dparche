package com.example.deplegable.ui.Recreacion;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecreacionViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecreacionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("EVENTOS RECREACIONALES");
    }

    public LiveData<String> getText() {
        return mText;
    }
}