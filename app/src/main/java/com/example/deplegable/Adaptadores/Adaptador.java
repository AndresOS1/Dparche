package com.example.deplegable.Adaptadores;

/*import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deplegable.R;
import com.example.deplegable.model.Locati;
import com.example.deplegable.model.Publicaciones;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;*/

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.deplegable.R;
import com.example.deplegable.model.Locati;
import com.example.deplegable.model.Publicaciones;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import io.grpc.Context;

public class Adaptador extends FirestoreRecyclerAdapter<Publicaciones, Adaptador.ViewHolder> {


    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adaptador(@NonNull  FirestoreRecyclerOptions<Publicaciones> options) {

        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Publicaciones model) {
        holder.txtFecha.setText("" + model.getFecha());
        holder.descripcion.setText("" + model.getOpinion());
        holder.ubicacion.setText("" + model.getUbicacion());


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_publicaciones, parent , false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomUsuario, txtFecha, descripcion, ubicacion;
        ImageView perfil, publicacion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomUsuario = (itemView).findViewById(R.id.nomUsuario);
            txtFecha = (itemView).findViewById(R.id.txtFecha);
            descripcion = (itemView).findViewById(R.id.descripcion);
            ubicacion = (itemView).findViewById(R.id.ubicacion);

           perfil = (itemView).findViewById(R.id.imgPerfil);
           publicacion = (itemView).findViewById(R.id.imgPublicacion);

        }
    }
}





















/*


public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Publicaciones> model;

    //listener
    private View.OnClickListener listener;

    public Adaptador(Context context, ArrayList<Publicaciones> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_publicaciones, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String descripcion = model.get(position).getDescripcion();
        String ubicacion = model.get(position).getUbicacion();
        int image = model.get(position).getFoto();

        holder.descripcion.setText(descripcion);
        holder.ubicacion.setText(ubicacion);
        holder.foto.setImageResource(image);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView descripcion, ubicacion;
        ImageView foto;
        Spinner  cate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            descripcion = itemView.findViewById(R.id.descripcion);
            ubicacion = itemView.findViewById(R.id.ubicacion);
            foto = itemView.findViewById(R.id.Imagen);

        }
    }
}

*/
