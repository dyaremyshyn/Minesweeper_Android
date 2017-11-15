package pt.isec.a21220683.minesweeper;

import android.content.Context;
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
    private List<Jogador> mListaClassificacoes;

    public ScoreboardAdapter(Context mContext, List<Jogador> mListaClassificacoes) {
        this.mContext = mContext;
        this.mListaClassificacoes = mListaClassificacoes;
    }

    @Override
    public int getCount() {
        return mListaClassificacoes.size();
    }

    @Override
    public Object getItem(int i) {
        return mListaClassificacoes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(mContext, R.layout.score,null);
        TextView tvNome = (TextView) v.findViewById(R.id.tv_nome);
        TextView tvPontuacao = (TextView) v.findViewById(R.id.tv_pontuacao);

        tvNome.setText(mListaClassificacoes.get(i).getNome());
        tvPontuacao.setText(mListaClassificacoes.get(i).getPontuacao());

        return null;
    }
}
