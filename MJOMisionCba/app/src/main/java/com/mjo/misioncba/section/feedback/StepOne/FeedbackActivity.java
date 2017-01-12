package com.mjo.misioncba.section.feedback.StepOne;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.mjo.misioncba.R;
import com.mjo.misioncba.section.feedback.stepTwo.FeedbackActivityStepTwo;

import java.util.List;
import java.util.Map;

public class FeedbackActivity extends AppCompatActivity implements FeedbackStepOneListRecyclerViewAdapter.OnFeedbackListStartChangeListener {

    private FloatingActionButton fab;
    private FeedbackStepOneListRecyclerViewAdapter adapterList;
    private List<ItemFeedbackModelList> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danos tu opinion..");

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isInfoCompleted()){
                    // Step 2
                    goToNextStep();
                }else{
                    // Show error
                     Snackbar.make(view, "Te queda alguna sin calificar !! :)", Snackbar.LENGTH_LONG)
                        .show();
                }
            }
        });

        RecyclerView  recyclerView = (RecyclerView) findViewById(R.id.feedback_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemFeedbackModelListGenerator generator = new ItemFeedbackModelListGenerator();
        data = generator.getData(this);

        adapterList = new FeedbackStepOneListRecyclerViewAdapter(data, this);

        recyclerView.setAdapter(adapterList);

        // Default hide

        this.fab.setVisibility(View.GONE);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    private boolean isInfoCompleted(){

        return true;
    }

    private void goToNextStep(){

        Intent stepTwo = new Intent(getApplicationContext(), FeedbackActivityStepTwo.class);
        //stepTwo.putParcelableArrayListExtra();

        Bundle bndlAnimation =
                ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.anim1,R.anim.anim2).toBundle();
        startActivity(stepTwo, bndlAnimation);
    }

    @Override
    public void onFeedbackListStartChange(Map<String, Float> selectedValues) {

        // Ver si esta toda la lista cargada, en tal caso mostrar el fab button

        if(data.size() == selectedValues.size()){
            fab.setVisibility(View.VISIBLE);

            // Generator the items para la proxima activity

        }else{
            fab.setVisibility(View.GONE);
        }
    }

    private void generateDataForStepTwo(Map<String, Float> selectedValues){



    }
}
