package com.example.jaman.onnline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class RadioActivity extends AppCompatActivity {
    int[] IMAGES ={R.drawable.dhakafm,R.drawable.foorti,R.drawable.jago,R.drawable.radiotoday,R.drawable.spice,R.drawable.radionext,R.drawable.shadhin,
            R.drawable.durbar,R.drawable.bhubon,R.drawable.betar};
    String[] NAMES = {"Dhaka FM ","Radio Foorti ","Jago FM","Radio Today","Spice FM ","Radio Next","Radio Shadhin","Radio Durbar","Radio Vubon","Radio Betar"};
    String[] DESCRIPTIONS = {"90.4"," 88.0","94.4","89.6","96.4","93.2","92.4","92.8","90.1","100.0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        ListView listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.activity_list_item,android.R.id.text1,NAMES);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
          if(i == 0){
           Intent k = new Intent(view.getContext(),Channel1.class);
             startActivityForResult(k,0);
           }

           if(i == 1){
                    Intent k = new Intent(view.getContext(),Channel2.class);
                    startActivityForResult(k,1);
                }

            if(i == 2){
                    Intent k = new Intent(view.getContext(),Channel3.class);
                    startActivityForResult(k,2);
                }

                if(i == 3){
                    Intent k = new Intent(view.getContext(),Channel4.class);
                    startActivityForResult(k,3);
                }

                if(i == 4){
                    Intent k = new Intent(view.getContext(),Channel5.class);
                    startActivityForResult(k,4);
                }

                if(i == 5){
                    Intent k = new Intent(view.getContext(),Channel6.class);
                    startActivityForResult(k,5);
                }

                if(i == 6){
                    Intent k = new Intent(view.getContext(),Channel7.class);
                    startActivityForResult(k,6);
                }

                if(i == 7){
                    Intent k = new Intent(view.getContext(),Channel8.class);
                    startActivityForResult(k,7);
                }

                if(i == 8){
                    Intent k = new Intent(view.getContext(),Channel9.class);
                    startActivityForResult(k,8);
                }

                if(i == 9){
                    Intent k = new Intent(view.getContext(),Channel10.class);
                    startActivityForResult(k,9);
                }

            }
        });


        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView_description);
            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);


            return view;

        }
    }


}
