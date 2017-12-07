<<<<<<< HEAD
package com.ashishjayan.taskapp;
=======
package com.ashishjayan.trash2;
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.ashishjayan.trash2.MainActivity;
import com.ashishjayan.trash2.R;
import com.ashishjayan.trash2.Task;

=======
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
import java.util.List;

/**
 * Created by Ashish Jayan on 12/1/2017.
 */

<<<<<<< HEAD

=======
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
public class ListViewAdapter extends ArrayAdapter<Task> {

    private MainActivity activity;
    private DBhelper DBhelper;
<<<<<<< HEAD
    private List<Task> friendList;
=======
    private List<Task> taskList;
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

    public ListViewAdapter(MainActivity context, int resource, List<Task> objects, DBhelper helper) {
        super(context, resource, objects);
        this.activity = context;
        this.DBhelper = helper;
<<<<<<< HEAD
        this.friendList = objects;
=======
        this.taskList = objects;
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(getItem(position).getTitle());

        //Delete an item
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                DBhelper.deleteFriend(getItem(position)); //delete in db
=======

                DBhelper.deletetask(getItem(position)); //delete in db
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
                Toast.makeText(activity, "Deleted!", Toast.LENGTH_SHORT).show();

                //reload the database to view
                activity.reloadingDatabase();
            }
        });

        //Edit/Update an item
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
<<<<<<< HEAD
                alertDialog.setTitle("Update a Friend");
=======
                alertDialog.setTitle("Update a Task");
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

                LinearLayout layout = new LinearLayout(activity);
                layout.setPadding(10, 10, 10, 10);
                layout.setOrientation(LinearLayout.VERTICAL);

<<<<<<< HEAD
                final EditText nameBox = new EditText(activity);
                nameBox.setHint("Name");
                layout.addView(nameBox);

                final EditText jobBox = new EditText(activity);
                jobBox.setHint("job");
                layout.addView(jobBox);

                nameBox.setText(getItem(position).getTitle());
                jobBox.setText(getItem(position).getDescription());
=======
                final EditText courseBox = new EditText(activity);
                courseBox.setHint("Task");
                layout.addView(courseBox);

                final EditText description = new EditText(activity);
                description.setHint("Description");
                layout.addView(description);

                courseBox.setText(getItem(position).getTitle());
                description.setText(getItem(position).getDescription());
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

                alertDialog.setView(layout);

                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
<<<<<<< HEAD
                        Task task = new Task(nameBox.getText().toString(), jobBox.getText().toString());
=======
                        Task task = new Task(courseBox.getText().toString(), description.getText().toString());
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
                        task.setId(getItem(position).getId());
                        DBhelper.updateTask(task); //update to db
                        Toast.makeText(activity, "Updated!", Toast.LENGTH_SHORT).show();

                        //reload the database to view
                        activity.reloadingDatabase();
                    }
                });

                alertDialog.setNegativeButton("Cancel", null);

                //show alert dialog
                alertDialog.show();
            }
        });

        //show details when each row item clicked
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
<<<<<<< HEAD
                alertDialog.setTitle("Friend ");
=======
                alertDialog.setTitle("Task ");
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

                LinearLayout layout = new LinearLayout(activity);
                layout.setPadding(10, 10, 10, 10);
                layout.setOrientation(LinearLayout.VERTICAL);

<<<<<<< HEAD
                TextView nameBox = new TextView(activity);
                layout.addView(nameBox);

                TextView jobBox = new TextView(activity);
                layout.addView(jobBox);

                nameBox.setText("Friend name: " + getItem(position).getTitle());
                jobBox.setText("Friend job: " + getItem(position).getDescription());
=======
                TextView courseBox = new TextView(activity);
                layout.addView(courseBox);

                TextView description = new TextView(activity);
                layout.addView(description);

                courseBox.setText("Course name: " + getItem(position).getTitle());
                description.setText("Course Description: " + getItem(position).getDescription());
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d

                alertDialog.setView(layout);
                alertDialog.setNegativeButton("OK", null);

                //show alert
                alertDialog.show();
            }
        });

<<<<<<< HEAD
=======

>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
        return convertView;
    }

    private static class ViewHolder {
        private TextView name;
        private View btnDelete;
        private View btnEdit;

        public ViewHolder (View v) {
            name = (TextView)v.findViewById(R.id.item_name);
            btnDelete = v.findViewById(R.id.delete);
<<<<<<< HEAD
            btnEdit = v.findViewById(R.id.add);

=======
            btnEdit = v.findViewById(R.id.edit);
>>>>>>> 35b46c96d9bd37f04030b6be59d814a89f45443d
        }
    }
}