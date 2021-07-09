package com.cibertec.anime.api;


import com.cibertec.anime.entity.Anime;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceAnimeApi {


    @GET("anime")
    public abstract Call<List<Anime>> listaAnime();

    @GET("anime/{id}")
    public abstract Call<Optional<Anime>> buscaAnime(String id);

    @POST("anime")
    public abstract Call<Anime> insertaAnime(@Body Anime obj);

    @PUT("anime")
    public abstract Call<Anime> actualizaAnime(@Body Anime obj);

    @DELETE("anime/{id}")
    public abstract Call<Anime> eliminaAnime(@Path("id")String id);


}
