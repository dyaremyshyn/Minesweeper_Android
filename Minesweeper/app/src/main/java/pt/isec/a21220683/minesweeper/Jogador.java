package pt.isec.a21220683.minesweeper;

import android.graphics.Bitmap;

public class Jogador {

    int pts;
    String nome;
    Bitmap foto;
    long id;

    public Jogador(){
        this.pts = 0;
    }

    public void setPontuacao(int pts) {
        this.pts = pts;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPts() {
        return pts;
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
