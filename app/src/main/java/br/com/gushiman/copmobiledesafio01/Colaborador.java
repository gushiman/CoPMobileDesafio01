package br.com.gushiman.copmobiledesafio01;

/**
 * Created by Manabu on 25/09/2016.
 */
public class Colaborador {

    private final String nome;
    private final String conhecimentoMobile;
    private final String conhecimentoUx;
    private final String cursos;

    public Colaborador(String nome, String conhecimentoMobile, String conhecimentoUx, String cursos) {
        this.nome = nome;
        this.conhecimentoMobile = conhecimentoMobile;
        this.conhecimentoUx = conhecimentoUx;
        this.cursos = cursos;
    }

    public String getNome() {
        return nome;
    }

    public String getConhecimentoMobile() {
        return conhecimentoMobile;
    }

    public String getConhecimentoUx() {
        return conhecimentoUx;
    }

    public String getCursos() {
        return cursos;
    }

}
