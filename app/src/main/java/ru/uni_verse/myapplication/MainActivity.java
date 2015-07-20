package ru.uni_verse.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Person> mPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPeople = new ArrayList<>();
        mPeople.add(new Person("Adam Allen", "23", R.drawable.adam));
        mPeople.add(new Person("Brian Benjamen", "44", R.drawable.brian));
        mPeople.add(new Person("Charles Clive", "32", R.drawable.charles));
        mPeople.add(new Person("Dennis David", "42", R.drawable.adam));
        mPeople.add(new Person("Elijah Ellison", "19", R.drawable.brian));
        mPeople.add(new Person("Frederik Franklin", "26", R.drawable.charles));
        mPeople.add(new Person("Geralt Gerry", "40", R.drawable.adam));
        mPeople.add(new Person("Henry Hudson", "39", R.drawable.brian));
        mPeople.add(new Person("Ivan Idaho", "32", R.drawable.charles));
        mPeople.add(new Person("Adam Allen", "23", R.drawable.adam));
        mPeople.add(new Person("Brian Benjamen", "44", R.drawable.brian));
        mPeople.add(new Person("Charles Clive", "32", R.drawable.charles));
        mPeople.add(new Person("Dennis David", "42", R.drawable.adam));
        mPeople.add(new Person("Elijah Ellison", "19", R.drawable.brian));
        mPeople.add(new Person("Frederik Franklin", "26", R.drawable.charles));
        mPeople.add(new Person("Geralt Gerry", "40", R.drawable.adam));
        mPeople.add(new Person("Henry Hudson", "39", R.drawable.brian));
        mPeople.add(new Person("Ivan Idaho", "32", R.drawable.charles));

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter = new RVAdapter(mPeople);
        rv.setAdapter(adapter);

        //Web request
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://api.theysaidso.com/qod.json").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    if (response.isSuccessful()){
                        Log.v("OkHttp", response.body().string());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
