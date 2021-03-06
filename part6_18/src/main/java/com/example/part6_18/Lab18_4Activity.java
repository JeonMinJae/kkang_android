package com.example.part6_18;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Lab18_4Activity extends AppCompatActivity implements View.OnClickListener{
    Button btn;
    CoordinatorLayout coordinatorLayout;
    BottomSheetBehavior<View> persistentBottomSheet;
    BottomSheetDialog modalBottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab18_4);

        coordinatorLayout=findViewById(R.id.lab4_coordinator);
        btn=findViewById(R.id.lab4_button);
        btn.setOnClickListener(this);

        initPeristentBottomSheet();
    }

    private void initPeristentBottomSheet(){
        View bottomSheet=coordinatorLayout.findViewById(R.id.lab4_bottom_sheet);
        persistentBottomSheet=BottomSheetBehavior.from(bottomSheet);
    }

    @Override
    public void onClick(View v) {
        createDialog();
    }
    private void createDialog(){
        List<DataVO> list=new ArrayList<>();

        DataVO vo=new DataVO();
        vo.title="Keep";
        vo.image=ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_1, null);
        list.add(vo);

        vo=new DataVO();
        vo.title="Inbox";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_2, null);
        list.add(vo);

        vo=new DataVO();
        vo.title="Messanger";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_3, null);
        list.add(vo);

        vo=new DataVO();
        vo.title="Google+";
        vo.image= ResourcesCompat.getDrawable(getResources(), R.drawable.ic_lab4_4, null);
        list.add(vo);

        Lab4RecyclerViewAdapter adapter=new Lab4RecyclerViewAdapter(list);
        View view=getLayoutInflater().inflate(R.layout.lab4_modal_sheet, null);
        RecyclerView recyclerView=view.findViewById(R.id.lab4_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        modalBottomSheet=new BottomSheetDialog(this);
        modalBottomSheet.setContentView(view);
        modalBottomSheet.show();
    }
}
