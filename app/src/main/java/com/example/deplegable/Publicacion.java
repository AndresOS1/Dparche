package com.example.deplegable;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Publicacion extends AppCompatActivity {

    ImageView img;
    TextView urlimagen;
    Button enviar,cargar , descargar;
    String id, urldescargada;



    int indice=0;

    private Uri imageUri = null ;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        img= findViewById(R.id.imagenURL);
//        imgbtnUno= findViewById(R.id.imgbtnUno);

        referenciar();
//        tomarfto();

    }

//    private void tomarfto() {
//        imgbtnUno.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                // if (intent.resolveActivity(getPackageManager()) != null) {
//                File imagenArchivo = null;
//                try {
//                    imagenArchivo = crearImagen();
//                } catch (Exception x) {
//                    x.printStackTrace();
//                }
//
//                if (imagenArchivo != null) {
//                    Uri fotoUri = FileProvider.getUriForFile(Publicacion.this, "com.example.deplegable", imagenArchivo);
//                    intent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri);
//                    startActivityForResult(intent, 1);
//                    imageUri = fotoUri;
//                }
//            }
//        });
//    }
//
//    private File crearImagen() throws IOException {
//        String nombreImagen = "fotoLugar";
//        File directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File imagen = File.createTempFile(nombreImagen, ".jpg", directorio);
//        rutaImagen = imagen.getAbsolutePath();
//        return imagen;
//    }

    private void referenciar() {


        FirebaseStorage storage= FirebaseStorage.getInstance();
        // Create a Cloud Storage reference from the app
        StorageReference storageRef = storage.getReference();

        StorageReference spaceRef= storageRef.child("drawable/fondo.jpg");

        urlimagen= findViewById(R.id.Urlimagen);
        cargar= findViewById(R.id.Cargar);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),10);
            }
        });



        enviar= findViewById(R.id.Enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Get the data from an ImageView as bytes
                indice= indice+1;
                id=String.valueOf(indice);

                long timestamp = System.currentTimeMillis();
                String filePathAndName = "images/" + timestamp;

                StorageReference storageReference = FirebaseStorage.getInstance().getReference(filePathAndName);
                storageReference.putFile(imageUri)
                        .addOnSuccessListener(taskSnapshot -> {
                            Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!uriTask.isSuccessful());
                            String uploadedImageUri = "" + uriTask.getResult();
                            urldescargada = uploadedImageUri;
                            //sendList(uploadedImageUri, timestamp);

                            Toast.makeText(Publicacion.this, "Foto enviada correctamente ", Toast.LENGTH_LONG).show();
                            urlimagen.setText(uploadedImageUri);


                        }).addOnFailureListener(e -> {

                });
            }
        });

        descargar = findViewById(R.id.descargar);
        descargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Publicacion.this,Glidedd.class);
                intent.putExtra("URL",urldescargada);
                startActivity(intent);
            }

        });

    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        Publicacion.super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==10){



            assert data != null;
            imageUri= data.getData();
            img.setImageURI(data.getData());


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
