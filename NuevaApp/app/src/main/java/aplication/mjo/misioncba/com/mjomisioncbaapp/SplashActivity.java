package aplication.mjo.misioncba.com.mjomisioncbaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import aplication.mjo.misioncba.com.mjomisioncbaapp.Server.DataSourceDelegate;
import aplication.mjo.misioncba.com.mjomisioncbaapp.Server.SectionDataSource;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Sections;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class SplashActivity extends AppCompatActivity  implements DataSourceDelegate {

    private SectionDataSource sectionDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_splash);

        sectionDataSource = new SectionDataSource(this);
        sectionDataSource.loadData();

    }

    @Override
    public void loadSuccess(Object result)
    {
        //Save it on application object and go to next activity

        MisionCbaApplication application = ((MisionCbaApplication) getApplication());
        application.setSections((Sections) result);

        // Open main activity
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
        finish();
    }

    @Override
    public void loadFail(Object error)
    {
        // Show modal error and exit app
        showErrorAlertView();
    }

    protected void showErrorAlertView()
    {
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        builder.setMessage("Error al traer los datos de inicio, intentalo mas tarde");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                        finish();
                    }
                });

        AlertDialog alertDownload = builder.create();
        alertDownload.show();
    }
}
