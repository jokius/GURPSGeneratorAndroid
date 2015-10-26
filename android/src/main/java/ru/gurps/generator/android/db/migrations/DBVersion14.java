package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion14 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersCulturas" +
                "(" +
                "_id integer primary key," +
                "characterId integer not null," +
                "culturaId integer not null," +
                "cost integer default 0 not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (culturaId) references Culturas (id)" +
                ");");

        execSQL("create index character_id_characters_culturas_index on CharactersCulturas" +
                "(characterId);");
        execSQL("create index cultura_id_characters_culturas_index on CharactersCulturas" +
                "(culturaId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersCulturas");
    }

}

