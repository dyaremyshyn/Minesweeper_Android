package pt.isec.a21220683.minesweeper.Views.Setting;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import pt.isec.a21220683.minesweeper.R;

public class Creditos extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        TextView tvCreditos = (TextView) findViewById(R.id.txtCreditos);
        tvCreditos.setText("Trabalho Prático Android 2016/2017 - Minesweeper\n\nAplicação realizada no ambito da unidade curricular:\n" +
                "Arquitecturas Móveis\n\n\nCriador:\nDmytro Yaremyshyn nº21220683");

    }
}
