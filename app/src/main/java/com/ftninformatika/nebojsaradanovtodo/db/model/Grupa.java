package com.ftninformatika.nebojsaradanovtodo.db.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;


@DatabaseTable(tableName = Grupa.TABLE_NAME_USERS)
public class Grupa {

    public static final String TABLE_NAME_USERS = "grupe";
    public static final String FIELD_NAME_ID     = "id";
    public static final String FIELD_NAME_NAZIV   = "naziv";
    public static final String FIELD_NAME_DATUM_VREME_KREIRANJA   = "vreme_kreiranja";
    public static final String FIELD_NAME_OZNAKE  = "oznake";
    public static final String FIELD_NAME_ZADACI_TODO  = "zadaci_todo";


    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAZIV)
    private String naziv;

    @DatabaseField(columnName = FIELD_NAME_DATUM_VREME_KREIRANJA )
    private String datumVremeKreiranja;

    @DatabaseField(columnName = FIELD_NAME_OZNAKE)
    private ArrayList<String> oznake;

    @ForeignCollectionField(columnName = Grupa.FIELD_NAME_ZADACI_TODO, eager = true)
    private ArrayList<ZadatakTodo> zadaci;


    public Grupa(){
        zadaci = new ArrayList<>();

    }

    public Grupa(int id, String naziv, String datumVremeKreiranja, ArrayList<String> oznake, ArrayList<ZadatakTodo> zadaci) {
        this.id = id;
        this.naziv = naziv;
        this.datumVremeKreiranja = datumVremeKreiranja;
        this.oznake = oznake;
        this.zadaci =zadaci;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getDatumVremeKreiranja() {
        return datumVremeKreiranja;
    }

    public void setDatumVremeKreiranja(String datumVremeKreiranja) {
        this.datumVremeKreiranja = datumVremeKreiranja;
    }

    public ArrayList<String> getOznake() {
        return oznake;
    }

    public void setOznake(ArrayList<String> oznake) {
        this.oznake = oznake;
    }

    public ArrayList<ZadatakTodo> getZadaci() {
        return zadaci;
    }

    public void setZadaci(ArrayList<ZadatakTodo> zadaci) {
        this.zadaci = zadaci;
    }

    @Override
    public String toString() {
        return  naziv + " "+ datumVremeKreiranja;
    }
}
