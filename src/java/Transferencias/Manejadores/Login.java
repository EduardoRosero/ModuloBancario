package Transferencias.Manejadores;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "Login")
@SessionScoped
public class Login implements Serializable {

    private boolean tipoUser;
    private String userName;
    private String password;
    private String dbuserName;
    private double bdUserSaldo;
    private double userSaldo;
    private double userValorTransferencia;
    private int cuentaId;
    private Calendar fecha;// 
    private Calendar hora;// 
    private String userCuentaRestar;
    private String userCuentaSumar;
    private String userEmail;

    private String dbpassword;
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;

    public Calendar getFecha() {
        return fecha;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = Calendar.getInstance(Locale.ENGLISH);
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = Calendar.getInstance(Locale.ENGLISH);
    }

    
    
    public boolean isTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(boolean tipoUser) {
        this.tipoUser = tipoUser;
    }

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

    public String getUserCuentaSumar() {
        return userCuentaSumar;
    }

    public void setUserCuentaSumar(String userCuentaSumar) {
        this.userCuentaSumar = userCuentaSumar;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public double getUserValorTransferencia() {
        return userValorTransferencia;
    }

    public void setUserValorTransferencia(double userValorTransferencia) {
        this.userValorTransferencia = userValorTransferencia;
    }

    public void dbData(String userName) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco");
            statement = connection.createStatement();
            SQL = "Select * from usuario where usuario_email like ('" + userName + "')";
            //SQL = "Select * from Usuario where usuario_email = (' " + userName +" ')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbuserName = resultSet.getString(12);
            dbpassword = resultSet.getString(13);
            tipoUser = resultSet.getBoolean("usuario_tipo");
            System.out.println(dbuserName + dbpassword);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
    }
    
    public int selectCuentaId() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            statement = connection.createStatement();
            SQL = "Select cuenta_id from cuenta where cuenta_num like ('" + userCuentaRestar + "')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            cuentaId = resultSet.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        return cuentaId;
    }
    
    public int selectUsuarioId() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            statement = connection.createStatement();
            SQL = "Select usuario_id from cuenta where cuenta_num like ('" + userCuentaRestar + "')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            cuentaId = resultSet.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        return cuentaId;
    }

    public String checkValidUser() {
        dbData(userName);

        if (userName.equalsIgnoreCase(dbuserName)) {

            if (password.equals(dbpassword)) {
                if (tipoUser) {
                    return "adminSucces.xhtml";
                }
                return "success.xhtml";
            } else {
                return "failure.jsp";
            }
        } else {
            return "failure.jsp";
        }
    }

    public double filtrarSaldo() {
        try {

            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco");
            statement = connection.createStatement();
            //('" + userName + "')
            SQL = "select saldo from cuenta where usuario_id = (select usuario_id from usuario where usuario_email = ('" + userName + "'))";

            //SQL = "Select * from Usuario where usuario_email = (' " + userCuentaRestar +" ')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            bdUserSaldo = resultSet.getDouble(1);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
        return bdUserSaldo;
    }

   public void validarSaldo(){
       filtrarSaldo();
       if(userValorTransferencia<=bdUserSaldo)
       {
           actualizarIncremento();
           actualizarDecremento();
           crearNuevoMovimientoIncremento();
           crearNuevoMovimientoDecremento();
       }
       else
       {
           System.out.println("Sin saldo");
       }
   }
   
   public void actualizarIncremento()
   {
       try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            statement = connection.createStatement();
            SQL = "update cuenta set saldo = saldo + ('" + userValorTransferencia + "') where cuenta_num = ('" + userCuentaSumar + "')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
   }
   
   public void actualizarDecremento()
   {
       try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            statement = connection.createStatement();
            SQL = "update cuenta set saldo = saldo - ('" + userValorTransferencia + "') where cuenta_num = ('" + userCuentaRestar + "')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
   }
   
   public void crearNuevoMovimientoIncremento()
   {
       try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            statement = connection.createStatement();
            SQL = "insert into movimiento (, cuenta_id, tipo_id, mov_fecha, mov_hora, mov_valor, mov_origen, mov_destino) "
                    + " values ( ('" + cuentaId + "'), 1, ('" + fecha + "'), ('" + hora + "'), ('" + userValorTransferencia + "'), ('" + userCuentaSumar + "'), ('" + userCuentaRestar + "')  )";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
   }
   
   public void crearNuevoMovimientoDecremento()
   {
       try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bdbanco", "postgres", "postgres");
            statement = connection.createStatement();
            SQL = "insert into movimiento (, cuenta_id, tipo_id, mov_fecha, mov_hora, mov_valor, mov_origen, mov_destino) "
                    + " values ( ('" + cuentaId + "'), 2, ('" + fecha + "'), ('" + hora + "'), ('" + userValorTransferencia + "'), ('" + userCuentaRestar + "'), ('" + userCuentaSumar + "')  )";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception Occured in the process :" + ex);
        }
   }
   
   
   
   
}
