package com.vz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private static final int capacity = 8;
    private String[] coordXY;
    private TextView textView;
    private TableLayout tableLayout;
    private Button button;
    private static HashMap<String, TextView> listTextViews = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListener();
        filllistTextViews(listTextViews);
    }

    public void addListener() {
        tableLayout = (TableLayout) findViewById(R.id.tableBase);
        button = (Button) findViewById(R.id.button);
        tableLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanValues(listTextViews);
                coordXY = getXYqueensCoord(capacity);
                for (String i : coordXY) {
                    textView = listTextViews.get(i);
                    textView.setText("Q");
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public String[] getXYqueensCoord(int capacity) {

        int x;
        int count = 0;
        String[] coordXY = new String[capacity];
        int[][] placeXY;

        while (count < capacity) {
            count = 0;
            placeXY = new int[capacity][capacity];

            for (int i = 0; i < capacity; i++) {
                int[] temp = availableCells(placeXY[i]);
                if (temp.length > 1) {
                    x = temp[(int) (Math.random() * temp.length)];
                    fillPlace(placeXY, x, i);
                    coordXY[count++] = "" + x + i;
                } else if (temp.length == 1) {
                    x = temp[0];
                    fillPlace(placeXY, x, i);
                    coordXY[count++] = "" + x + i;
                }
            }
        }
        return coordXY;
    }

    public void fillPlace(int[][] placeXY, int x, int y) {
        int count = 0;
        for (int[] row : placeXY) {
            row[x] = 1;
            if (count++ == y) {
                for (int i = 0; i < row.length; i++) {
                    row[i] = 1;
                }
            }
        }
        for (int i = x, j = y; i >= 0 && j < capacity; i--, j++) {
            placeXY[j][i] = 1;
        }
        for (int i = x, j = y; i < capacity && j < capacity; i++, j++) {
            placeXY[j][i] = 1;
        }
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            placeXY[j][i] = 1;
        }
        for (int i = x, j = y; i < capacity && j >= 0; i++, j--) {
            placeXY[j][i] = 1;
        }

    }

    public int[] availableCells(int[] array) {
        int[] result;
        int count = 0;
        for (int i : array) {
            if (i == 0) count++;
        }
        result = new int[count];
        count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                result[count] = i;
                count++;
            }
        }
        return result;
    }

    public void cleanValues(HashMap<String, TextView> listTextViews) {
        for (int i = 0; i < capacity; i++) {
            for (int j = 0; j < capacity; j++) {
                textView = listTextViews.get("" + j + i);
                textView.setText("");
            }
        }

    }

    public void filllistTextViews(HashMap<String, TextView> listTextViews) {
        listTextViews.put("00", (TextView) findViewById(R.id.txt00));
        listTextViews.put("10", (TextView) findViewById(R.id.txt10));
        listTextViews.put("20", (TextView) findViewById(R.id.txt20));
        listTextViews.put("30", (TextView) findViewById(R.id.txt30));
        listTextViews.put("40", (TextView) findViewById(R.id.txt40));
        listTextViews.put("50", (TextView) findViewById(R.id.txt50));
        listTextViews.put("60", (TextView) findViewById(R.id.txt60));
        listTextViews.put("70", (TextView) findViewById(R.id.txt70));
        listTextViews.put("01", (TextView) findViewById(R.id.txt01));
        listTextViews.put("11", (TextView) findViewById(R.id.txt11));
        listTextViews.put("21", (TextView) findViewById(R.id.txt21));
        listTextViews.put("31", (TextView) findViewById(R.id.txt31));
        listTextViews.put("41", (TextView) findViewById(R.id.txt41));
        listTextViews.put("51", (TextView) findViewById(R.id.txt51));
        listTextViews.put("61", (TextView) findViewById(R.id.txt61));
        listTextViews.put("71", (TextView) findViewById(R.id.txt71));
        listTextViews.put("02", (TextView) findViewById(R.id.txt02));
        listTextViews.put("12", (TextView) findViewById(R.id.txt12));
        listTextViews.put("22", (TextView) findViewById(R.id.txt22));
        listTextViews.put("32", (TextView) findViewById(R.id.txt32));
        listTextViews.put("42", (TextView) findViewById(R.id.txt42));
        listTextViews.put("52", (TextView) findViewById(R.id.txt52));
        listTextViews.put("62", (TextView) findViewById(R.id.txt62));
        listTextViews.put("72", (TextView) findViewById(R.id.txt72));
        listTextViews.put("03", (TextView) findViewById(R.id.txt03));
        listTextViews.put("13", (TextView) findViewById(R.id.txt13));
        listTextViews.put("23", (TextView) findViewById(R.id.txt23));
        listTextViews.put("33", (TextView) findViewById(R.id.txt33));
        listTextViews.put("43", (TextView) findViewById(R.id.txt43));
        listTextViews.put("53", (TextView) findViewById(R.id.txt53));
        listTextViews.put("63", (TextView) findViewById(R.id.txt63));
        listTextViews.put("73", (TextView) findViewById(R.id.txt73));
        listTextViews.put("04", (TextView) findViewById(R.id.txt04));
        listTextViews.put("14", (TextView) findViewById(R.id.txt14));
        listTextViews.put("24", (TextView) findViewById(R.id.txt24));
        listTextViews.put("34", (TextView) findViewById(R.id.txt34));
        listTextViews.put("44", (TextView) findViewById(R.id.txt44));
        listTextViews.put("54", (TextView) findViewById(R.id.txt54));
        listTextViews.put("64", (TextView) findViewById(R.id.txt64));
        listTextViews.put("74", (TextView) findViewById(R.id.txt74));
        listTextViews.put("05", (TextView) findViewById(R.id.txt05));
        listTextViews.put("15", (TextView) findViewById(R.id.txt15));
        listTextViews.put("25", (TextView) findViewById(R.id.txt25));
        listTextViews.put("35", (TextView) findViewById(R.id.txt35));
        listTextViews.put("45", (TextView) findViewById(R.id.txt45));
        listTextViews.put("55", (TextView) findViewById(R.id.txt55));
        listTextViews.put("65", (TextView) findViewById(R.id.txt65));
        listTextViews.put("75", (TextView) findViewById(R.id.txt75));
        listTextViews.put("06", (TextView) findViewById(R.id.txt06));
        listTextViews.put("16", (TextView) findViewById(R.id.txt16));
        listTextViews.put("26", (TextView) findViewById(R.id.txt26));
        listTextViews.put("36", (TextView) findViewById(R.id.txt36));
        listTextViews.put("46", (TextView) findViewById(R.id.txt46));
        listTextViews.put("56", (TextView) findViewById(R.id.txt56));
        listTextViews.put("66", (TextView) findViewById(R.id.txt66));
        listTextViews.put("76", (TextView) findViewById(R.id.txt76));
        listTextViews.put("07", (TextView) findViewById(R.id.txt07));
        listTextViews.put("17", (TextView) findViewById(R.id.txt17));
        listTextViews.put("27", (TextView) findViewById(R.id.txt27));
        listTextViews.put("37", (TextView) findViewById(R.id.txt37));
        listTextViews.put("47", (TextView) findViewById(R.id.txt47));
        listTextViews.put("57", (TextView) findViewById(R.id.txt57));
        listTextViews.put("67", (TextView) findViewById(R.id.txt67));
        listTextViews.put("77", (TextView) findViewById(R.id.txt77));
    }
}
