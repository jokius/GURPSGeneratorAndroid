package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion17 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersQuirks" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "characterId integer not null," +
                "quirkId integer not null," +
                "cost integer default 0 not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (quirkId) references Quirks (id)" +
                ");");

        execSQL("create index character_id_characters_quirks_index on CharactersQuirks" +
                "(characterId);");
        execSQL("create index quirk_id_characters_quirks_index on CharactersQuirks(quirkId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersQuirks");
    }

}

