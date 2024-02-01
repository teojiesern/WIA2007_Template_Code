package com.example.practical_3;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

class ViewHolderAdapterTemplate extends ListAdapter<String, ViewHolderTemplate> {
    // This DiffUtil takes in a diffCallback, telling the DiffUtil how to see if the contents
    // in the list are the same or if the contents are the same, in order to determine
    // which items have been added, modified or deleted
    public ViewHolderAdapterTemplate(@NonNull DiffUtil.ItemCallback<String> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ViewHolderTemplate onCreateViewHolder(ViewGroup parent, int viewType) {
        // overriding the original create implementation of recycler view to our custom implementation
        return ViewHolderTemplate.create(parent);
    }

    @Override
    public void onBindViewHolder(ViewHolderTemplate holder, int position) {
        // overriding the original data binding implementation of recycler view to our custom implementation
        // using getItem(position), recycler view will know which viewHolder we are currently at, allowing us to bind the data to the right viewHolder
        String current = getItem(position);
        holder.bind(current);
    }

    // overriding the diff checker for recycler view to recycle their view
    // this allows recycler view to know which view is newly added and which only needs an update
    static class NoteDiff extends DiffUtil.ItemCallback<String> {

        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }
    }
}
