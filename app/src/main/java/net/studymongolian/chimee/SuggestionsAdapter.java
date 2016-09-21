package net.studymongolian.chimee;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class SuggestionsAdapter extends RecyclerView.Adapter<SuggestionsAdapter.ViewHolder> {


    private List<String> mData = Collections.emptyList();
    private LayoutInflater mInflater;
    //private Context mContext;
    MongolUnicodeRenderer renderer = MongolUnicodeRenderer.INSTANCE;

    public SuggestionsAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Context context = parent.getContext();
        //inflater = LayoutInflater.from(context);

        View view = mInflater.inflate(R.layout.suggestions_recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String currentWord = mData.get(position);
        String renderedText = renderer.unicodeToGlyphs(currentWord);
        holder.tvWord.setText(renderedText);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvWord;

        public ViewHolder(View itemView) {
            super(itemView);
            tvWord = (TextView) itemView.findViewById(R.id.tvRecyclerViewSuggestedWord);
        }
    }
}