package android.curso.samsungchallenge.datamodel;

public class CardDataModel {
    private static final String table = "cards";
    private static final String id = "card_id";
    private static final String name = "name";
    private static final String content = "content";
    private static final String userId = "user_id";
    private static final String createdAt = "created_at";

    public static String getCreatedAt() {
        return createdAt;
    }

    private static String queryCreateTable = "";

    public static String getTable() {
        return table;
    }

    public static String getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getContent() {
        return content;
    }

    public static String getUserId() {
        return userId;
    }

    public static String getQueryCreateTable() {
        queryCreateTable = "CREATE TABLE IF NOT EXISTS " + table + " ";
        queryCreateTable += "(";
        queryCreateTable += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCreateTable += name + " VARCHAR(80) NOT NULL, ";
        queryCreateTable += content + " TEXT NOT NULL, ";
        queryCreateTable += userId + " INTEGER NOT NULL, ";
        queryCreateTable += "created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP";
        queryCreateTable += ")";
        return queryCreateTable;
    }

    public static void setQueryCreateTable(String queryCreateTable) {
        CardDataModel.queryCreateTable = queryCreateTable;
    }
}
