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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.deplegable.R;
import com.example.deplegable.model.Locati;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Adaptador extends FirestoreRecyclerAdapter<Locati, Adaptador.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Adaptador(@NonNull FirestoreRecyclerOptions<Locati> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Locati model) {
        holder.lati.setText("" + model.getLatitud());
        holder.longi.setText("" + model.getLongitud());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_publicaciones, parent , false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lati, longi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lati = (itemView).findViewById(R.id.latitud);
            longi = (itemView).findViewById(R.id.longitud);
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
