package com.loya.githubdevs.viewmodel;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.loya.githubdevs.util.Resource;
import com.loya.githubdevs.db.GitItem;
import com.loya.githubdevs.repository.UserRepository;

import java.util.List;

public class UserProfileViewModel extends AndroidViewModel {
    private UserRepository mRepository;


    public UserProfileViewModel(UserRepository mRepository) {
        super(mRepository.getApplication());
        this.mRepository = mRepository;
    }

    public LiveData<Resource<List<GitItem>>> getmAllUsers() {
        return mRepository.getAllUsers();
    }

    public LiveData<Resource<List<GitItem>>> refreshUserData() {
        return mRepository.refreshUserData();
    }

    public LiveData<GitItem> getUser(int userId) {
        return mRepository.getUser(userId);
    }


}