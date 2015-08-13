package br.com.infosolo.ezonboarding;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentOne extends Fragment {

    IntroPageTransformer introPageTransformer;

    public static FragmentOne newInstance(IntroPageTransformer introPageTransformer) {
        FragmentOne fragment = new FragmentOne(introPageTransformer);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentOne(IntroPageTransformer introPageTransformer) {
        this.introPageTransformer = introPageTransformer;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        //TODO: CHANGE THIS TO AUTOMATICALLY SET TAG FROM ADAPTER
        view.setTag(1);

        Map<View, AnimationEnum> map = new HashMap<>();
        map.put(view.findViewById(R.id.title), AnimationEnum.Animation1);
        map.put(view.findViewById(R.id.computer), AnimationEnum.Animation2);
        map.put(view.findViewById(R.id.description), AnimationEnum.Animation3);
        introPageTransformer.setViewMapAnimation(map);
        return view;
    }
}
