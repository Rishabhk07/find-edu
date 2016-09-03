package com.example.rishabhkhanna.code_n_counter.UIs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rishabhkhanna.code_n_counter.Models.Discussion;
import com.example.rishabhkhanna.code_n_counter.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Discussion_Group extends AppCompatActivity {

    ArrayList<Discussion> myList;
    ListAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion__group);

        listView = (ListView) findViewById(R.id.list_view);
        myList = new ArrayList<>();
        adapter = new ListAdapter(myList);



    }


    public class ListAdapter extends BaseAdapter{

        private ArrayList<Discussion> mList;

        public ListAdapter(ArrayList<Discussion> mList) {
            this.mList = mList;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Discussion getItem(int i) {
            return mList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = getLayoutInflater();
            view = layoutInflater.inflate(R.layout.list_item_chat,null);

            TextView tv1 = (TextView) view.findViewById(R.id.username);
            TextView tv2 = (TextView) view.findViewById(R.id.message);


            Discussion discussion = mList.get(i);

            tv1.setText(discussion.getUser());
            tv2.setText(discussion.getMessage());


            return view;
        }
    }

}
