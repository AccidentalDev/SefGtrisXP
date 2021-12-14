package com.example.sefgtrisxp.ui.main;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sefgtrisxp.R;
import com.example.sefgtrisxp.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {
    private MainViewModel mViewModel;
    private MainFragmentBinding layoutBinding;
    private static View.OnClickListener mainClickListener;

    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        layoutBinding = MainFragmentBinding.inflate(inflater, container, false);
        return layoutBinding.getRoot();
        //return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@Nullable View view, @Nullable Bundle savedInstanceState){
        if(mainClickListener == null){
            mainClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mViewModel.mainMenuClick(view.getId());

                    //ToDo- This might seem a little redundant but all this actions are directly tied with Android so they shouldn't be on the ViewModel i think
                    switch (view.getId()){
                        case R.id.easyButton:
                            Toast.makeText(getActivity(), "Easy difficulty choosen!", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.mediumButton:
                            Toast.makeText(getActivity(), "Medium difficulty choosen!", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.hardButton:
                            Toast.makeText(getActivity(), "Hard difficulty choosen!", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.button:
                            //CFCU- Finish the app
                            getActivity().finishAndRemoveTask();
                            break;
                        default:
                            Toast.makeText(getActivity(), "Unknown option was selected!", Toast.LENGTH_SHORT).show();
                    }
                }
            };
        }
        layoutBinding.easyButton.setOnClickListener(mainClickListener);
        layoutBinding.mediumButton.setOnClickListener(mainClickListener);
        layoutBinding.hardButton.setOnClickListener(mainClickListener);
        layoutBinding.button.setOnClickListener(mainClickListener);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        layoutBinding = null;
        mViewModel = null;
    }
}
