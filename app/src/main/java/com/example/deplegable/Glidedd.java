package com.example.deplegable;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.deplegable.model.Locati;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Glidedd extends AppCompatActivity {

    ImageView imgdescarga;
    Bundle extra;
    Button eliminar;
    TextView direc;

    Button btnUbi;
    EditText longi, lati;
    LocationManager locationManager;
    Location location;
    private static final int VALUE_UBI = 200;

    @RequiresApi(api = Build.VERSION_CODES.M)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);


        referenciar();
        referenciar2();
        verificarPermiso();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void verificarPermiso() {
        int PermisoUbi = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (PermisoUbi == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, VALUE_UBI);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case VALUE_UBI: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    referenciar();
                } else {
                    Toast.makeText(this, "PORFAVOR", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void referenciar() {

        eliminar=findViewById(R.id.eliminar);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Glidedd.this,  Publicacion.class);
                Toast.makeText(Glidedd.this, "Foto eliminada correctamente ", Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });

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
    private void referenciar2() {
        btnUbi = findViewById(R.id.btnUbicacion);
        longi = findViewById(R.id.Longitud);
        lati = findViewById(R.id.Latitud);
        direc = findViewById(R.id.direccion);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


        btnUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lati.setText("" + String.valueOf(location.getLatitude()));
                longi.setText("" + String.valueOf(location.getLongitude()));
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> direccion = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);
                    System.out.println(direccion.get(0).getAddressLine(0 ));/**/
                    direc.setText(direccion.get(0).getAddressLine(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Double latit = Double.parseDouble(lati.getText().toString());
                Double lon = Double.parseDouble(longi.getText().toString());

                Locati loca = new Locati(latit,lon);

                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Localizacion").add(loca).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference doc) {
                        Log.d(TAG, "CORRECTO" + doc.getId());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "ERROR", e);
                    }
                });

                Intent intent = new Intent(Glidedd.this, MapaUbi.class);
                startActivity(intent);

            }


        });
    }
}