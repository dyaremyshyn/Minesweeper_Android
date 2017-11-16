package pt.isec.a21220683.minesweeper.Views.Setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

import pt.isec.a21220683.minesweeper.R;

public class Settings extends Activity {

    //DataBaseManagerImpl dbImp;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    EditText nomeJogador;
    ImageView foto;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        nomeJogador = (EditText) findViewById(R.id.edtNomeJogador);
        nomeJogador.setText(getNomeSP());

        foto = (ImageView) findViewById(R.id.foto);

        Button creditos = (Button) findViewById(R.id.btnCreditos);
        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_creditos = new Intent(Settings.this, Creditos.class);
                startActivity(intent_creditos);
            }
        });

        Button save = (Button) findViewById(R.id.btnSave);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }






    public String getNomeSP(){
        SharedPreferences sharedPreferences = getSharedPreferences("NomeJogador",Context.MODE_PRIVATE);
        return sharedPreferences.getString("nome","");
    }

    public void onSaveSettings(View view){
        SharedPreferences sharedPref = getSharedPreferences("NomeJogador", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("nome",nomeJogador.getText().toString());
        editor.apply();

        Toast.makeText(this,"Guardado nome do jogador",Toast.LENGTH_SHORT).show();

    }
}
