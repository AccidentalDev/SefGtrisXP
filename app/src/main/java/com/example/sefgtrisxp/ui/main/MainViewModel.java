package com.example.sefgtrisxp.ui.main;

import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.sefgtrisxp.R;

public class MainViewModel extends ViewModel {
    public void mainMenuClick(int viewId) {
        switch (viewId){
            case R.id.easyButton:
                //ToDo: run the gameplay fragment with the easy setting

                break;
            case R.id.mediumButton:
                //ToDo: run the gameplay fragment with the medium setting

                break;
            case R.id.hardButton:
                //ToDo: run the gameplay fragment with the hard setting

                break;
            default:
                //ToDo: Noting to do here really
        }
    }
}
