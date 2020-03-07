package com.nelson.roomsample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Emoji.TABLE_NAME/*, foreignKeys = @ForeignKey(entity = TabEmoji.class, parentColumns = "id", childColumns = "tab_id")*/)
public class Emoji {

    public static final String TABLE_NAME = "emoji";

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "tab_id")
    public int tabId;

    public String name;

    public String fileUrl;

    public int width;

    public int height;
}
