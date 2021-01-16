package com.MacAdresindenYoklamaAlma.Scenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.ihsan.guncelkonularbeta.R;

public class TeacherActivity extends AppCompatActivity implements View.OnClickListener {

    private Button beginPollButton , endPollButton , logOutButton;
    private Spinner classCodeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        init();
    }

    /*
    değişkenlerin tanımları için kullanılan bir metod
     */

    private void init(){
        beginPollButton=findViewById(R.id.begin_poll_button);
        beginPollButton.setOnClickListener(this);
        endPollButton=findViewById(R.id.end_poll_button);
        endPollButton.setOnClickListener(this);
        logOutButton=findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(this);
        classCodeSpinner=findViewById(R.id.class_code_spinner);
    }

    /*
    Butona tıkladığında yapılacak işlemleri için kullıcak bir metod bu.
    begin_poll_button durumu yoklamayı başlatmak için kulalnıyor.
    end_poll_button durumu yoklamayı bitirmek için kullanılıyor.
    log_out_button durumu ise çıkış yapmak için kullanılıyor.
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.begin_poll_button:
                Toast.makeText(getApplicationContext(),"Yoklama Başladı!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.end_poll_button:
                Toast.makeText(getApplicationContext(),"Yoklama Bitti!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.log_out_button:
                Toast.makeText(getApplicationContext(),"Başarılı Çıkış Yapıldı!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TeacherActivity.this,SelectLoginActivity.class));
                break;
        }
    }
}
