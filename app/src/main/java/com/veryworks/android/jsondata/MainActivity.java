package com.veryworks.android.jsondata;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.veryworks.android.jsondata.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        load();
    }

    private void load(){
        // data 변수에 불러온 데이터를 입력
        new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                String str = Remote.getData("https://api.github.com/users");
                return str;
            }
            @Override
            protected void onPostExecute(String jsonString) {
                // jsonString 을 parsing
                data = parse(jsonString);
                setList();
            }
        }.execute();
    }

    private List<User> parse(String string){
        List<User> result = new ArrayList<>();
        // 앞의 문자 두개 없애기 [ {
        string = string.substring( string.indexOf("{")+1 );
        // 뒤의 문자 두개 없애기 } ]
        string = string.substring(0, string.lastIndexOf("}"));
        // 문자열 분리하기
        String array[] = string.split("\\},\\{");
        for(String item : array){
            User user = new User();
            // item 문자열을 분리해서 user의 멤버변수에 담는다
            //result.add(user);
            System.out.println(item);
        }
        return result;
    }

    List<User> data;
    private void setList(){
        ListAdapter adapter = new ListAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
