import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CreateProject5DB db = new CreateProject5DB();
        EventInterface ei = new Events();
        ei.outputDB();
        System.out.println("==========================");
        ei.outputDB();
        ei.menuOutput();
    }

}