package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion21 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersTechniques" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "characterId integer not null," +
                "techniqueId integer not null," +
                "cost integer not null," +
                "level integer not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (techniqueId) references Techniques (id)" +
                ");");

        execSQL("create index character_id_characters_techniques_index on CharactersTechniques" +
                "(characterId);");
        execSQL("create index technique_id_characters_techniques_index on CharactersTechniques" +
                "(techniqueId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersTechniques");
    }

}

