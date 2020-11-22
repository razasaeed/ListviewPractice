package razi.constructor.listviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView studentsLV;
    String[] students = {"Ali", "Ahmed", "Hassan", "Haseeb"};
    String[] contacts = {"123", "456", "789", "121"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsLV = findViewById(R.id.studentsLV);
        StudentsAdapter adapter = new StudentsAdapter();
        studentsLV.setAdapter(adapter);

        studentsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }

    public class StudentsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return students.length;
        }

        @Override
        public Object getItem(int i) {
            return students[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater obj = LayoutInflater.from(viewGroup.getContext());
            View row = obj.inflate(R.layout.child_view, viewGroup, false);

            TextView nameTxt = row.findViewById(R.id.nameTxt);
            TextView contactTxt = row.findViewById(R.id.contactTxt);

            nameTxt.setText(students[i]);
            contactTxt.setText(contacts[i]);

            return row;
        }
    }

}