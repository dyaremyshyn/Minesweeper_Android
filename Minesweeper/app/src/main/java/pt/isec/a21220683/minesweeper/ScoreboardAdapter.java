package pt.isec.a21220683.minesweeper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null ){
            view = LayoutInflater.from(mContext).inflate(R.layout.score,viewGroup,false);
        }
        //View v = View.inflate(mContext, R.layout.score,null);

        Jogador jogador = (Jogador) getItem(i);
        TextView tvNome = (TextView) view.findViewById(R.id.tv_nome);
        TextView tvPontuacao = (TextView) view.findViewById(R.id.tv_pontuacao);

        tvNome.setText(jogador.getNome());
        tvPontuacao.setText(Integer.toString(jogador.getPts()));

        return view;
    }
}
