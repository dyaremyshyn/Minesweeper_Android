package pt.isec.a21220683.minesweeper;

import android.graphics.Bitmap;

/**
 * Created by Dmytro Yaremyshyn on 15/11/2017.
 */

public class Jogador {

    int pontuacao;
    String nome;
    Bitmap foto;

    public Jogador(){
        this.nome = "Jogador1";
        this.pontuacao = 0;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }
}
