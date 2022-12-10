package com.example.decisions.viewModel;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.decisions.database.Task;
import com.example.decisions.database.DecisionRepository;
import com.example.decisions.database.WaitingBoard;

import java.util.List;

public class LibraryFragmentViewModel extends AndroidViewModel {

    private DecisionRepository mRepository;
    private final LiveData<List<Task>> mAllTasks;

    public LibraryFragmentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new DecisionRepository(application);
        mAllTasks = mRepository.getAllTasks();

    }

    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public void insertTask(Task task) {
        mRepository.insertTask(task);
    }

    public void insertWaitingBoard(WaitingBoard waitingBoard) {
        mRepository.insertWaitingBoard(waitingBoard);
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
