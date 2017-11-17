package pt.isec.a21220683.minesweeper.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pt.isec.a21220683.minesweeper.Jogador;

/**
 * Created by Dmytro Yaremyshyn on 16/11/2017.
 */

public class DataBaseManager {
    public final static String TABELA_JOGADOR = "jogador";
    public final static String JOGADOR_NOME = "nome";
    public final static String JOGADOR_PTS = "pts";
    public final static String JOGADOR_ID = "id";
    public final static String JOGADOR_FOTO = "foto";

    private DBHelper helper;

    public DataBaseManager(Context context){
        helper = new DBHelper(context);
    }

    public long insertJogador(Jogador jogador){

        SQLiteDatabase db = helper.getWritableDatabase();
        long id = -1;

        db.beginTransaction();

        try{
            ContentValues values = new ContentValues();
            values.put(JOGADOR_NOME,jogador.getNome());
            //values.put(JOGADOR_FOTO, jogador.getFoto());
            values.put(JOGADOR_PTS,jogador.getPts());

            id = db.insertOrThrow(TABELA_JOGADOR,null,values);
            db.setTransactionSuccessful();
        }catch(Exception e){
            Log.e("DataBaseManager","Erro ao inserir jogador!!");
        }finally{
            db.endTransaction();
            db.close();
        }

        return id;
    }


    public List<Jogador> getJogador(){

        final String query = String.format(
                "SELECT * " +
                "FROM %s", TABELA_JOGADOR
        );

        List<Jogador> jogadores = new ArrayList<>();

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        try{
            while(cursor.moveToNext()){
                Jogador jogador = new Jogador();

                jogador.setNome(cursor.getString(cursor.getColumnIndex(JOGADOR_NOME)));
                jogador.setPontuacao(cursor.getInt(cursor.getColumnIndex(JOGADOR_PTS)));
                jogador.setId(cursor.getLong(cursor.getColumnIndex(JOGADOR_ID)));
                //TODO: FOTO

                jogadores.add(jogador);
            }

        }catch(Exception e){
            Log.e("DataBaseManager","Erro ao buscar jogador!!");
        }finally {
            if(cursor != null && !cursor.isClosed()){
                cursor.close();
            }
            db.close();
        }

        return jogadores;
    }


    public int deleteJogador(long id){
        SQLiteDatabase db = helper.getWritableDatabase();
        int linhasAfetadas = 0;

        db.beginTransaction();

        try{

            linhasAfetadas = db.delete(TABELA_JOGADOR,JOGADOR_ID + " = ?", new String[]{ Long.toString(id)});

            db.setTransactionSuccessful();
        }catch(Exception e){
            Log.e("DataBaseManager","Erro ao remover jogador!!");
        }finally{
            db.endTransaction();
            db.close();
        }

        return linhasAfetadas;
    }

}
