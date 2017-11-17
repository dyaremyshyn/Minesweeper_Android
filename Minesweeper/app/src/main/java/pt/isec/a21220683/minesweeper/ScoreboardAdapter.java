package pt.isec.a21220683.minesweeper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pt.isec.a21220683.minesweeper.DataBase.DataBaseManager;

/**
 * Created by Dmytro Yaremyshyn on 15/11/2017.
 */

public class ScoreboardAdapter extends BaseAdapter {

    private Context mContext;
    private List<Jogador> mListaJogadores;

    public ScoreboardAdapter(Context mContext, List<Jogador> mListaJogadores) {
        this.mContext = mContext;
        this.mListaJogadores = mListaJogadores;
    }

    @Override
    public int getCount() {
        return mListaJogadores.size();
    }

    @Override
    public Object getItem(int i) {
        return mListaJogadores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null ){
            view = LayoutInflater.from(mContext).inflate(R.layout.score,viewGroup,false);
        }

       final Jogador jogador = (Jogador) getItem(i);

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(mContext)
                        .setTitle("Delete Score?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int ii) {
                                mListaJogadores.remove(i);
                                notifyDataSetChanged();
                                DataBaseManager db = new DataBaseManager(mContext);
                                db.deleteJogador(jogador.getId());
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)/*new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })*/
                        .show();
                return false;
            }
        });


        TextView tvNome = (TextView) view.findViewById(R.id.tv_nome);
        TextView tvPontuacao = (TextView) view.findViewById(R.id.tv_pontuacao);

        tvNome.setText(jogador.getNome());
        tvPontuacao.setText(Integer.toString(jogador.getPts()));

        return view;
    }


}
