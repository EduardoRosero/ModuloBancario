package Transferencias.Manejadores;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




@ManagedBean(name = "Login")
@SessionScoped
public class Login implements Serializable {

    private boolean tipoUser;
    private String userName;
    private String password;
    private String dbuserName;
  
    private String dbpassword;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;
     
  
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getDbuserName() {
        return dbuserName;
    }
 
    public void setDbuserName(String dbuserName) {
        this.dbuserName = dbuserName;
    }
 
    public String getDbpassword() {
        return dbpassword;
    }
 
    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }
 
    public void dbData(String userName)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco","postgres","postgres");
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco");
            statement = connection.createStatement();
            SQL = "Select * from usuario where usuario_email like ('" + userName +"')";
            //SQL = "Select * from Usuario where usuario_email = (' " + userName +" ')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbuserName = resultSet.getString(12);
            dbpassword = resultSet.getString(13);
            tipoUser = resultSet.getBoolean("usuario_tipo");
            System.out.println(dbuserName + dbpassword);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
     
    public String checkValidUser() {
        dbData(userName);

        if (userName.equalsIgnoreCase(dbuserName)) {

            if (password.equals(dbpassword)) {
                if (tipoUser) {
                    return "adminSuccess.jsp";
                }
                return "success.jsp";
            } else {
                return "failure.jsp";
            }
        } else {
            return "failure.jsp";
        }
    }
}
