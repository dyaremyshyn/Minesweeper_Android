package pt.isec.a21220683.minesweeper.Views;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import pt.isec.a21220683.minesweeper.GameEngine;
import pt.isec.a21220683.minesweeper.R;

public class SoloGame extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_game);

        ((TextView)findViewById(R.id.textView)).setText("ASDASDASDASD");

        Log.e("MainActivity","onCreate");
        GameEngine.getInstance().createGrid(this);
    }
}
