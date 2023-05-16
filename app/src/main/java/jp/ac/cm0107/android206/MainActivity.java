package jp.ac.cm0107.android206;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnJson = findViewById(R.id.btnJson);
        btnJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Item> items = JsonHelper.parseJson(getData());
                StringBuffer sb = new StringBuffer();
                for(Item item : items){
                    sb.append(item.getId() + "\n");
                    sb.append(item.getTitle() + "\n");
                    sb.append(item.getThumbnail_url() + "\n");
                    sb.append(item.getDescription() + "\n");
                    sb.append("###############################");
                }
                TextView txtContents = findViewById(R.id.txtContents);
                txtContents.setText(sb.toString());
            }
        });
        Button btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtContents = findViewById(R.id.txtContents);
                txtContents.setText("");

            }
        });
    }
    private String getData() {
        String json = "";
        BufferedReader br = null;
        try{
            InputStream in = getAssets().open("sample.json");
            br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine())!= null){
                sb.append(line);
            }
            json = sb.toString();
        }catch (Exception e){
            Log.e("MainActivity", Log.getStackTraceString(e));
        }finally {
            try {
                if(br != null)br.close();
            }catch (IOException e){
                Log.e("MainActivity", Log.getStackTraceString(e));
            }
        }
        return json;
    }
}