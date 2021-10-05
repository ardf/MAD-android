package com.example.jsonandxmlparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv_json,tv_xml;
    Button btn_json,btn_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_json = findViewById(R.id.tv_json);
        tv_xml = findViewById(R.id.tv_xml);
        btn_json = findViewById(R.id.btn_json);
        btn_xml = findViewById(R.id.btn_xml);
    }

    public void parseJson(View view) {
        String json;
        StringBuilder sb = new StringBuilder();
        try{
            InputStream isj = getAssets().open("city.json");
            int size = isj.available();
            byte[] buffer = new byte[size];
            isj.read(buffer);
            json = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(json);
            sb.append("JSON Data");
            sb.append("\n-------------\n");
            JSONArray jsonArray = jsonObject.getJSONArray("city_array");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsObjInArr = jsonArray.getJSONObject(i);
                sb.append("\nName: ").append(jsObjInArr.getString("name"));
                sb.append("\nLatitude: ").append(jsObjInArr.getString("lat"));
                sb.append("\nLongitude: ").append(jsObjInArr.getString("lon"));
                sb.append("\nTemperature: ").append(jsObjInArr.getString("temp"));
                sb.append("\nHumidity: ").append(jsObjInArr.getString("humidity"));
                sb.append("\n-----------\n");
            }
            isj.close();
            tv_json.setText((sb.toString()));
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Error in JSON parsing",Toast.LENGTH_SHORT).show();
        }
    }

    public void parseXml(View view) {
        StringBuilder sbx = new StringBuilder();
        try {
            InputStream isx = getAssets().open("city.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(isx);

            sbx.append("XML Data");
            sbx.append("\n-----------\n");
            NodeList nodeList = document.getElementsByTagName("city");
            for(int i=0;i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                if(node.getNodeType()== Node.ELEMENT_NODE){
                    Element element = (Element)node;
                    sbx.append("\nName: ").append(getValue("name",element));
                    sbx.append("\nLatitude: ").append(getValue("lat",element));
                    sbx.append("\nLongitude: ").append(getValue("lon",element));
                    sbx.append("\nTemperature: ").append(getValue("temp",element));
                    sbx.append("\nHumidity: ").append(getValue("humidity",element));
                    sbx.append("\n-----------\n");
                }
            }
            tv_xml.setText(sbx.toString());
            isx.close();


        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Error in XML parsing", Toast.LENGTH_SHORT).show();
        }
    }

    private String getValue(String tag, Element element) {
        return element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}