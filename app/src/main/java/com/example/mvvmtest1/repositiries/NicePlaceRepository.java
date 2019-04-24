package com.example.mvvmtest1.repositiries;

import android.arch.lifecycle.MutableLiveData;

import com.example.mvvmtest1.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {

    private static NicePlaceRepository instance;
    private ArrayList<NicePlace> dataSet = new ArrayList<>();

    public static NicePlaceRepository getInstance() {
        if (instance == null)
            instance = new NicePlaceRepository();

        return instance;

    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
        data.setValue(dataSet);

        return data;

    }


}
