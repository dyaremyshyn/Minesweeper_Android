package pt.isec.a21220683.minesweeper.Views;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pt.isec.a21220683.minesweeper.DataBase.DataBaseManager;
import pt.isec.a21220683.minesweeper.Jogador;
import pt.isec.a21220683.minesweeper.R;
import pt.isec.a21220683.minesweeper.ScoreboardAdapter;

public class Scoreboard extends Activity {

    private ScoreboardAdapter adapter;
    private List<Jogador> jogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);

        ListView lvPts = findViewById(R.id.listview);
        DataBaseManager db = new DataBaseManager(this);

        jogadores = db.getJogador();
        adapter = new ScoreboardAdapter(this,jogadores);
        lvPts.setAdapter(adapter);

    }



}
