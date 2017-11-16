package pt.isec.a21220683.minesweeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import pt.isec.a21220683.minesweeper.DataBase.DataBaseManager;
import pt.isec.a21220683.minesweeper.Util.Generator;
import pt.isec.a21220683.minesweeper.Util.PrintGrid;
import pt.isec.a21220683.minesweeper.grid.Cell;

/**
 * Created by Dmytro Yaremyshyn on 5/11/2017.
 */

public class GameEngine {
    private static GameEngine instance;
    private Jogador jogador;

    public static final int BOMB_NUMBER = 10;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 16;

    private Context context;

    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];

    public static GameEngine getInstance() {
        if( instance == null ){
            instance = new GameEngine();
        }
        return instance;
    }

    private GameEngine(){ }

    public void createGrid(Context context){
        Log.e("GameEngine","createGrid is working");
        this.context = context;

        // create the grid and store it
        int[][] GeneratedGrid = Generator.generate(BOMB_NUMBER,WIDTH, HEIGHT);
        PrintGrid.print(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
        jogador = new Jogador();

    }

    private void setGrid( final Context context, final int[][] grid ){
        for( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( MinesweeperGrid[x][y] == null ){
                    MinesweeperGrid[x][y] = new Cell( context , x,y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }
    }

    public Cell getCellAt(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;

        return MinesweeperGrid[x][y];
    }

    public Cell getCellAt( int x , int y ){
        return MinesweeperGrid[x][y];
    }

    public void click( int x , int y ){
        if( x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT && !getCellAt(x,y).isClicked() ){
            getCellAt(x,y).setClicked();

            if( getCellAt(x,y).getValue() == 0 ){
                for( int xt = -1 ; xt <= 1 ; xt++ ){
                    for( int yt = -1 ; yt <= 1 ; yt++){
                        if( xt != yt ){
                            click(x + xt , y + yt);
                        }
                    }
                }
            }

            if( getCellAt(x,y).isBomb() ){
                onGameLost();
            }

            jogador.setPontuacao(jogador.getPts()+1);
            Log.e("Pontuacao","PTS: "+jogador.getPts());
        }

        checkEnd();
    }

    private boolean checkEnd(){
        int bombNotFound = BOMB_NUMBER;
        int notRevealed = WIDTH * HEIGHT;
        for ( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( getCellAt(x,y).isRevealed() || getCellAt(x,y).isFlagged() ){
                    notRevealed--;
                }

                if( getCellAt(x,y).isFlagged() && getCellAt(x,y).isBomb() ){
                    bombNotFound--;
                }
            }
        }

        if( bombNotFound == 0 && notRevealed == 0 ){
            Toast.makeText(context,"Game won! \n"+jogador.getPts()+" PTS", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public void flag( int x , int y ){
        boolean isFlagged = getCellAt(x,y).isFlagged();
        getCellAt(x,y).setFlagged(!isFlagged);
        getCellAt(x,y).invalidate();
    }

    private void onGameLost(){
        // handle lost game
        Toast.makeText(context,"Game lost \n"+jogador.getPts()+" PTS", Toast.LENGTH_SHORT).show();

        for ( int x = 0 ; x < WIDTH ; x++ ) {
            for (int y = 0; y < HEIGHT; y++) {
                getCellAt(x,y).setRevealed();
            }
        }

        //save on SQLite
        DataBaseManager db = new DataBaseManager(context);
        //jogador.setNome("antonio");
        jogador.setNome(getNomeSP());
        db.insertJogador(jogador);

    }

    public String getNomeSP(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("NomeJogador",Context.MODE_PRIVATE);
        return sharedPreferences.getString("nome","");
    }

}
