package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion18 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersSkills" +
                "(" +
                "_id integer primary key," +
                "characterId integer not null," +
                "skillId integer not null," +
                "cost integer not null," +
                "level integer not null," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (skillId) references Skills (id)" +
                ");");

        execSQL("create index character_id_characters_skills_index on CharactersSkills" +
                "(characterId);");
        execSQL("create index skill_id_characters_skills_index on CharactersSkills" +
                "(skillId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersSkills");
    }

}

