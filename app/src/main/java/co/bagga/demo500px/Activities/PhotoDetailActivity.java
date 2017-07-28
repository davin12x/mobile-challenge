package co.bagga.demo500px.Activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.bagga.demo500px.Adapters.PageAdapter;
import co.bagga.demo500px.R;
import co.bagga.demo500px.Utils.Constants;

public class PhotoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        Bundle bundle = getIntent().getExtras();
        if (!bundle.containsKey(Constants.IMAGE_POSITION)) {
            throw new RuntimeException("Must pass image position");
        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        int imagePosition = bundle.getInt(Constants.IMAGE_POSITION);
        viewPager.setAdapter(new PageAdapter(this));
        viewPager.setCurrentItem(imagePosition);
    }
}
