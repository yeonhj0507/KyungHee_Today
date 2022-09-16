package com.example.khapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {

    private View decorView;
    private int	uiOption;

    String key = "16c6ed183ccf402dbff0d174ff8a04d7";
    TextView mealtext;
    String APIcontent;
    String lunchmeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility( uiOption );

        mealtext = (TextView) findViewById(R.id.mealtext);

        new Thread(() -> {

            //날짜를 String으로
            LocalDate date = LocalDate.now();
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            int dayOfWeekNumber = dayOfWeek.getValue();
            switch (dayOfWeekNumber) {
                case 6:
                    date = date.plusDays(2);
                    break;
                case 7:
                    date = date.plusDays(1);
                    break;
                default:
                    break;
            }
            String dt = String.valueOf(LocalDate.parse(date.toString()));
            String[] str = dt.split("-");
            dt = "";
            for (String s : str) dt += s;

            try {

                URL url = new URL("https://open.neis.go.kr/hub/mealServiceDietInfo?key="
                        + key + "&Type=jsonp&Index=1&pSize=100&ATPT_OFCDC_SC_CODE=B10&SD_SCHUL_CODE=7010126&MLSV_FROM_YMD=" + dt + "&MLSV_TO_YMD=" + dt);

                BufferedReader bf;

                bf = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

                APIcontent = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(APIcontent);
                JSONArray mealServiceDietInfo = (JSONArray) jsonObject.get("mealServiceDietInfo");
                JSONObject info = (JSONObject) mealServiceDietInfo.get(1);
                JSONArray row = (JSONArray) info.get("row");
                JSONObject lunch = (JSONObject) row.get(0);

                lunchmeal = (String) lunch.get("DDISH_NM");

                lunchmeal = lunchmeal.replace("<br/>","\n" );

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mealtext.setText(lunchmeal);
                        mealtext.setTextSize(20);
                    }
                });
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }



        }).start();


    }
}