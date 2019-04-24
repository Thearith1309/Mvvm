package com.example.mvvmtest1.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mvvmtest1.models.NicePlace;
import com.example.mvvmtest1.repositiries.NicePlaceRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<NicePlace>> mNicePlace;
    private NicePlaceRepository mRepository;

    public void init() {
        mRepository = NicePlaceRepository.getInstance();
        mNicePlace = mRepository.getNicePlaces();

    }

    public MutableLiveData<List<NicePlace>> getNicePlace() {
        return mNicePlace;
    }

    public void setNicePlace(final NicePlace nicePlace) {
        List<NicePlace> list = mNicePlace.getValue();
        list.add(nicePlace);
        mNicePlace.postValue(list);

    }


}
