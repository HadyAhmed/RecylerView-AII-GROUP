package com.example.names;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NamesAdapter adapter;
    private RecyclerView recyclerView;
    private List<Name> nameList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));
        nameList.add(new Name("Hadi", "asdadsads"));

        recyclerView = findViewById(R.id.name_rv);

        adapter = new NamesAdapter(new OnNameClickListener() {
            @Override
            public void sendName(Name name) {
                Toast.makeText(MainActivity.this, name.getName(), Toast.LENGTH_SHORT).show();
            }
        }, nameList);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_about:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }
    }
}
