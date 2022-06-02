package com.example.deplegable;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Glidedd extends AppCompatActivity {

    ImageView imgdescarga;
    Bundle extra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);


        referenciar();

    }

    private void referenciar() {

        imgdescarga = findViewById(R.id.imgdescarga);
        extra= getIntent().getExtras();
        String urldescarga = extra.getString("URL");

        Glide.with(Glidedd.this)
                .load("http://i.imgur.com/Vth6CBz.gif")
                .load(urldescarga)
                .fitCenter()
                .centerCrop()

                //.listener(new RequestListener<Bitmap>() {

                // @Override
                // public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                //  return false;
                //}
                // public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                //    return false;
                //}
                // @Override
                //public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                //  return false;
                //  onPalette(Palette.from(resource).generate());
                //  imgdescarga.setImageBitmap(resource);
                //}
                // public void onPalette(Palette palette) {
                //  if (null != palette) {
                //ViewGroup parent = (ViewGroup) imgdescarga.getParent().getParent();
                // parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY));
                //}
                // }

                //})
                .into(imgdescarga);




    }
}