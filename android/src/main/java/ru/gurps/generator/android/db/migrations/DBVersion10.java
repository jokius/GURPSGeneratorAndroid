package ru.gurps.generator.android.db.migrations;

import com.b50.migrations.AbstractMigration;

public class DBVersion10 extends AbstractMigration {

    public void up() {
        execSQL("create table Languages" +
                "(" +
                "_id integer auto_increment primary key not null," +
                "name varchar(255) not null" +
                ");");
    }

    public void down() {
        execSQL("DROP TABLE Languages");
    }

}

