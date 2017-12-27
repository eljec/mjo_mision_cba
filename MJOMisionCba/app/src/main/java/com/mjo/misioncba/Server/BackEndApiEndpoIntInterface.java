package com.mjo.misioncba.Server;

import com.mjo.misioncba.model.Sections;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jucastillo on 24/12/17.
 */

public interface BackEndApiEndpoIntInterface
{
    @GET("/sections.json")
    Call<Sections> getConfigurationSection();
}
