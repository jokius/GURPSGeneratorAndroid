package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion15 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersLanguages" +
                "(" +
                "_id integer primary key," +
                "characterId integer not null," +
                "languageId integer not null," +
                "spoken integer default 0 not null," +
                "written integer default 0 not null," +
                "cost integer default 0 not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (languageId) references Languages (id)" +
                ");");

        execSQL("create index character_id_characters_languages_index on CharactersLanguages" +
                "(characterId);");
        execSQL("create index language_id_characters_languages_index on CharactersLanguages" +
                "(languageId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersLanguages");
    }

}

