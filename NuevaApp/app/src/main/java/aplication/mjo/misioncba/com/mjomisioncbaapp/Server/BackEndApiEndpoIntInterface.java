package aplication.mjo.misioncba.com.mjomisioncbaapp.Server;


import aplication.mjo.misioncba.com.mjomisioncbaapp.model.SectionMessage;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Sections;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jucastillo on 24/12/17.
 */

public interface BackEndApiEndpoIntInterface
{
    @GET("/sections.json")
    Call<Sections> getConfigurationSection();

    @GET("/sections/messages.json")
    Call<SectionMessage> getSectionMessage();
}
