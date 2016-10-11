package br.com.gushiman.copmobiledesafio01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Manabu on 24/09/2016.
 */
public class ColaboradoresDbHelper extends SQLiteOpenHelper {

    private static final String SQL_CRIAR_BANCO = "CREATE TABLE " +
            ColaboradorContract.ColaboradorEntry.TABLE_NAME + " (" +
            ColaboradorContract.ColaboradorEntry._ID + " INTEGER PRIMARY KEY, " +
            ColaboradorContract.ColaboradorEntry.COLUMN_NOME + " TEXT, " +
            ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_MOBILE + " TEXT, " +
            ColaboradorContract.ColaboradorEntry.COLUMN_CONHECIMENTO_UX + " TEXT, " +
            ColaboradorContract.ColaboradorEntry.COLUMN_CURSOS + " TEXT)";

    private static final String SQL_DELETAR_BANCO = "DROP TABLE IF EXISTS " +
            ColaboradorContract.ColaboradorEntry.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "colaboradores.db";

    public ColaboradoresDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CRIAR_BANCO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETAR_BANCO);
        onCreate(db);
    }
}
