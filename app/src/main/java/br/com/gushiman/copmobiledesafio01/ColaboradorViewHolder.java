package br.com.gushiman.copmobiledesafio01;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Manabu on 25/09/2016.
 */
public class ColaboradorViewHolder extends RecyclerView.ViewHolder {

    final TextView nome;
    final TextView conhecimentoMobile;
    final TextView conhecimentoUx;
    final TextView cursos;

    public ColaboradorViewHolder(View view) {
        super(view);
        nome = (TextView) view.findViewById(R.id.textview_item_nome);
        conhecimentoMobile = (TextView) view.findViewById(R.id.textview_item_conhecimento_mobile);
        conhecimentoUx = (TextView) view.findViewById(R.id.textview_item_conhecimento_ux);
        cursos = (TextView) view.findViewById(R.id.textview_item_cursos);
    }
}
