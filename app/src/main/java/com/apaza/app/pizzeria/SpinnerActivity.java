package com.apaza.app.pizzeria;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.media.RingtoneManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.widget.Spinner;
import android.widget.Toast;


public class SpinnerActivity extends AppCompatActivity {

    private View masadelgada;
    private View masagruesa;
    private View masaartesanal;
    Button btn_selection;
    RadioButton rbt_delgada, rbt_grueso, rbt_artesanal;
    CheckBox cb1, cb2;
    Spinner spn_lista;
    String[]items;
    String tipo_masa;
    int a;
    private boolean isFirstTime = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        btn_selection = (Button)findViewById(R.id.button_ordenar);
        rbt_delgada = (RadioButton)findViewById(R.id.rbtndelgada);
        rbt_grueso = (RadioButton)findViewById(R.id.rbtngruesa);
        rbt_artesanal = (RadioButton)findViewById(R.id.rbtnartesana);
        cb1 = (CheckBox)findViewById(R.id.checkBox);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        spn_lista = (Spinner)findViewById(R.id.spinner);


        //SPINNER
        items = getResources().getStringArray(R.array.pizzas);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn_lista.setAdapter(adapter);

        spn_lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isFirstTime){
                    isFirstTime=false;
                }else{
                    Toast.makeText(getApplicationContext(),items[position],Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        //RADIOBUTTON
     /*  btn_selection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(rbt_grueso.isChecked()){
                    Toast.makeText(getApplicationContext(),"Seleccionado",Toast.LENGTH_LONG).show();
                    tipo_masa="Masa gruesa";
                }else if(rbt_delgada.isChecked()){
                    Toast.makeText(getApplicationContext(),"Seleccionado2",Toast.LENGTH_LONG).show();
                    tipo_masa="Masa delgada";
                }else if(rbt_artesanal.isChecked()){
                    Toast.makeText(getApplicationContext(),"Seleccionado3",Toast.LENGTH_LONG).show();
                    tipo_masa="Masa artesanal";
                }
            }
        });*/




    }


    public void showDialog(View view) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_notification);
        // Custom Android Allert Dialog Title
        dialog.setTitle("Custom Dialog Example");

        dialog.show();


        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Mensaje")
                .setContentText("La pizza va en camino")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setAutoCancel(true)
                .build();

        // Notification manager
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(15, notification);


    }

}
