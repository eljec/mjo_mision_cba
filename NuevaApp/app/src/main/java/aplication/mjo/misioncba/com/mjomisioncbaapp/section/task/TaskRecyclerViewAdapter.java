package aplication.mjo.misioncba.com.mjomisioncbaapp.section.task;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Reading.GenericTextContentModel;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Task.SectionTask;
import aplication.mjo.misioncba.com.mjomisioncbaapp.model.Task.TaskDay;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter{

    SectionTask section;

    public TaskRecyclerViewAdapter (SectionTask section){
        this.section = section;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_task_list_item, parent, false);
        return new TaskItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TaskItemViewHolder ownHolder = (TaskItemViewHolder) holder;

        TaskDay day = section.getDays().get(position);
        ownHolder.mTitleView.setText(day.getDayTitle());

        // HTML
        String content = processContentModel(day.getTask());
        Spanned mainContent = Html.fromHtml(content);
        ownHolder.mContentView.setText(mainContent);
    }

    @Override
    public int getItemCount() {
        return this.section.getDays().size();
    }

    private String processContentModel (GenericTextContentModel model) {

        StringBuilder textBuilder = new StringBuilder();

        for (String line : model.getArrayTextLines()) {
            textBuilder.append(line);

            if(model.getArrayTextLines().size() > 1){
                textBuilder.append("<br>");
                if(model.isDoubleBrakeLine()) {
                    textBuilder.append("<br>");
                }
            }
        }

        return  textBuilder.toString();
    }

    public class TaskItemViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mContentView;

        public TaskItemViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.task_item_title);
            mContentView = (TextView) view.findViewById(R.id.task_item_content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
