package com.mjo.misioncba.Server;

import com.mjo.misioncba.model.SectionMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jucastillo on 6/1/18.
 */

public class SectionMessageDataSource implements DataSource
{
    private DataSourceDelegate delegate;

    public SectionMessageDataSource(DataSourceDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void loadData()
    {
        BackEndApiEndpoIntInterface apiService = getApi();

        Call<SectionMessage> call = apiService.getSectionMessage();
        call.enqueue(new Callback<SectionMessage>() {
            @Override
            public void onResponse(Call<SectionMessage> call, Response<SectionMessage> response) {

                SectionMessage sectionMessage = response.body();
                delegate.loadSuccess(sectionMessage);
            }

            @Override
            public void onFailure(Call<SectionMessage> call, Throwable t) {
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
