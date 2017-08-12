package com.aachaerandio.wordsfrequency.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aachaerandio.wordsfrequency.R;
import com.aachaerandio.wordsfrequency.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.word_list_id) RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        HomePresenter homePresenter = new HomePresenter();

        adapter = new WordAdapter(homePresenter.loadData());
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }
}
