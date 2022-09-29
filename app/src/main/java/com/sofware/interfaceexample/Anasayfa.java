package com.sofware.interfaceexample;

/**
 * Created by Onur on 29/09/2022.
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class Anasayfa extends Activity implements KaydetInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        FragmentManager fm = getFragmentManager();//Fragment Manager objesi oluşturuyoruz.//getFragmentManager() methodu Activity class ının methodudur
        FragmentTransaction ft = fm.beginTransaction();//Fragment oluşturabilmek için fm objesinin beginTransaction() methodunu çağırıyoruz
        ft.add(R.id.frame1,new Fragment1()); // Fragmentları ekleyeceğimiz yerleri ve class larını set ediyoruz
        ft.add(R.id.frame2,new Fragment2()); //Fragmentları ekleyeceğimiz yerleri ve class larını set ediyoruz
        ft.commit();//commit methodu ile değişiklikleri uyguluyoruz

    }

    @Override
    public void kaydetClick(String isim, String soyisim) {
        //kaydetClick() methodu KaydetInterface class methodudur
        //KaydetInterface implement ettiğimiz için bu methodu tanımlamak zorunludur.
        //Bu methodu Fragment1 içinden çağırıyoruz ve isim,soyisim değerlerini gönderiyoruz
        //Method içindede bu değerleri Fragment2 içindeki textDegistir() methoduna yolluyoruz
        //Böylelikle interface yardımı ile fragmentlar arasında data alışverişini bağlı oldukları activity üzerinden yapıyoruz

        FragmentManager fragmentManager = getFragmentManager();
        //Fragment2 içindeki textDegistir methodunu çağıracağımız için Fragment2 den obje oluşturuyoruz
        Fragment2 fragment2 = (Fragment2)fragmentManager.findFragmentById(R.id.frame2);
        fragment2.textUpdate(isim,soyisim);

    }
}
