package co.bagga.demo500px.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import co.bagga.demo500px.Adapters.ImageCollectionAdapter;
import co.bagga.demo500px.Events.PhotoSearchHttpResponseEvent;
import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.Network.PhotoHttpApi;
import co.bagga.demo500px.R;
import co.bagga.demo500px.Utils.Constants;
import co.bagga.demo500px.Utils.PaginationScrollListener;

public class PhotoCollectionActivity extends AppCompatActivity {

    private ImageCollectionAdapter imageCollectionAdapter;
    private int totalPagesCount = 0;
    private RecyclerView mImageCollectionRecyclerView;
    private final String SEARCH_NAME = "bike";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_collection);

        setupRecyclerView();
        generatePhotoSearchHttpRequest(SEARCH_NAME, Constants.DEFAULT_IMAGE_SIZE, totalPagesCount);
    }

    private void setupRecyclerView() {
        mImageCollectionRecyclerView = (RecyclerView)findViewById(R.id.imageCollectionRecylerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mImageCollectionRecyclerView.setLayoutManager(gridLayoutManager);
        mImageCollectionRecyclerView.setHasFixedSize(true);
        imageCollectionAdapter = new ImageCollectionAdapter();
        mImageCollectionRecyclerView.setAdapter(imageCollectionAdapter);
        mImageCollectionRecyclerView.addOnScrollListener(new PaginationScrollListener(gridLayoutManager) {
            @Override
            protected void loadMoreItems() {
                totalPagesCount += 1;
                generatePhotoSearchHttpRequest(SEARCH_NAME, Constants.DEFAULT_IMAGE_SIZE, totalPagesCount);
            }

            @Override
            public int getTotalPageCount() {
                return totalPagesCount;
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        });
    }

    private void generatePhotoSearchHttpRequest(String searchName, int imageSize, int pageNumber) {
        PhotoHttpApi.getInstance(this).buildSearchPhotoRequest(searchName, imageSize, pageNumber);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPhotoSearchHttpResponseReceived(PhotoSearchHttpResponseEvent event) {
        ArrayList<Photo> photos = PhotoHttpApi.photos;
        imageCollectionAdapter.updateAdapter(photos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.IMAGE_REQUEST_INTENT_CODE) {
            if(resultCode == Activity.RESULT_OK){
                int imagePosition = data.getIntExtra(Constants.IMAGE_POSITION_BUNDLE_KEY, 0);
                mImageCollectionRecyclerView.smoothScrollToPosition(imagePosition);
            }
        }
    }
}
