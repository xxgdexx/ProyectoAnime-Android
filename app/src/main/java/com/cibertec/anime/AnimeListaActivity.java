package com.cibertec.anime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.cibertec.anime.adapter.AnimeAdapter;
import com.cibertec.anime.api.ServiceAnimeApi;
import com.cibertec.anime.entity.Anime;
import com.cibertec.anime.util.ConnectionRest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.widget.Button;

public class AnimeListaActivity extends AppCompatActivity {

    List<Anime> lstData= new ArrayList<Anime>();
    AnimeAdapter adaptador=null;
    ListView lstView = null;
    ServiceAnimeApi api=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_lista);
   lstView = findViewById(R.id.idListaAnime);
   adaptador= new AnimeAdapter(this,R.layout.activity_anime_item,lstData);
   lstView.setAdapter(adaptador);

   api= ConnectionRest.getConnection().create(ServiceAnimeApi.class);

   lista();

    }

    public void lista(){
        Call<List<Anime>> call=api.listaAnime();
        call.enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Anime>> call, Response<List<Anime>> response) {
                if (response.isSuccessful()){
                    List<Anime> lista =   response.body();
                    mensaje("LOG 2->  Cantidad Recibida : " + lista.size());
                    lstData.clear();
                    lstData.addAll(lista);
                    adaptador.notifyDataSetChanged();
                }else{
                    mensaje("ERROR -> Error en la respuesta");
                }
            }
            @Override
            public void onFailure(retrofit2.Call<List<Anime>> call, Throwable t) {
                mensaje("ERROR -> Error en la respuesta");
            }
        });

    }
    void mensaje(String msg){
        Toast toast1= Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast1.show();
    }
}