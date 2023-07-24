package com.example.myapplication.Interfaces;

import com.example.myapplication.Models.PerfilModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Path;

public interface ApiUser {
    @GET("user/{id}")
    Call<List<PerfilModel>> getProfile(@Path("id") String id);
}