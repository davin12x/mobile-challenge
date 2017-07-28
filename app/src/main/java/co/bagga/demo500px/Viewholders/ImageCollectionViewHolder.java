package co.bagga.demo500px.Viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.R;

/**
 * Created by bagga on 2017-07-26.
 *
 * View Holder used in Image Collection
 */

public class ImageCollectionViewHolder extends RecyclerView.ViewHolder {

    private ImageView mProductImageView;
    private TextView mProductNameTextView, mFollowersCountTextView;

    public ImageCollectionViewHolder(View itemView) {
        super(itemView);

        mProductImageView = itemView.findViewById(R.id.product_image);
        mProductNameTextView = itemView.findViewById(R.id.product_name);
        mFollowersCountTextView = itemView.findViewById(R.id.follower_count);
    }

    public void updateView(Photo photo) {
        mProductNameTextView.setText(photo.getName());
        mFollowersCountTextView.setText(photo.getVotes_count());
        if (photo.getImages().length != 0) {
            Picasso.with(itemView.getContext()).load(photo.getImages()[0].getUrl()).into(mProductImageView);
        }
    }
}
