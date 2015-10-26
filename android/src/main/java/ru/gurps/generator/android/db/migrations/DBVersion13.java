package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion13 extends AbstractMigration {

    public void up() {
        execSQL("create table CharactersAddons" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "addonId integer," +
                "characterId integer default 0 not null," +
                "featureId integer default 0 not null," +
                "level integer," +
                "cost integer," +
                "foreign key (addonId) references Addons (id)," +
                "foreign key (characterId) references Characters (id)," +
                "foreign key (featureId) references Features (id)" +
                ");");

        execSQL("create index character_id_characters_addons_index on CharactersAddons" +
                "(characterId);");
        execSQL("create index addon_id_characters_addons_index on CharactersAddons" +
                "(addonId);");
        execSQL("create index feature_id_characters_addons_index on CharactersAddons" +
                "(featureId);");
    }

    public void down() {
        execSQL("DROP TABLE CharactersFeatures");
    }

}

