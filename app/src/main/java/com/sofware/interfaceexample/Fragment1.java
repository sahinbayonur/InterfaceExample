package com.sofware.interfaceexample;

/**
 * Created by Onur on 29/09/2022.
 */

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {
    Button kaydet; //Buton referansı
    EditText isim_edittext,soyisim_edittext; //Edittext referansı
    String isim,soyisim;
    KaydetInterface kaydetinterface; //KaydetInterface referansı
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        isim_edittext = (EditText)view.findViewById(R.id.isim_edittex);
        soyisim_edittext = (EditText)view.findViewById(R.id.soyisim_edittext);
        kaydet = (Button)view.findViewById(R.id.kaydet);

        kaydet.setOnClickListener(new View.OnClickListener() {//Kaydet buton click listener
            @Override
            public void onClick(View v) {
                isim = isim_edittext.getText().toString(); //Edittextteki değeri alıyoruz
                soyisim = soyisim_edittext.getText().toString();//Edittextteki değeri alıyoruz

                //Interface methodunu kullanacağız.Burda dikkat etmeniz gereken konu
                //getActivity() i KaydetInterface ile cast etmemiz
                //Çünkü biz suan Anasayfa içindeki methodu çağıracağız
                //İşte burda interface methodunun faydalarını görüyoruz
                //Burda interface üzerinden değilde direk Anasayfa içindeki bir methoduda aşağıdaki gibi çağırabilirdik
                //Anasayfa a =new Anasayfa();
                //a.kaydetClick("","");

                //Ama bu fragment o zaman sadece bu activity için kullanılırdı
                // İnterface kullanarak artık hangi Activity içinde bu fragment kullanılırsa o Activity KaydetInterface implement ederek
                //kaydetClick methodunu çağırabilir

                kaydetinterface = (KaydetInterface)getActivity();
                kaydetinterface.kaydetClick(isim, soyisim);
            }
        });

        return view;
    }

}
