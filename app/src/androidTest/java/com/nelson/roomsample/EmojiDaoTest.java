package com.nelson.roomsample;

import static org.hamcrest.core.IsEqual.equalTo;

import android.content.Context;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Nelson on 2020/3/7.
 */
@RunWith(AndroidJUnit4.class)
public class EmojiDaoTest {

    private EmojiDatabase mDb;
    private TabEmojiDao mTabEmojiDao;
    private EmojiDao mEmojiDao;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        this.mDb = Room.inMemoryDatabaseBuilder(context, EmojiDatabase.class).build();
        this.mTabEmojiDao = this.mDb.getTabEmojiDao();
        this.mEmojiDao = this.mDb.getEmojiDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void queryByRelation() throws Exception {
        initData();
        final List<EmojiGroup> groupEmojis = mTabEmojiDao.queryByRelation();
        MatcherAssert.assertThat(groupEmojis.get(0).emojis.get(0).name, equalTo("666 1"));
    }

    @Test
    public void queryByRelationWithId() throws Exception {
        initData();
        EmojiGroup groupEmoji = mTabEmojiDao.queryByRelationWithId(13);
        MatcherAssert.assertThat(groupEmoji.emojis.get(0).name, equalTo("666 1"));
    }

    private TabEmoji initData() {
        // tabEmoji
        TabEmoji tabEmoji = new TabEmoji();
        tabEmoji.id = 13;
        tabEmoji.name = "老铁";
        tabEmoji.icon_url = "https://www.kuaishou.com";
        final long[] tabEmojiIdArr = mTabEmojiDao.insert(tabEmoji);

        // emojis
        List<Emoji> emojis = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Emoji emoji = new Emoji();
            emoji.id = i;
            emoji.tabId = 13;
            emoji.name = "666 " + i;
            emoji.fileUrl = "https://www.emoji.com/" + i;
            emoji.width = i;
            emoji.height = i;
            emojis.add(emoji);
        }

        final long[] emojiIdArr = mEmojiDao.insert(emojis.toArray(new Emoji[0]));
        return tabEmoji;
    }
}
