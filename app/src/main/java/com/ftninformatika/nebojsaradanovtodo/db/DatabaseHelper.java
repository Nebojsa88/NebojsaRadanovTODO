package com.ftninformatika.nebojsaradanovtodo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ftninformatika.nebojsaradanovtodo.db.model.Grupa;
import com.ftninformatika.nebojsaradanovtodo.db.model.ZadatakTodo;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;



/**
 * Created by milossimic on 11/4/16.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    //Dajemo ime bazi
    private static final String DATABASE_NAME    = "ormlite.db";

    //i pocetnu verziju baze. Obicno krece od 1
    private static final int    DATABASE_VERSION = 1;

    private Dao<ZadatakTodo, Integer> mZadatakDao = null;
    private Dao<Grupa, Integer> mGrupaDao = null;

    //Potrebno je dodati konstruktor zbog pravilne inicijalizacije biblioteke
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Prilikom kreiranja baze potrebno je da pozovemo odgovarajuce metode biblioteke
    //prilikom kreiranja moramo pozvati TableUtils.createTable za svaku tabelu koju imamo
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, ZadatakTodo.class);
            TableUtils.createTable(connectionSource, Grupa.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //kada zelimo da izmenomo tabele, moramo pozvati TableUtils.dropTable za sve tabele koje imamo
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, ZadatakTodo.class, true);
            TableUtils.dropTable(connectionSource, Grupa.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //jedan Dao objekat sa kojim komuniciramo. Ukoliko imamo vise tabela
    //potrebno je napraviti Dao objekat za svaku tabelu
    public Dao<ZadatakTodo, Integer> getZadatakDao() throws SQLException {
        if (mZadatakDao == null) {
            mZadatakDao = getDao(ZadatakTodo.class);
        }

        return mZadatakDao;
    }

    public Dao<Grupa, Integer> getmGrupaDao() throws SQLException {
        if (mGrupaDao == null) {
            mGrupaDao = getDao(Grupa.class);
        }

        return mGrupaDao;
    }

    //obavezno prilikom zatvarnaj rada sa bazom osloboditi resurse
    @Override
    public void close() {
        mZadatakDao = null;
        mGrupaDao =null;

        super.close();
    }
}
