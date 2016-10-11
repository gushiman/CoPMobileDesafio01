package br.com.gushiman.copmobiledesafio01;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.List;

/**
 * Created by Manabu on 25/09/2016.
 */
public class ColaboradorAdapter extends RecyclerView.Adapter {

    private List<Colaborador> colaboradorList;
    private Context context;

    public ColaboradorAdapter(List<Colaborador> colaboradorList, Context context) {
        this.colaboradorList = colaboradorList;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_colaborador, parent, false);
        ColaboradorViewHolder holder = new ColaboradorViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ColaboradorViewHolder holder = (ColaboradorViewHolder) viewHolder;
        Colaborador colaborador = colaboradorList.get(position);
        holder.nome.setText(colaborador.getNome());
        holder.conhecimentoMobile.setText(colaborador.getConhecimentoMobile());
        holder.conhecimentoUx.setText(colaborador.getConhecimentoUx());
        holder.cursos.setText(colaborador.getCursos());

        try {
            YoYo.with(Techniques.ZoomIn)
                    .duration(700)
                    .playOn(holder.itemView.findViewById(R.id.cardview_item_colaborador));
        } catch(Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return colaboradorList.size();
    }
}
