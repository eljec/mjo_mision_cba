package com.mjo.misioncba.Server;

import com.mjo.misioncba.model.Sections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jucastillo on 27/12/17.
 */

public class SectionDataSource implements DataSource
{
    private DataSourceDelegate delegate;

    public SectionDataSource(DataSourceDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void loadData()
    {
        BackEndApiEndpoIntInterface apiService = getApi();

        Call<Sections> call = apiService.getConfigurationSection();
        call.enqueue(new Callback<Sections>() {
            @Override
            public void onResponse(Call<Sections> call, Response<Sections> response) {

                Sections itineraryServiceResponse = response.body();
                delegate.loadSuccess(itineraryServiceResponse);
            }

            @Override
            public void onFailure(Call<Sections> call, Throwable t) {
                delegate.loadFail(t);
            }
        });
    }

    protected BackEndApiEndpoIntInterface getApi()
    {
        // Make Request to API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mjo-mision-cba.firebaseio.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BackEndApiEndpoIntInterface apiService =
                retrofit.create(BackEndApiEndpoIntInterface.class);

        return apiService;
    }
}
