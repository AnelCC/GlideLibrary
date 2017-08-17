package cc.anel.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity {

    ImageView img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8,
            img_9, img_10, img_11, img_12;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        img_1 = (ImageView) findViewById(R.id.img_1);
        img_2 = (ImageView) findViewById(R.id.img_2);
        img_3 = (ImageView) findViewById(R.id.img_3);
        img_4 = (ImageView) findViewById(R.id.img_4);
        img_5 = (ImageView) findViewById(R.id.img_5);
        img_6 = (ImageView) findViewById(R.id.img_6);
        img_7 = (ImageView) findViewById(R.id.img_7);
        img_8 = (ImageView) findViewById(R.id.img_8);
        img_9 = (ImageView) findViewById(R.id.img_9);
        img_10= (ImageView) findViewById(R.id.img_10);
        img_11= (ImageView) findViewById(R.id.img_11);
        img_12= (ImageView) findViewById(R.id/**/.img_12);
    }

    public void loadImg1(View view){
        Glide.with(this).
                load("http://orig06.deviantart.net/0fc7/f/2011/362/a/b/avatar___chibi_katara_by_katta2-d4kgzl0.png").
                into(img_1);
    }

    public void loadImg2(View view){
        Glide.with(this).
                load("http://orig01.deviantart.net/6e69/f/2012/236/1/1/avatar_aang_by_kirin_48-d5cb7h3.png").
                override(500, 200). // resizes the image to 100x200 pixels but does not respect aspect ratio
                into(img_2);
    }
    public void loadImg3(View view){
        Glide.with(this)
                .load("http://s6.picofile.com/file/8196001350/Fire_Nation_Toph.png")
                .placeholder(R.drawable.animal2)
                .error(R.drawable.avatar)
                .into(img_3);
    }
    public void loadImg4(View view) {
        Glide.with(this)
                .load("http://img05.deviantart.net/6d66/i/2015/104/a/6/avatar__the_last_airbender___appa_and_cabbage_by_soffeed-d8b9z91.jpg")
                .centerCrop()// scale to fill the ImageView and crop any extra
                .into(img_4);
    }
    public void loadImg5(View view) {
        Glide.with(this)
                .load("http://68.media.tumblr.com/tumblr_m7l4ydcfSx1ru98x0o7_250.png")
                .override(800, 200)
                .fitCenter() // scale to fit entire image within ImageView
                .into(img_5);
    }
    public void loadImg6(View view) {
        Glide.with(this)
                .load("https://img05.deviantart.net/e8e9/i/2013/177/c/7/the_legend_of_aang__suki_portrait_by_dejakob-d6aqc20.png")
                .override(300, Target.SIZE_ORIGINAL) // resizes width to 100, preserves original height, does not respect aspect ratio
                .into(img_6);
    }
    public void loadImg7(View view) {
        Glide.with(this)
                .load("http://orig08.deviantart.net/ffca/f/2014/251/e/b/uncle_iroh_icon_by_curiouslyxinlove-d7yf27n.png")
                .placeholder(R.drawable.animal1)
                .error(R.drawable.animal2)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        // log exception
                        //Toast.makeText(this, "Error loading image"+ e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.e("TAG", "Error loading image", e);
                        return false; // important to return false so the error placeholder can be placed
                    }
                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(img_7);
    }

    public void loadImg8(View view) {
        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
        Glide.with(this)
                .load("http://i32.beon.ru/42/84/1048442/27/46568927/Hello_Momo_by_Booter_Freak.png")
                .bitmapTransform(new RoundedCornersTransformation(this, radius, margin))
                .into(img_8);
    }
    public void loadImg9(View view) {
        Glide.with(this)
                .load("https://jasmineshanelle.files.wordpress.com/2015/09/02-top-10-avatar-the-last-airbender-best-characters-sokka.jpg")
                .bitmapTransform(new CropCircleTransformation(this))
                .into(img_9);
    }
    public void loadImg10(View view) {
        Glide.with(this)
                .load("https://68.media.tumblr.com/772e27c5da24a1f4b4ea3f2807afcf73/tumblr_o8kjzcbNiS1vx7xuwo1_500.jpg")
                .bitmapTransform(new BlurTransformation(this))
                .into(img_10);
    }
    public void loadImg11(View view) {
        Glide.with(this)
                .load("https://s-media-cache-ak0.pinimg.com/236x/9a/92/d0/9a92d0c635f72a07fcc96026287c1592--avatar-chibi-avatar-aang.jpg")
                .bitmapTransform(new BlurTransformation(this, 25), new CropCircleTransformation(this))
                .into(img_11);
    }

    public void loadImg12(View view) {
        progressBar.setVisibility(View.VISIBLE);

        Glide.with(this)
                .load("https://i.pinimg.com/736x/9a/8f/ac/9a8fac8c63d30eb67d587ebc42e1d5fb--avatar-the-last-airbender-avatar-aang.jpg")
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false; // important to return false so the error placeholder can be placed
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(img_12);
    }


    public void loadImg13(View view) {


        Glide.with(this)
                .load("https://i.pinimg.com/736x/9a/8f/ac/9a8fac8c63d30eb67d587ebc42e1d5fb--avatar-the-last-airbender-avatar-aang.jpg")
                .asBitmap()
                .into(target);

       /* Glide.with(this)
                .load("http://img05.deviantart.net/6d66/i/2015/104/a/6/avatar__the_last_airbender___appa_and_cabbage_by_soffeed-d8b9z91.jpg")
                .centerCrop()// scale to fill the ImageView and crop any extra
                .into(img_4);*/
    }

    private SimpleTarget target = new SimpleTarget<Bitmap>() {
        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
            // do something with the bitmap
            // set it to an ImageView
            img_12.setImageBitmap(bitmap);
        }
    };


}
