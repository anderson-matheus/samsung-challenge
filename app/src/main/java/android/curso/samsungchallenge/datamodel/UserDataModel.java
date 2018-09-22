package android.curso.samsungchallenge.datamodel;

public class UserDataModel {
    private final static String table = "users";
    private final static String id = "user_id";
    private final static String name = "name";
    private final static String email = "email";
    private final static String password = "password";
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

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getQueryCreateTable() {
        queryCreateTable = "CREATE TABLE IF NOT EXISTS " + table + " ";
        queryCreateTable += "(";
        queryCreateTable += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCreateTable += name + " TEXT, ";
        queryCreateTable += email + " TEXT UNIQUE, ";
        queryCreateTable += password + " TEXT ";
        queryCreateTable += ")";
        return queryCreateTable;
    }

    public static void setQueryCreateTable(String queryCreateTable) {
        UserDataModel.queryCreateTable = queryCreateTable;
    }
}
