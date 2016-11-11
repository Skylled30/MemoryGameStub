package com.example.root.memorygame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int[] cards = new int[]{1,4,6,2,3,1, 5,4,2,3,5,6};
    Button b1, b2;
    int opencards = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v)
    {
        Button button = (Button) v;
        String tag = button.getTag().toString();
        int index = Integer.parseInt(tag);
        // Данный метод работает некорректно, исправьте его.
        // Необходимо при открытии третьей карты скрывать первые две
        // В текущей версии не учитываются совпадения
        // (то есть когда подряд открыты две одинаковые карты)
        // Чтобы выключить кнопку используйте
        // button.setEnabled(false);

        if (opencards == 2) {
            button.setText(Integer.toString(cards[index]));
            b1.setText("");
            b2.setText("");

            b1 = button;
            opencards=0;
        }
        else
        {
            if (opencards == 1)
            {
                button.setText(Integer.toString(cards[index]));
                b2 = button;
                opencards++;
            }
            else if (opencards == 0)
            {
                b1 = button;
                opencards++;
            }
        }


        // добавить логику для закрытия карт после открытия двух из них
    }


}
