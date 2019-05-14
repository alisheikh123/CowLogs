package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    Controllerdb controldb;
    SQLiteDatabase db;
    private ArrayList<String> Id = new ArrayList<String>();
    private ArrayList<String> Name = new ArrayList<String>();
    private ArrayList<String> MailId = new ArrayList<String>();
    private ArrayList<String> Age = new ArrayList<String>();
    private ArrayList<String> date = new ArrayList<String>();
    private ArrayList<String> longitude = new ArrayList<String>();
    private ArrayList<String> latitude = new ArrayList<String>();
    public CustomAdapter(Context  context,ArrayList<String> Id,ArrayList<String> Name, ArrayList<String> MailId,ArrayList<String> Age
    ,ArrayList<String> date,ArrayList<String> longitude,ArrayList<String> latitude)
    {
        this.mContext = context;
        this.Id = Id;
        this.Name = Name;
        this.MailId = MailId;
        this.Age=Age;
        this.date=date;
        this.longitude =longitude;
        this.latitude = latitude;
    }
    @Override
    public int getCount() {
        return Id.size();
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final    viewHolder holder;
        controldb =new Controllerdb(mContext);
        LayoutInflater layoutInflater;
        if (convertView == null) {
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout, null);
            holder = new viewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.tvid);
            holder.name = (TextView) convertView.findViewById(R.id.tvname);
            holder.mail = (TextView) convertView.findViewById(R.id.tvmailid);
            holder.age = (TextView) convertView.findViewById(R.id.tvage);
            holder.condition = (TextView) convertView.findViewById(R.id.tvcondition);
            holder.date = (TextView) convertView.findViewById(R.id.tvdate);
            holder.latitude = (TextView) convertView.findViewById(R.id.tvlatitude);
            holder.longitude = (TextView) convertView.findViewById(R.id.tvlongitude);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        holder.id.setText(Id.get(position));
        holder.name.setText(Name.get(position));
        holder.mail.setText(MailId.get(position));
        holder.age.setText(Age.get(position));
        return convertView;
    }
    public class viewHolder {
        public TextView longitude;
        public TextView latitude;
        public TextView date;
        public TextView condition;
        TextView id;
        TextView name;
        TextView mail;
        TextView age;
    }

}
