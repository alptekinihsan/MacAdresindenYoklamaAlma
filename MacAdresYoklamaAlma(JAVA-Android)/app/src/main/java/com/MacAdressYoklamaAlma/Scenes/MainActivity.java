package com.MacAdresindenYoklamaAlma.Scenes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ihsan.guncelkonularbeta.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText idEditText, passwordEditText;
    private int key;
    /*
    Burada kullandığımız değişkenler
    veri tabanından gelen bilgiler tarafından eşlenecek
    eğer doğru ise giriş yapılacak.
     */
    private String id="12345678";
    private String password="asd.8585";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getKey();
        init();
    }

    /*
    değişkenlerin tanımları için kullanılan bir metod
     */

    private void init() {
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(this);
        idEditText = findViewById(R.id.id_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
    }

    /*
    hideKeyboard metodunda edittextin üzerinde herhangi bir yerine tıklandığında
    klavyeyi kapatmaya yarıyor. if koşulu ise tıklanma durumunun boş yada dolu
    olduğunu ediyor.Eğer bir yere tıklanmış ise dolu olacağından kod çalışacaktır.
     */
    public void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /*
    Butona tıkladığında yapılacak işlemleri için kullıcak bir metod bu.
    İf içerisinde kullanıcın hangi butona tıkladığına ve butona tıkladıktan sonra girdiği verilerin
    doğruluğuna bakılıyor. Eğer doğru bir giriş yapmış ise , öğrenci ise öğrenci ekranına öğretmen
    ise öğretmen ekranına geçiş yapılacaktır.
     */

    @Override
    public void onClick(View v) {
        if (key==1 && checkUser(id,password)){
            startActivity(new Intent(MainActivity.this,StudentActivity.class));
        }

        if (key==2 && checkUser(id,password)){
            startActivity(new Intent(MainActivity.this,TeacherActivity.class));
        }
    }
    /*
    Bu metod program başlarken önceki ekrandan gelen veriyi alır
    ve bir değişken üzerinde tutar. Gelen değişken ise hangi butona tıkladığı bilgisini verir.
     */
    private void getKey() {
        key = getIntent().getIntExtra("key", 0);
    }
    /*
    checkUser metodu ilk başta edittextin içerisine bakıyor boş ise alanın doldurulması gerektiriğini söylüyor.
    eğer dolu ise girilen değerlerin doğruluğunu kontrol ediyor eğer doğru ise yeni sayfaya yönlendiriyor.
    Yanlış ise bilgilerin yanlış olduğunu söylüyor.
     */
    private boolean checkUser(String id , String password){
        if (!idEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty() ){
           if (idEditText.getText().toString().equals(id) && passwordEditText.getText().toString().equals(password)){
               idEditText.setText("");
               passwordEditText.setText("");

               return true;
           }else{
               Toast.makeText(getApplicationContext(),"Bilgiler Yanlış!",Toast.LENGTH_SHORT).show();
           }
        }else{
            Toast.makeText(getApplicationContext(),"Lütfen Boş Alan Bırakmayınız!",Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
