package com.example.decisions.viewModel;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.decisions.database.Task;
import com.example.decisions.database.TaskRepository;

import java.util.List;

public class LibraryFragmentViewModel extends AndroidViewModel {

    private TaskRepository mRepository;
    private final LiveData<List<Task>> mAllTasks;

    public LibraryFragmentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TaskRepository(application);
        mAllTasks = mRepository.getAllTasks();

    }

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public void insert(Task task) {
        mRepository.insert(task);
    }

    //test methods
    private Uri ImgURI;

    public Uri getImgURI() {
        return ImgURI;
    }

    public void setImgURI(Uri imgURI) {
        ImgURI = imgURI;
    }
}
