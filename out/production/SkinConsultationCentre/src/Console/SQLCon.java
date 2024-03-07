package Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLCon {

    private Connection connection;
    private Statement statement;


    public SQLCon(){

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SkinCare","root","ddx33450508");
            statement = connection.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }


    public ResultSet GetData(String sqlquery){

        ResultSet resultset = null;

        try{
            resultset = statement.executeQuery(sqlquery);
        }catch(Exception e){
            System.out.println(e);
        }
        return resultset;
    }


    public Boolean UpdateData(String sqlquery){

        Boolean isUpdated = false;
        int ret=0;

        try{
            ret = statement.executeUpdate(sqlquery);
            connection.close();

        }catch(Exception e){
            System.out.println(e);
        }
        if (ret == 1) isUpdated = true;

        return isUpdated;

    }

}
