package br.com.gushiman.copmobiledesafio01;

import android.provider.BaseColumns;

/**
 * Created by Manabu on 24/09/2016.
 */
public final class ColaboradorContract {

    public ColaboradorContract() {}

    public static abstract class ColaboradorEntry implements BaseColumns {

        public static final String TABLE_NAME = "colaboradores";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_CONHECIMENTO_MOBILE = "conhecimento_mobile";
        public static final String COLUMN_CONHECIMENTO_UX = "conhecimento_ux";
        public static final String COLUMN_CURSOS = "cursos";

    }

}
