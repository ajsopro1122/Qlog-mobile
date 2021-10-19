package com.example.qlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookAppointment extends AppCompatActivity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> buildingCollection;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        createGroupList();
        createCollection();
        expandableListView = findViewById(R.id.elvBuildings);
        expandableListAdapter = new MyExpandableListAdapter(this, groupList, buildingCollection);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int lastExpandedPosition = -1;
            @Override
            public void onGroupExpand(int i) {
                if(lastExpandedPosition != -1 && i != lastExpandedPosition) {
                    expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = i;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String selected = expandableListAdapter.getChild(i, i1).toString();
                Toast.makeText(getApplicationContext(), "Selected " + selected, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void createCollection() {
        String[] college = {"Cashier", "Cast Department", "Registrar Office", "Scholarship Office"};
        String[] highschool = {"Nurse Office", "Principal’s Office"};
        String[] elementary = {"Elementary Library", "Canteen"};
        buildingCollection = new HashMap<String, List<String>>();
        for(String group : groupList) {
            if (group.equals("College Building")) {
                loadChild(college);
            }else if(group.equals("Highschool Building"))
                loadChild(highschool);
            else
                loadChild(elementary);

            buildingCollection.put(group, childList);
        }
    }

    private void loadChild(String[] buildings) {
        childList = new ArrayList<>();
        for(String building : buildings) {
            childList.add(building);
        }
    }

    private void createGroupList() {
        groupList = new ArrayList<>();
        groupList.add("College Building");
        groupList.add("Highschool Building");
        groupList.add("Elementary Building");
    }


}