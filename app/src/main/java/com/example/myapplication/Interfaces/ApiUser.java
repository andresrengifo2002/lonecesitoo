package com.example.myapplication.Interfaces;

import com.example.myapplication.Models.PerfilModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Path;

public interface ApiUser {
    @GET("user/{id}")
    Call<PerfilModel> getProfile(@Path("id") String id);
}