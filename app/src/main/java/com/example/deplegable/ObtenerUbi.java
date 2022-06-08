package com.example.deplegable;

import static android.content.ContentValues.TAG;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.deplegable.model.Locati;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ObtenerUbi extends AppCompatActivity {

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
        btnUbi = findViewById(R.id.btnUbicacion);
        longi = findViewById(R.id.Longitud);
        lati = findViewById(R.id.Latitud);

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

                Intent intent = new Intent(ObtenerUbi.this, MapaUbi.class);
                startActivity(intent);

            }


        });
    }
}
