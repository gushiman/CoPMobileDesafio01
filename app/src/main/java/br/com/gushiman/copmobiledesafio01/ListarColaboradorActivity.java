package br.com.gushiman.copmobiledesafio01;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manabu on 25/09/2016.
 */
public class ListarColaboradorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_colaborador);
        montarListaColaboradores();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_listar_colaborador).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_incluir_colaborador:
                Intent intent = new Intent(ListarColaboradorActivity.this, PersistirColaboradorActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void montarListaColaboradores() {
        final ColaboradoresDbHelper colaboradoresDbHelper = new ColaboradoresDbHelper(this);
        SQLiteDatabase db = colaboradoresDbHelper.getReadableDatabase();

        String tabela = ColaboradorContract.ColaboradorEntry.TABLE_NAME;

        String[] colunas = {
                ColaboradorContract.ColaboradorEntry.COLUMN_NOME,
                ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_MOBILE,
                ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_UX,
                ColaboradorContract.ColaboradorEntry.COLUMN_CURSOS
        };

        String sortOrder = ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_MOBILE + " DESC";

        Cursor cursor = db.query(
                tabela,
                colunas,
                null,
                null,
                null,
                null,
                sortOrder
        );

        List<Colaborador> colaboradorList = new ArrayList<>();

        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                Colaborador colaborador = new Colaborador(
                        cursor.getString(cursor.getColumnIndexOrThrow(ColaboradorContract.ColaboradorEntry.COLUMN_NOME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_MOBILE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_UX)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ColaboradorContract.ColaboradorEntry.COLUMN_CURSOS))
                );
                colaboradorList.add(colaborador);
            }
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_colaborador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ColaboradorAdapter(colaboradorList, this));
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layout);

    }
}
