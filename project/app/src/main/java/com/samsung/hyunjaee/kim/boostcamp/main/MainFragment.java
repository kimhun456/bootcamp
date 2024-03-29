package com.samsung.hyunjaee.kim.boostcamp.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.samsung.hyunjaee.kim.boostcamp.R;
import com.samsung.hyunjaee.kim.boostcamp.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

    private FragmentMainBinding mBinding;
    private MainViewModel mViewModel;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(mViewModel);

        mViewModel.getMovieList().observe(this, movieList -> {
            movieList.forEach(movie -> {
                Log.d(TAG, movie.toString());
            });
        });
        mViewModel.addDummyMovie();
        return mBinding.getRoot();
    }
}
