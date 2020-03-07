package com.nelson.roomsample;

import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;

/**
 * Created by Nelson on 2020/3/7.
 */
public class EmojiGroup {

    @Embedded
    public TabEmoji tabEmoji;

    @Relation(parentColumn = "id", entityColumn = "tab_id", entity = Emoji.class)
    public List<Emoji> emojis;
}
