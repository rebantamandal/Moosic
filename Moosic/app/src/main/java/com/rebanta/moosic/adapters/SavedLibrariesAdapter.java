package com.rebanta.moosic.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.rebanta.moosic.R;
import com.rebanta.moosic.activities.ListActivity;
import com.rebanta.moosic.model.AlbumItem;
import com.rebanta.moosic.records.sharedpref.SavedLibraries;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SavedLibrariesAdapter extends RecyclerView.Adapter<SavedLibrariesAdapter.ViewHolder> {

    private final List<SavedLibraries.Library> data;

    public SavedLibrariesAdapter(List<SavedLibraries.Library> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View _v = View.inflate(parent.getContext(), R.layout.activity_list_song_item, null);
        _v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(_v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(data.get(position).name());
        holder.artist.setText(data.get(position).description());
        Picasso.get().load(Uri.parse(data.get(position).image())).into(holder.coverImage);

        holder.itemView.setOnClickListener(v -> {

            AlbumItem albumItem = new AlbumItem(
                    data.get(position).name(),
                    data.get(position).description(),
                    data.get(position).image(),
                    data.get(position).id()
            );

            if(data.get(position).isCreatedByUser()) {
                v.getContext().startActivity(new Intent(v.getContext(), ListActivity.class)
                        .putExtra("id", data.get(position).id())
                        .putExtra("data", new Gson().toJson(albumItem))
                        .putExtra("type", "playlist")
                        .putExtra("createdByUser", true)
                );
                return;
            }

            v.getContext().startActivity(new Intent(v.getContext(), ListActivity.class)
                    .putExtra("data", new Gson().toJson(albumItem))
                    .putExtra("type", data.get(position).isAlbum()?"album":"playlist")
                    .putExtra("id", data.get(position).id())
            );
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView coverImage;
        private final TextView title;
        private final TextView artist;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coverImage = itemView.findViewById(R.id.coverImage);
            title = itemView.findViewById(R.id.title);
            artist = itemView.findViewById(R.id.artist);
        }
    }
}
