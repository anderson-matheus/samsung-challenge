package android.curso.samsungchallenge.datamodel;

public class TaskDataModel {
    private static final String table = "tasks";
    private static final String id = "task_id";
    private static final String name = "name";
    private static final String userId = "user_id";
    private static String queryCreateTable = "";

    public static String getUserId() {
        return userId;
    }

    public static String getTable() {
        return table;
    }

    public static String getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static String getQueryCreateTable() {
        queryCreateTable = "CREATE TABLE IF NOT EXISTS " + table + " ";
        queryCreateTable += "(";
        queryCreateTable += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCreateTable += name + " VARCHAR(80) NOT NULL, ";
        queryCreateTable += userId + " INTEGER NOT NULL, ";
        queryCreateTable += "created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP";
        queryCreateTable += ")";
        return queryCreateTable;
    }

    public static void setQueryCreateTable(String queryCreateTable) {
        TaskDataModel.queryCreateTable = queryCreateTable;
    }
}
