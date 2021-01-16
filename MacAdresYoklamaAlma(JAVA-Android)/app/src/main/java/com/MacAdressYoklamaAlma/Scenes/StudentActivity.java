package com.MacAdresindenYoklamaAlma.Scenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ihsan.guncelkonularbeta.R;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button joinPollButton , logOutButton;
    private ListView studenClassCodeListView;
    /*
    connectionMacAddress bağlı olduğu wifinin mac adres bilgisini tuttuğu değişken.
     */
    private String connectionMacAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        init();
    }

     /*
    değişkenlerin tanımları için kullanılan bir metod
     */

    private void init(){
        joinPollButton=findViewById(R.id.join_poll_button);
        joinPollButton.setOnClickListener(this);
        logOutButton=findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(this);
        studenClassCodeListView=findViewById(R.id.student_class_code_list_view);
    }
    /*
    Butona tıkladığında yapılacak işlemleri için kullıcak bir metod bu.
    Eğer join poll ise tıkladığı buton bir kontrol yapıyor öğrencinin bağlandığı mac adresi
    hocanın mac adresi ile uyumlumu diye. Eğer kontrol doğru sonuç üretiyorsa yoklamaya katılıyor.
    Başarısız ise dersi aldığınız hocanın telefonuna bağlanın mesajını veriyor.
    eğer log out butonuna tıklarsa çıkış işlemi yapıcaktır.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.join_poll_button:
                if (checkMacAddress()){
                    Toast.makeText(getApplicationContext(),"Yoklamaya Katıldınız!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.log_out_button:
                Toast.makeText(getApplicationContext(),"Başarılı Çıkış Yaptınız!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StudentActivity.this,SelectLoginActivity.class));
        }
    }

    /*
    checkMacAddress metodu bağlı olduğu wifi adres bilgisini çeker.
     */

    private boolean checkMacAddress(){
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        connectionMacAddress=wifiInfo.getBSSID();
        return true;
    }
}
