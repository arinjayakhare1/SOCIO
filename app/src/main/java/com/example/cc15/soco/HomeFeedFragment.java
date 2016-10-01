package com.example.cc15.soco;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cc15.soco.Adapters.FeedAdapter;
import com.example.cc15.soco.DataModels.Post;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeFeedFragment extends Fragment {
    private ArrayList<Object> getSampleArrayList(){
        ArrayList<Object> items = new ArrayList<>();
        items.add(new Post("Dany Targaryen"));
        items.add(new Post("Rob Stark"));
        items.add("image");
        items.add(new Post("Jon Snow"));
        items.add("image");
        items.add(new Post("Tyrion Lanister"));
        return items;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_feed, container, false);


        final RecyclerView rvPosts = (RecyclerView) view.findViewById(R.id.rvPosts);
        FeedAdapter adapter = new FeedAdapter(getSampleArrayList());
        rvPosts.setAdapter(adapter);
        adapter.setOnItemClickListener(new FeedAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, int post_type) {
//                String name = getSampleArrayList().get(position).name;
                if(post_type==1) {
                    String name;
                    TextView label = (TextView) view.findViewById(R.id.text1);
                    name = label.getText().toString();
   //                 Toast.makeText(getContext(), name + " text post was clicked!", Toast.LENGTH_SHORT).show();
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    ft.replace(R.id.frame_placeholder, new FragmentPostText());
                    ft.addToBackStack("bhai");
                    ft.commit();
//                    rvPosts.setVisibility(View.INVISIBLE);
                }

                else{
  //                  Toast.makeText(getContext(),  "image post was clicked!", Toast.LENGTH_SHORT).show();
                    FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                    ft.replace(R.id.frame_placeholder, new FragmentPostImage());
                    ft.addToBackStack("bhai");
                    ft.commit();
                }

            }
        });
        // Set layout manager to position the items
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        // That's all!





        return view;

    }
}
