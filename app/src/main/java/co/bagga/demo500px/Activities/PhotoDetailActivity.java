package co.bagga.demo500px.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.bagga.demo500px.Adapters.PageAdapter;
import co.bagga.demo500px.Interfaces.PageChangeListener;
import co.bagga.demo500px.Model.Photo;
import co.bagga.demo500px.Model.User;
import co.bagga.demo500px.Network.PhotoHttpApi;
import co.bagga.demo500px.R;
import co.bagga.demo500px.Utils.CircleTransform;
import co.bagga.demo500px.Utils.Constants;

public class PhotoDetailActivity extends AppCompatActivity implements PageChangeListener {

    private PageAdapter pagerAdapter;
    private ImageView mUserImage;
    private TextView mUserName, mUserFollowerCount, mCountry;
    private ArrayList<Photo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        prepareViews();

        Bundle bundle = getIntent().getExtras();
        if (!bundle.containsKey(Constants.IMAGE_POSITION_BUNDLE_KEY)) {
            throw new RuntimeException("Must pass image position");
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        int imagePosition = bundle.getInt(Constants.IMAGE_POSITION_BUNDLE_KEY);
        photos = PhotoHttpApi.photos;
        pagerAdapter = new PageAdapter(getApplicationContext(), photos, this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(imagePosition);
    }

    private void prepareViews() {
        mUserImage = (ImageView)findViewById(R.id.imageView);
        mUserName = (TextView)findViewById(R.id.user_name);
        mCountry = (TextView)findViewById(R.id.country);
        mUserFollowerCount = (TextView)findViewById(R.id.followers);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constants.IMAGE_POSITION_BUNDLE_KEY, pagerAdapter.getCurrentPagePosition());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateView(Photo photo) {
        User user = photo.getUser();
        mUserName.setText(user.getFullname());
        mCountry.setText(user.getCountry());
        mUserFollowerCount.setText(getString(R.string.number_of_followers, user.getFollowers_count()));

        Picasso.with(this).load(user.getUserpic_url()).transform(new CircleTransform()).into(mUserImage);
    }

    @Override
    public void onPageChanged(int position) {
        updateView(photos.get(position));
    }
}
