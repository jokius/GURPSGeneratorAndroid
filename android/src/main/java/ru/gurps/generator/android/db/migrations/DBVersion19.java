package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion19 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersSpecializations" +
                "(" +
                "_id integer primary key," +
                "characterId integer not null," +
                "specializationId integer not null," +
                "cost integer not null," +
                "level integer not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (specializationId) references Specializations (id)" +
                ");");

        execSQL("create index character_id_characters_specializations_index on CharactersSpecializations" +
                "(characterId);");
        execSQL("create index spec_id_characters_specializations_index on CharactersSpecializations" +
                "(specializationId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersSpecializations");
    }

}

