package com.example.practical_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderTemplate extends RecyclerView.ViewHolder {
    private final TextView text;

    private ViewHolderTemplate(View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.TVContent);
    }

    public void bind(String contentText) {
        text.setText(contentText);
    }

    // This is only creating the container without the data populated, the population of the data will happen on bind
    static ViewHolderTemplate create(ViewGroup parent) {
        // The second parameter in the inflate method tells which viewGroup the inflated view will be attached to, in this case is the recyclerView itself since we pass in parent
        // the third parameter is to tell if the inflated view should be attached to the parent, we set it to false to let recyclerView handle attachment of view
        // during the onBindViewHolder callback. This is because by default when views go off the screen it is recycled, and then if we attach this view here,
        // the view might be empty or have old data attached to it, so instead of us doing the attaching of view ourselves, we rely on the onBindViewHolder callback
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_item_view, parent, false);
        return new ViewHolderTemplate(view);
    }
}
