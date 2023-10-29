package com.example.homework03;

package com.example.vebinar2_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class TestResources extends AppCompatActivity {

    private boolean isSubscribed = false;

    private Button colorChangeButton;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_resources);

        //1. Подписываемся и отписываемся

        String profileName = "@aleks";
        setTitle("Профиль пользователя " + profileName);

        Button buttonSub = findViewById(R.id.buttonSubscribe);

        buttonSub.setOnClickListener(view -> {

            if (isSubscribed) {
                // Предупреждение с вариантом отмены действия
                Snackbar snackbar = Snackbar.make(view, "Вы точно хотите отписаться от " + profileName + "?", Snackbar.LENGTH_SHORT)
                        .setAction("Да, отписаться", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // Отменяем подписку
                                buttonSub.setBackgroundColor(getResources().getColor(R.color.notSubscribe_button_color));
                                buttonSub.setText("Подписаться");
                            }
                        });
                snackbar.show();

            } else {
                // Подписка оформлена
                buttonSub.setBackgroundColor(getResources().getColor(R.color.Subscribe_button_color));
                buttonSub.setText("Отписаться");

                // Вывод Toast об успешной подписке
                Toast toast = Toast.makeText(getApplicationContext(), "Вы подписались на " + profileName, Toast.LENGTH_SHORT);
                toast.show();
            }

            // Перевертыш
            isSubscribed = !isSubscribed;
        });


        //2 Смена цвета фона при нажатии на кнопку "Смена цвета"
        colorChangeButton = findViewById(R.id.changeColorButton);
        mainLayout = findViewById(R.id.main_layout);

        colorChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBackgroundColor();
            }
        });
    }

    // Метод смены цвета фона
    private void changeBackgroundColor() {
        Random random = new Random();
        int color = android.graphics.Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        mainLayout.setBackgroundColor(color);
    }
}
