package com.example.lab2;

import android.text.Editable;
import android.text.TextWatcher;

public class ListenerY implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Settings.y = Double.valueOf(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
