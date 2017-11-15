package pt.isec.a21220683.minesweeper.Views;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import pt.isec.a21220683.minesweeper.Jogador;
import pt.isec.a21220683.minesweeper.R;
import pt.isec.a21220683.minesweeper.ScoreboardAdapter;

public class Scoreboard extends Activity {

    private ListView lvPontuacoes;
    private ScoreboardAdapter adapter;
    private List<Jogador> jogadores;
    //private MyHelper mySqlHelper;
    //private DataBaseManagerImpl dbImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
    }
}
