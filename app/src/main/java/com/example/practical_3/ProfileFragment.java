package com.example.practical_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileFragment extends Fragment {
    private DBViewModelTemplate dbViewModelTemplate;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // region database with recycler view
        RecyclerView recyclerView = view.findViewById(R.id.RVProfileTemplate);
        final ViewHolderAdapterTemplate adapter = new ViewHolderAdapterTemplate(new ViewHolderAdapterTemplate.NoteDiff());
        recyclerView.setAdapter(adapter);
        // can choose other layoutManager like GridLayoutManager but usually LinearLayoutManager is more than enough
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dbViewModelTemplate = new ViewModelProvider(this).get(DBViewModelTemplate.class);

        // use 'this' if using in activity instead of getViewLifecycleOwner()
        dbViewModelTemplate.getAllNotes().observe(getViewLifecycleOwner(), users -> {
            // this is a mapping of the users to a list of string username, lazy to create a new adapter
            List<String> stringAttributes = users.stream()
                    .map(DBEntityTemplate::getUserName)  // Replace 'Note' with your actual class name
                    .collect(Collectors.toList());
            adapter.submitList(stringAttributes);
        });

        Button BtnAddUser = view.findViewById(R.id.BtnAddUser);
        BtnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbViewModelTemplate.insert(new DBEntityTemplate("hello"));
            }
        });
    }
}
