package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion12 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersFeatures" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "characterId integer," +
                "featureId integer," +
                "level integer," +
                "cost integer," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (featureId) references Features (id)" +
                ");");

        execSQL("create index character_id_characters_features_index on CharactersFeatures" +
                "(characterId);");
        execSQL("create index feature_id_characters_features_index on CharactersFeatures" +
                "(featureId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersFeatures");
    }

}

