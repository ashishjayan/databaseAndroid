package com.ashishjayan.trash2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ListView;
    //private com.ashishjayan.trash2.ListViewAdapter;
   // private listView
    private DBhelper DBhelper;
    private List<Task> taskList;
    private TextView Title;
    private ListView ListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewAdapter=(ListView) findViewById(R.id.list_view);
        Title =(TextView) findViewById(R.id.showTitle);
        DBhelper= new DBhelper(this);
        taskList= new ArrayList<>();
        reloadingDatabase();

    }

    public void reloadingDatabase() {
        taskList= DBhelper.getALLTASK();

        if (taskList.size()==0){
            Toast.makeText(this,  " No task in record ", Toast.LENGTH_LONG).show();

        }

        Adapter adapter = new com.ashishjayan.trash2.ListView)this, R.layout.item_listview, taskList, DBhelper,
        ListView.setAdapter(adapter);
    }


    // this is for dynamic alert.....
    private void addNewTaskAlertDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity. this);
        alertDialog.setTitle ("Add a course Task");


        LinearLayout layout= new LinearLayout(this);
        layout.setPadding(10, 10 , 10, 10);
        layout.setOrientation(LinearLayout.VERTICAL);
        final EditText courseBox= new EditText(this );
        courseBox.setHint("Enter course name: ");
        layout.addView(courseBox);

        final EditText infoBox= new EditText(this );
        courseBox.setHint("Enter the task info: ");
        layout.addView(infoBox);

        alertDialog.setView(layout);


        alertDialog.setPositiveButton(" ok ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Task task= new Task(getText(courseBox), getText(infoBox)));
            }
        });
    }

    private String getText(TextView textView) {
        return textView.getText().toString().trim();
    }

}
