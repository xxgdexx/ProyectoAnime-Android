package com.cibertec.anime.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.cibertec.anime.R;
import com.cibertec.anime.entity.Anime;


import java.util.List;

public class AnimeAdapter extends ArrayAdapter<Anime> {

    private Context context;
    private List<Anime> lista;

    public AnimeAdapter(@NonNull Context context, int resource,
                        @NonNull List<Anime> lista) {
        super(context, resource, lista);

        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View row = inflater.inflate(R.layout.activity_anime_item, parent, false);

        final Anime obj = lista.get(position);

        TextView txtId = row.findViewById(R.id.idItemAnimeId);
        txtId.setText(obj.getIdAnime());

        TextView txtimagen = row.findViewById(R.id.idItemAnimeImagen);
        txtimagen.setText(obj.getImagen());

        TextView txtatributo = row.findViewById(R.id.idItemAnimeNombre);
        txtatributo.setText(obj.getAtributo());




        return row;
    }
}