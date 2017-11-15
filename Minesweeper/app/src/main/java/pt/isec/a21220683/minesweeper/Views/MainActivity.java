package pt.isec.a21220683.minesweeper.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import pt.isec.a21220683.minesweeper.R;
import pt.isec.a21220683.minesweeper.Views.Setting.Settings;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button soloGame = (Button) findViewById(R.id.btn1P);
        soloGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"A preparar jogo..",Toast.LENGTH_SHORT);
                Intent intentGame = new Intent(MainActivity.this, SoloGame.class);
                startActivity(intentGame);
            }
        });


        ImageButton definicoes = (ImageButton) findViewById(R.id.btnSettings);
        definicoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Definicoes..",Toast.LENGTH_SHORT);
                Intent intentDef = new Intent(MainActivity.this, Settings.class);
                startActivity(intentDef);
            }
        });
    }
}
