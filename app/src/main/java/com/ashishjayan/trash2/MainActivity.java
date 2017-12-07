package com.ashishjayan.trash2;

<<<<<<< HEAD
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
=======
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    public ListView;
    //private com.ashishjayan.trash2.ListViewAdapter;
   // private listView
    private DBhelper DBhelper;
    private List<Task> taskList;
    private TextView Title;
    private ListView ListViewAdapter;
=======

    private ListView listView;
    private ListViewAdapter adapter;
    private DBhelper DBhelper;
    private List<Task> taskList;
    private TextView title;
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        ListViewAdapter=(ListView) findViewById(R.id.list_view);
        Title =(TextView) findViewById(R.id.showTitle);
        DBhelper= new DBhelper(this);
        taskList= new ArrayList<>();
        reloadingDatabase();

=======
        listView = (ListView) findViewById(R.id.list_view);
        title = (TextView)findViewById(R.id.total);

        DBhelper = new DBhelper(this);
        taskList = new ArrayList<>();
        reloadingDatabase(); //loading table of DB to ListView

    }

    public void reloadingDatabase() {
        taskList = DBhelper.getALLTASK();
        if (taskList.size() == 0) {
            Toast.makeText(this, "No record found in database!", Toast.LENGTH_SHORT).show();
            title.setVisibility(View.GONE);
        }
        adapter = new ListViewAdapter(this, R.layout.item_listview, taskList, DBhelper);
        listView.setAdapter(adapter);
        title.setVisibility(View.VISIBLE);
        title.setText("Total records: " + DBhelper.getContactsCount());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            addingnewTaskDialog();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void addingnewTaskDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Add a new Task");

        LinearLayout layout = new LinearLayout(this);
        layout.setPadding(10, 10, 10, 10);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText courseBox = new EditText(this);
        courseBox.setHint("Task");
        layout.addView(courseBox);

        final EditText description = new EditText(this);
        description.setHint("Description");
        layout.addView(description);

        alertDialog.setView(layout);

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Task task = new Task(getText(courseBox), getText(description));
                DBhelper.addTASK(task);

                reloadingDatabase(); //reload the db to view
            }
        });

        alertDialog.setNegativeButton("Cancel", null);

        //show alert
        alertDialog.show();
    }

    //get text available in TextView/EditText
    private String getText(TextView textView) {
        return textView.getText().toString().trim();
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
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

