package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShowNeighbourActivity extends AppCompatActivity {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.nameView)
    TextView nameView;
    @BindView(R.id.listName)
    TextView listName;
    @BindView(R.id.listAdress)
    TextView listAdress;
    @BindView(R.id.listTel)
    TextView listTel;
    @BindView(R.id.listMail)
    TextView listMail;
    @BindView(R.id.contentAbout)
    TextView contentAbout;
    @BindView(R.id.add_fav)
    FloatingActionButton addFav;

    Neighbour neighbour;
    private NeighbourApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_neighbour);
        ButterKnife.bind(this);
        mApiService = DI.getNeighbourApiService();
        init();
    }

    /**
     * Init the neighbour
     */
    public void init(){
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            neighbour = (Neighbour) extras.getSerializable("neighbour");
            String image = neighbour.getAvatarUrl().replace("150","450");
            String facebook = "www.facebook.fr/" +neighbour.getName().toLowerCase();

            Glide.with(imageView.getContext())
                    .load(image)
                    .into(imageView);
            nameView.setText(neighbour.getName());
            listName.setText(neighbour.getName());
            listAdress.setText(neighbour.getAddress());
            listTel.setText(neighbour.getPhoneNumber());
            listMail.setText(facebook);
            contentAbout.setText(neighbour.getAboutMe());

            if(neighbour.getFav()){
                changeStar(true);
            } else {
                changeStar(false);
            }
        }
    }

    @OnClick(R.id.add_fav)
    protected void addFavorite() {
        if(neighbour.getFav()){
            neighbour.setFav(false);
            changeStar(false);
        } else {
            neighbour.setFav(true);
            changeStar(true);
        }
        mApiService.editNeighbour(neighbour);
    }

    private void changeStar(Boolean fav){
        int colorFav = getResources().getColor(R.color.colorFav);
        if(fav){
            Drawable star = getDrawable(R.drawable.ic_star_white_24dp);
            star.setColorFilter(colorFav, PorterDuff.Mode.SRC_IN);
            addFav.setImageDrawable(star);
        } else {
            Drawable star = getDrawable(R.drawable.ic_star_border_white_24dp);
            star.setColorFilter(colorFav, PorterDuff.Mode.SRC_IN);
            addFav.setImageDrawable(star);
        }
    }

    @OnClick(R.id.backHome)
    protected void backHome(){
        finish();
    }
}
