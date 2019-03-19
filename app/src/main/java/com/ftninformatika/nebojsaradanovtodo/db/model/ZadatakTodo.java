package com.ftninformatika.nebojsaradanovtodo.db.model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;

@DatabaseTable(tableName = ZadatakTodo.TABLE_NAME_USERS)
public class ZadatakTodo {

    public static final String TABLE_NAME_USERS = "zadaci_todo";
    public static final String FIELD_NAME_ID     = "id";
    public static final String FIELD_NAME_NAZIV   = "naziv";
    public static final String FIELD_NAME_OPIS   = "opis";
    public static final String FIELD_NAME_PRIORITET = "prioritet";
    public static final String FIELD_NAME_STATUS = "status";
    public static final String FIELD_NAME_DATUM_KREIRANJA  = "datum_kreiranja";
    public static final String FIELD_NAME_DATUM_ZAVRSETKA  = "datum_zavretka";
    public static final String FIELD_NAME_GRUPA  = "grupe";

    @DatabaseField(columnName = FIELD_NAME_ID, generatedId = true)
    private int id;

    @DatabaseField(columnName = FIELD_NAME_NAZIV)
    private String naziv;

    @DatabaseField(columnName = FIELD_NAME_OPIS)
    private String opis;

    @DatabaseField(columnName = FIELD_NAME_PRIORITET)
    private String [] prioritet = {"nizak" , "normalan", "visok"};

    @DatabaseField(columnName = FIELD_NAME_DATUM_KREIRANJA)
    private String datumVremeKreiranja;

    @DatabaseField(columnName = FIELD_NAME_DATUM_ZAVRSETKA)
    private String datumVremeZavrsetka;

    @DatabaseField(columnName = FIELD_NAME_STATUS)
    private String[] status = {"zavrsen", "aktivan"};

    @ForeignCollectionField(columnName = ZadatakTodo.FIELD_NAME_GRUPA, eager = true)
    ArrayList<Grupa> grupe = new ArrayList<>();

    public ZadatakTodo(){
        grupe= new ArrayList<>();
    }

    public ZadatakTodo(int id, String naziv, String opis, String[] prioritet, String datumVremeKreiranja, String datumVremeZavrsetka, String[] status, ArrayList<Grupa> grupe) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.prioritet = prioritet;
        this.datumVremeKreiranja = datumVremeKreiranja;
        this.datumVremeZavrsetka = datumVremeZavrsetka;
        this.status = status;
        this.grupe = grupe;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String[] getPrioritet() {
        return prioritet;
    }

    public void setPrioritet(String[] prioritet) {
        this.prioritet = prioritet;
    }

    public String getDatumVremeKreiranja() {
        return datumVremeKreiranja;
    }

    public void setDatumVremeKreiranja(String datumVremeKreiranja) {
        this.datumVremeKreiranja = datumVremeKreiranja;
    }

    public String getDatumVremeZavrsetka() {
        return datumVremeZavrsetka;
    }

    public void setDatumVremeZavrsetka(String datumVremeZavrsetka) {
        this.datumVremeZavrsetka = datumVremeZavrsetka;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }

    public ArrayList<Grupa> getGrupe() {
        return grupe;
    }

    public void setGrupe(ArrayList<Grupa> grupe) {
        this.grupe = grupe;
    }

    @Override
    public String toString() {
        return naziv + opis;
    }
}
