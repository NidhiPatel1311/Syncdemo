package com.example.tech_5.syncdemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomListActivity extends Activity {

    static final String URL = "http://iexist.in/techofi.com/NidhiTest/androiddemo/music.xml";
    //    // XML node keys
    static final String KEY_SONG = "song"; // parent node
    static final String KEY_ID = "id";
    static final String KEY_TITLE = "title";
    static final String KEY_ARTIST = "artist";
    static final String KEY_DURATION = "duration";
    static final String KEY_THUMB_URL = "thumb_url";

    ListView list;
    LazyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        new TheTask().execute(URL);
        list=(ListView)findViewById(R.id.list);
       setListView();
        }




    class TheTask extends AsyncTask<String,String,String> {

//        @Override
//        protected String onPostExecute(Void result) {
//            // TODO Auto-generated method stub
//
//        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
            try {


                XMLParser parser = new XMLParser();
                String xml = parser.getXmlFromUrl(URL); // getting XML from URL
                Document doc = parser.getDomElement(xml); // getting DOM element

                NodeList nl = doc.getElementsByTagName(KEY_SONG);
                // looping through all song nodes &lt;song&gt;
                for (int i = 0; i<nl.getLength(); i++) {
                    // creating new HashMap
                    HashMap<String, String> map = new HashMap<String, String>();
                    Element e = (Element) nl.item(i);
                    // adding each child node to HashMap key =&gt; value
                    map.put(KEY_ID, parser.getValue(e, KEY_ID));
                    map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
                    map.put(KEY_ARTIST, parser.getValue(e, KEY_ARTIST));
                    map.put(KEY_DURATION, parser.getValue(e, KEY_DURATION));
                    map.put(KEY_THUMB_URL, parser.getValue(e, KEY_THUMB_URL));

                    // adding HashList to ArrayList
                    songsList.add(map);


                }
            } catch (Exception e) {
                return "Network problem";
            }
                return null;
        }

    }


   void setListView(){
    // Getting adapter by passing xml data ArrayList
       list=(ListView)findViewById(R.id.list);

       ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    adapter=new LazyAdapter(this, songsList);
            list.setAdapter(adapter);

    // Click event for single list row
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
        int position, long id) {

        }
    });
    }
}
