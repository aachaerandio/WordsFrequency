package com.aachaerandio.wordsfrequency.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aachaerandio.wordsfrequency.R;
import com.aachaerandio.wordsfrequency.Utils;
import com.aachaerandio.wordsfrequency.model.WordItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder>{
    private final List<WordItem> wordList;

    public WordAdapter(List<WordItem> wordList) {
        this.wordList = wordList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_word, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WordItem wordItem = wordList.get(position);
        holder.wordId.setText(wordItem.getWord());
        holder.frequency.setText(wordItem.getFrequency());
        if(Utils.isPrime(wordItem.getFrequency())) {
            holder.isPrime.setText(R.string.prime);
        } else {
            holder.isPrime.setText(R.string.no_prime);
        }
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.word_id) TextView wordId;
        @BindView(R.id.word_frequency) TextView frequency;
        @BindView(R.id.is_prime) TextView isPrime;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
