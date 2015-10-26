package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion20 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersSpells" +
                "(" +
                "_id integer primary key," +
                "characterId integer not null," +
                "spellId integer not null," +
                "cost integer not null," +
                "level integer not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (spellId) references Spells (id)" +
                ");");

        execSQL("create index character_id_characters_spells_index on CharactersSpells" +
                "(characterId);");
        execSQL("create index spell_id_characters_spells_index on CharactersSpells" +
                "(spellId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersSpells");
    }

}

