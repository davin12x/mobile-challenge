package co.bagga.demo500px.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.R;
import co.bagga.demo500px.Viewholders.ImageCollectionViewHolder;

/**
 * Created by bagga on 2017-07-26.
 *
 * Adapter to show image collection
 */

public class ImageCollectionAdapter extends RecyclerView.Adapter<ImageCollectionViewHolder> {

    private ArrayList<Photo> photoArrayList;

    public ImageCollectionAdapter() {
        photoArrayList = new ArrayList<>();
    }

    @Override
    public ImageCollectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_collection_layout, parent, false);
        return new ImageCollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageCollectionViewHolder holder, int position) {
        holder.updateView(photoArrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }

    public void updateAdapter(ArrayList<Photo> photoArrayList) {
        this.photoArrayList = photoArrayList;
        notifyDataSetChanged();
    }
}
