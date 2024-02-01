package com.example.practical_3;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// 5. Created a class called MoodNoteViewModel that gets the Application as a parameter and
// extends AndroidViewModel.
// follow naming convention of entity + viewModel
public class DBViewModelTemplate extends AndroidViewModel {
    //Added a private member variable to hold a reference to the repository.
    private DBRepositoryTemplate mRepository;
    private final LiveData<List<DBEntityTemplate>> mAllNotes;

    //Implemented a constructor that creates the MoodNoteRepository.
    //In the constructor, initialized the allNotes LiveData using the repository.
    public DBViewModelTemplate(Application application) {
        super(application);
        mRepository = new DBRepositoryTemplate(application);
        mAllNotes = mRepository.getAllNotes();
    }

    //Added a getAllNotes() method to return a cached list of words.
    LiveData<List<DBEntityTemplate>> getAllNotes() {
        return mAllNotes;
    }

    // Created a wrapper insert() method that calls the Repository's insert() method.
    // In this way, the implementation of insert() is encapsulated from the UI.
    public void insert(DBEntityTemplate note) {
        mRepository.insert(note);
    }
}
