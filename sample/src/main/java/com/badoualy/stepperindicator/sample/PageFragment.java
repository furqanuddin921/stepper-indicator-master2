package com.badoualy.stepperindicator.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PageFragment extends Fragment {

//    private TextView lblPage;

    private Button next, prev;
    private static ViewPager mpager;
    private static int mposition;
    private LinearLayout form1, form2;

    public static PageFragment newInstance(int page, boolean isLast, ViewPager pager, int position) {
        Bundle args = new Bundle();
        args.putInt("page", position);
        mpager = pager;
        mposition = position;
        if (isLast)
            args.putBoolean("isLast", true);
        final PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_page, container, false);
//        lblPage = (TextView) view.findViewById(R.id);

        next = (Button) view.findViewById(R.id.next);
        prev = (Button) view.findViewById(R.id.prev);
        form1 = (LinearLayout) view.findViewById(R.id.form1);
        form2 = (LinearLayout) view.findViewById(R.id.formdua);

        System.out.printf("==");

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final int page = getArguments().getInt("page", 0);


        
        System.out.printf("mposition: "+ page);

        if(page == 1){
            form1.setVisibility(View.GONE);
            form2.setVisibility(View.VISIBLE);
        }else if(page == 2){
            form1.setVisibility(View.VISIBLE);
            form2.setVisibility(View.GONE);
        }else if(page == 3){
            form1.setVisibility(View.GONE);
            form2.setVisibility(View.VISIBLE);
        }else if(page == 4){
            form1.setVisibility(View.VISIBLE);
            form2.setVisibility(View.GONE);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpager.setCurrentItem(page+1, true);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpager.setCurrentItem(page-1, true);
            }
        });

//        if (getArguments().containsKey("isLast"))
//            lblPage.setText("You're done!");
//        else
//            lblPage.setText(Integer.toString(page));
    }
}