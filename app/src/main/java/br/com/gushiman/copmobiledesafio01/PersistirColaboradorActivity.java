package br.com.gushiman.copmobiledesafio01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PersistirColaboradorActivity extends AppCompatActivity {

    private String nome;
    private String conhecimentoMobile = "não informado";
    private String conhecimentoUx = "não informado";
    private boolean cursoAndroidModuloBasico = false;
    private boolean cursoAndroidModuloAvancado = false;
    private boolean cursoUx = false;
    private String cursos = "não informado";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_persistir_colaborador);

        setarConhecimentoMobile();
        setarConhecimentoUx();
        setarCursos();
        persistirColaborador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_incluir_colaborador).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_listar_colaborador:
                Intent intent = new Intent(PersistirColaboradorActivity.this, ListarColaboradorActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setarNome() {
        final EditText campoNome = (EditText) findViewById(R.id.edittext_nome);
        nome = campoNome.getText().toString();
    }

    private void setarConhecimentoMobile() {
        final RadioGroup grupoMobile = (RadioGroup) findViewById(R.id.radiogroup_mobile);
        final RadioButton opcaoMobileUm = (RadioButton) findViewById(R.id.radiobutton_mobile_1);
        final RadioButton opcaoMobileDois = (RadioButton) findViewById(R.id.radiobutton_mobile_2);
        final RadioButton opcaoMobileTres = (RadioButton) findViewById(R.id.radiobutton_mobile_3);

        grupoMobile.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId  == opcaoMobileUm.getId()) {
                    conhecimentoMobile = "1";
                } else if(checkedId == opcaoMobileDois.getId()) {
                    conhecimentoMobile = "2";
                } else if(checkedId == opcaoMobileTres.getId()) {
                    conhecimentoMobile = "3";
                }
            }
        });
    }

    private void setarConhecimentoUx() {
        final RadioGroup grupoUx = (RadioGroup) findViewById(R.id.radiogroup_ux);
        final RadioButton opcaoUxUm = (RadioButton) findViewById(R.id.radiobutton_ux_1);
        final RadioButton opcaoUxDois = (RadioButton) findViewById(R.id.radiobutton_ux_2);
        final RadioButton opcaoUxTres = (RadioButton) findViewById(R.id.radiobutton_ux_3);

        grupoUx.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == opcaoUxUm.getId()) {
                    conhecimentoUx = "1";
                } else if(checkedId == opcaoUxDois.getId()) {
                    conhecimentoUx = "2";
                } else if(checkedId == opcaoUxTres.getId()) {
                    conhecimentoUx = "3";
                }
            }
        });
    }

    private void setarCursos() {
        final CheckBox ticadoAndroidModuloBasico = (CheckBox) findViewById(R.id.checkbox_android_basico);
        final CheckBox ticadoModuloAvancado = (CheckBox) findViewById(R.id.checkbox_android_avancado);
        final CheckBox ticadoUx = (CheckBox) findViewById(R.id.checkbox_ux);

        ticadoAndroidModuloBasico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ticadoAndroidModuloBasico.isChecked()) {
                    cursoAndroidModuloBasico = true;
                } else {
                    cursoAndroidModuloBasico = false;
                }
            }
        });

        ticadoModuloAvancado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ticadoModuloAvancado.isChecked()) {
                    cursoAndroidModuloAvancado = true;
                } else {
                    cursoAndroidModuloAvancado = false;
                }
            }
        });

        ticadoUx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ticadoUx.isChecked()) {
                    cursoUx = true;
                } else {
                    cursoUx = false;
                }
            }
        });
    }

    private void montarCursos() {
        if(cursoAndroidModuloBasico) {
            cursos = "Android - Módulo Básico";
        }
        if(cursoAndroidModuloAvancado) {
            if(cursos.equals("não informado")) {
                cursos = "Android - Módulo Avançado";
            } else {
                cursos += ", Android - Módulo Avançado";
            }
        }
        if(cursoUx) {
            if(cursos.equals("não informado")) {
                cursos = "UX";
            } else {
                cursos += ", UX";
            }
        }
    }

    private void limparCampos() {
        final EditText campoNome = (EditText) findViewById(R.id.edittext_nome);
        final RadioGroup grupoMobile = (RadioGroup) findViewById(R.id.radiogroup_mobile);
        final RadioGroup grupoUx = (RadioGroup) findViewById(R.id.radiogroup_ux);
        final CheckBox ticadoAndroidModuloBasico = (CheckBox) findViewById(R.id.checkbox_android_basico);
        final CheckBox ticadoModuloAvancado = (CheckBox) findViewById(R.id.checkbox_android_avancado);
        final CheckBox ticadoUx = (CheckBox) findViewById(R.id.checkbox_ux);

        campoNome.setText("");
        grupoMobile.clearCheck();
        grupoUx.clearCheck();
        ticadoAndroidModuloBasico.setChecked(false);
        ticadoModuloAvancado.setChecked(false);
        ticadoUx.setChecked(false);
    }

    private void persistirColaborador() {

        final Button botaoGravar = (Button) findViewById(R.id.button_gravar);
        final ColaboradoresDbHelper colaboradoresDbHelper = new ColaboradoresDbHelper(this);

        botaoGravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setarNome();
                montarCursos();

                SQLiteDatabase db = colaboradoresDbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(ColaboradorContract.ColaboradorEntry.COLUMN_NOME, nome);
                values.put(ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_MOBILE, conhecimentoMobile);
                values.put(ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_UX, conhecimentoUx);
                values.put(ColaboradorContract.ColaboradorEntry.COLUMN_CURSOS, cursos);

                long idRegistro = db.insert(
                        ColaboradorContract.ColaboradorEntry.TABLE_NAME,
                        null,
                        values);

                limparCampos();
            }

        });
    }
}
