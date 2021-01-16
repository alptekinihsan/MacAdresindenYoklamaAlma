package com.MacAdresindenYoklamaAlma.Scenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ihsan.guncelkonularbeta.R;

public class SelectLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button studentButton, teacherButton;
    /*
    key değişkeni hangi butona tıklandığını tespit edilmek için kullanılacaktır.
    Bu sayede giriş yaparken kontrol için sadece admin ya da öğrenci veri tabanı üzerinde
    işlem yapmamızı sağlayacaktır.
     */
    private int key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login);
        init();
    }

    /*
    burada kullandığım metod ise başlangıçta mecbur olan
    tanımlamaları yapabilmek için.
     */

    private void init() {
        studentButton = findViewById(R.id.student_button);
        studentButton.setOnClickListener(this);
        teacherButton = findViewById(R.id.teacher_button);
        teacherButton.setOnClickListener(this);
    }

    /*Herhangi bir butona tıklandığında gideceği sayfa aynı olduğu
    için ortak bir metod üzerinde sayfa geçişini  sağladım.
    */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student_button:
                key=1;
                break;
            case R.id.teacher_button:
                key=2;
                break;

        }
        sendKey(key);
    }

    /*
    Bu metot hangi butona tıklandıysa bir sonraki ekrana geçerken değeri
    o ekrana taşıyacaktır.
     */

    private void sendKey(int key){
        Intent i = new Intent(SelectLoginActivity.this, MainActivity.class);
        i.putExtra("key", key);
        startActivity(i);
    }
}
