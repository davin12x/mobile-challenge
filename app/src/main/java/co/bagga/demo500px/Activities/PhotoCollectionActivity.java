package co.bagga.demo500px.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import co.bagga.demo500px.Adapters.ImageCollectionAdapter;
import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.R;

public class PhotoCollectionActivity extends AppCompatActivity {

    private ImageCollectionAdapter imageCollectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_collection);

        RecyclerView mImageCollectionRecyclerView = (RecyclerView)findViewById(R.id.imageCollectionRecylerView);
        mImageCollectionRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mImageCollectionRecyclerView.setHasFixedSize(true);
        imageCollectionAdapter = new ImageCollectionAdapter();
        mImageCollectionRecyclerView.setAdapter(imageCollectionAdapter);
    }

}
