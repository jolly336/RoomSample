package com.nelson.roomsample;

import androidx.room.Dao;
import androidx.room.Insert;

/**
 * Created by Nelson on 2020/3/7.
 */
@Dao
public interface EmojiDao {

    @Insert
    long[] insert(Emoji... emojis);
}
