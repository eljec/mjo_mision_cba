package com.mjo.misioncba.section;

import android.Manifest;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.MenuItem;
import android.widget.Toast;

import com.mjo.misioncba.R;
import com.mjo.misioncba.model.UrlFIle;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * Created by jucastillo on 27/12/17.
 */

public class DonwloadFragment extends Fragment
{
    private static final int REQUEST_STORAGE = 1;
    private DownloadManager downloadManager;
    private long enqueue;

    protected String titleNotificationDownload;
    protected String filenameDownload;
    protected String titleAlertMessage;

    protected UrlFIle url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.download_content:
               showDownloadAlertView(titleAlertMessage);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_STORAGE) {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                downloadFile();
            } else  {
                Toast.makeText(getActivity(), "Necesitamos que nos des permisos para descargar contenido desde la app :)", Toast.LENGTH_SHORT).show();
            }
        }
    }

    protected void downloadFileFromUrl()
    {
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_STORAGE);
        } else {
            downloadFile();
        }
    }

    protected void showDownloadAlertView(String title)
    {
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getActivity(), android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(getActivity());
        }

        builder.setMessage(title);
        builder.setCancelable(true);

        builder.setPositiveButton(
                R.string.multimedia_image_detail_modal_options_yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        // Download image
                        downloadFileFromUrl();
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton(
                R.string.multimedia_image_detail_modal_options_no,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDownload = builder.create();
        alertDownload.show();
    }

    private void downloadFile() {
        downloadManager = (DownloadManager) getActivity().getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url.getLink()));

        //Setting title of request
        String title = "Decargando archivo";

        if(titleNotificationDownload != null && titleNotificationDownload.isEmpty() == false)
        {
            title = titleNotificationDownload;
        }
        request.setTitle(title);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        String name = filenameDownload + "." + url.getExtension();

        //Save file to destination folder
        request.setDestinationInExternalPublicDir("/Downloads", name);
        enqueue = downloadManager.enqueue(request);
    }
}
