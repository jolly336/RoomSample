package com.nelson.roomsample;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TabEmoji.class, Emoji.class}, version = EmojiDatabase.DB_VERSION, exportSchema = true)
public abstract class EmojiDatabase extends RoomDatabase {

    public static final int DB_VERSION = 1;

    public abstract TabEmojiDao getTabEmojiDao();

    public abstract EmojiDao getEmojiDao();


    private static EmojiDatabase mInstance;

    public static EmojiDatabase getInstance() {
        if (mInstance == null) {
            synchronized (EmojiDatabase.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(ContextGetter.getContext(), EmojiDatabase.class, "emoji_all.db").build();
                }
            }
        }
        return mInstance;
    }
}
