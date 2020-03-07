package com.nelson.roomsample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity(tableName = TabEmoji.TABLE_NAME)
public class TabEmoji {

    public static final String TABLE_NAME = "tabEmoji";

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    /**
     * 表情包名称
     */
    public String name;

    /**
     * 表情包图标 url
     */
    public String icon_url;

    /**
     * 表情 list
     */
    @Ignore
    public List<Emoji> emojis;
}
