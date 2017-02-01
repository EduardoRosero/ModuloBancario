package Transferencias.Manejadores;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Transferencias.Entidades.Movimiento;
import Transferencias.Presentaciones.MovimientoController;

@ManagedBean(name = "Transferencias")
@SessionScoped
public class Transferencias implements Serializable {

    private boolean tipoUser;
    private double bdUserSaldo;
    private double userSaldo;
    private final Calendar fecha = Calendar.getInstance(Locale.ENGLISH);
    private final Calendar hora = Calendar.getInstance(Locale.ENGLISH);
    private String userCuentaRestar;
    private String userCuentaSumar;
    private String userEmail;
    

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    
    public double getBdUserSaldo() {
        return bdUserSaldo;
    }

    public void setBdUserSaldo(double bdUserSaldo) {
        this.bdUserSaldo = bdUserSaldo;
    }

    public double getUserSaldo() {
        return userSaldo;
    }

    public void setUserSaldo(double userSaldo) {
        this.userSaldo = userSaldo;
    }

    public String getUserCuentaRestar() {
        return userCuentaRestar;
    }

    public void setUserCuentaRestar(String userCuentaRestar) {
        this.userCuentaRestar = userCuentaRestar;
    }

    public void dbDataSaldo(String userCuentaRestar) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco");
            statement = connection.createStatement();
            //SQL = "Select * from cuenta where cuenta_num like ('" + userCuentaRestar + "')";
            SQL = "Select saldo from cuenta where usuario_id = (Select usuario_id from usuario where usuario_email like ('" + userCuentaRestar + "'))";
            //SQL = "Select * from Usuario where usuario_email = (' " + userCuentaRestar +" ')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            bdUserSaldo = resultSet.getDouble(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
  
    public String verificarSaldo() {
        dbDataSaldo(userEmail);

        if (userSaldo <= bdUserSaldo) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
                //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco");
                statement = connection.createStatement();
                SQL = "update cuenta set saldo = saldo + ('" + userSaldo + "') where cuenta_num = ('" + userCuentaSumar + "')";
                SQL = "update cuenta set saldo = saldo - ('" + userSaldo + "') where cuenta_num = ('" + userCuentaRestar + "')";
                //SQL = "Select * from Usuario where usuario_email = (' " + userCuentaRestar +" ')";
                resultSet = statement.executeQuery(SQL);
                resultSet.next();
                //bdUserSaldo = resultSet.getDouble(5);
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Exception Occured in the process :" + ex);
            }
            return "hola";
        } else {
            return "sinSaldo.xhtml";
        }

    }
    
    
    
      public double filtrarSaldo() {
        try {
            
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco");
            statement = connection.createStatement();
            SQL = "Select saldo from cuenta where usuario_id = (Select usuario_id from usuario where usuario_email like ('" + userEmail + "'))";
            //SQL = "Select * from Usuario where usuario_email = (' " + userCuentaRestar +" ')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            bdUserSaldo = resultSet.getDouble(5);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        return bdUserSaldo;
    }

}
