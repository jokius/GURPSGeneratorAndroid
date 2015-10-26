package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion16 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersModifiers" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "characterId integer not null," +
                "modifierId integer not null," +
                "featureId integer not null," +
                "cost integer not null," +
                "level integer not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (modifierId) references Modifiers (id)," +
                "foreign key (featureId) references Features (id)" +
                ");");

        execSQL("create index character_id_characters_modifiers_index on CharactersModifiers" +
                "(characterId);");
        execSQL("create index modifier_id_characters_modifiers_index on CharactersModifiers" +
                "(modifierId);");
        execSQL("create index feature_id_characters_modifiers_index on CharactersModifiers" +
                "(featureId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersModifiers");
    }

}

