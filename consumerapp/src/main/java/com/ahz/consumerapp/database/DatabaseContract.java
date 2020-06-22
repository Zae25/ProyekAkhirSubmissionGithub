package com.ahz.proyekakhirsubmissiongithub.database;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {

    public static final String AUTHORITY = "com.ahz.proyekakhirsubmissiongithub";
    public static final String SCHEME = "content";

    public DatabaseContract(){}

    public static final class FavoriteColumn implements BaseColumns {
        public static final String TABLE_FAVORITE_NAME = "favorite";
        // Favorite id
        public static final String ID = "id";
        // Favorite title
        public static final String TITLE = "login";
        // Favorite Image
        public static final String IMAGE = "avatar_url";

        public static final Uri FAVORITE_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_FAVORITE_NAME)
                .build();
    }

    public static String getFavorite(Cursor cursor, String columns) {
        return cursor.getString(cursor.getColumnIndex(columns));
    }
}
