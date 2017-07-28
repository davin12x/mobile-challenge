package co.bagga.demo500px.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.bagga.demo500px.Activities.PhotoDetailActivity;
import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.R;
import co.bagga.demo500px.Utils.Constants;
import co.bagga.demo500px.Viewholders.ImageCollectionViewHolder;

/**
 * Created by bagga on 2017-07-26.
 * <p>
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
    public void onBindViewHolder(final ImageCollectionViewHolder holder, final int position) {
        holder.updateView(photoArrayList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = holder.itemView.getContext();
                Intent photoDetailActivity = new Intent(context, PhotoDetailActivity.class);
                photoDetailActivity.putExtra(Constants.IMAGE_POSITION_BUNDLE_KEY, holder.getAdapterPosition());
                ((Activity) context).startActivityForResult(photoDetailActivity, Constants.IMAGE_REQUEST_INTENT_CODE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }

    public void updateAdapter(ArrayList<Photo> photoArrayList) {
        this.photoArrayList = photoArrayList;
        notifyItemInserted(photoArrayList.size());
    }
}
