package org.pickfordfamily.sh.db;

import android.provider.BaseColumns;

public final class ScriptureHelperContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ScriptureHelperContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Volume implements BaseColumns {
        public static final String TABLE_NAME = "volume";
        public static final String COLUMN_NAME_VOLUME_ID = "volumeid";
        public static final String COLUMN_NAME_NAME = "name";
    }
    
    /* Inner class that defines the table contents */
    public static abstract class Book implements BaseColumns {
        public static final String TABLE_NAME = "book";
        public static final String COLUMN_NAME_BOOK_ID = "bookid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_VOLUME_ID = "volumeid";
    }
    
    /* Inner class that defines the table contents */
    public static abstract class Chapter implements BaseColumns {
        public static final String TABLE_NAME = "chapter";
        public static final String COLUMN_NAME_CHAPTER_ID = "chapterid";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_BOOK_ID = "bookid";
        public static final String COLUMN_NAME_WAS_READ = "wasread";
    }
    
}