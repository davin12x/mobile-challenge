package co.bagga.demo500px.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.bagga.demo500px.Interfaces.PageChangeListener;
import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.Network.PhotoHttpApi;
import co.bagga.demo500px.R;

public class PageAdapter extends PagerAdapter {

    private LayoutInflater mLayoutInflater;
    private ArrayList<Photo> photos;
    private int currentPagePosition = 0;
    private PageChangeListener pageChangeListener;

    public PageAdapter(Context context, ArrayList<Photo> photos, PageChangeListener pageChangeListener) {
        this.pageChangeListener = pageChangeListener;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.photos = PhotoHttpApi.photos;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        currentPagePosition = position;
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = itemView.findViewById(R.id.pager_image_view);

        Photo photo = photos.get(position);
        Picasso.with(itemView.getContext()).load(photo.getImages()[0].getUrl()).into(imageView);

        container.addView(itemView);

        pageChangeListener.onPageChanged(position);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public int getCurrentPagePosition() {
        return currentPagePosition;
    }
}
