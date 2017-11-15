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

        SharedPreferences sharedPreferences = getSharedPreferences("FotoJogador", Context.MODE_PRIVATE);

        path = sharedPreferences.getString("foto","");
        foto = (ImageView) findViewById(R.id.foto);
        File imgFile = new File(path);

        if (imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            foto.setImageBitmap(myBitmap);
        }

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

                if (nomeJogador.getText().toString().isEmpty() == false) {
                    SharedPreferences sharedPref = getSharedPreferences("NomeJogador", Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("nome", nomeJogador.getText().toString());
                    editor.apply();

                    Toast.makeText(Settings.this, "Guardei nome", Toast.LENGTH_SHORT).show();

                }
                /*
                if (foto != null){
                    System.out.println("\n\nHa foto! ");
                    Toast.makeText(Definicoes.this,"Tenho foto",Toast.LENGTH_SHORT).show();
                    foto.buildDrawingCache();
                    Bitmap bmap = foto.getDrawingCache();
                    Uri uri = getImageUri(getApplicationContext(),bmap);
                    path = getRealPathFromURI(uri);

                    SharedPreferences sharedPref = getSharedPreferences("FotoJogador", Context.MODE_PRIVATE);
                    System.out.println("\n\nVou guardar! ");
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("foto", path);
                    editor.apply();
                }
                */
            }
        });

    }


    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    public void mudarFoto(View view){
        dispatchTakePictureIntent();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
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

        Toast.makeText(this,"Guardado nome do jogador",Toast.LENGTH_SHORT).show();Toast.makeText(this,"Guardado nome do jogador",Toast.LENGTH_SHORT).show();
    }
}
