/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author segur
 */
public class MySQL {
    private static final String DB_URL = "jdbc:mysql://localhost:proyecto/";
    private static final String USER = "root";
    private static final String PASS = "";
    private static final String INSERT_SQL = "INSERT INTO ficheros_importados (file_content) VALUES (?)";


   
   
 

    Date Fecha;

    public static ArrayList<Vehicle> getVehicles() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "");
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM vehiculos")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vehicle vehicle;
                vehicle = new Vehicle(
                        rs.getString("marca"),
                        rs.getString("matricula"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getString("Combustible"),
                        rs.getString("Etiqueta"),
                        rs.getInt("nPlazas") 
                );
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
    
    public static void addVehicle(Vehicle vehicle) throws SQLException{
        String sql = "INSERT INTO vehiculos (bastidor, matricula, marca, modelo, color, combustible, etiqueta, nPlazas) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "");
                PreparedStatement stmnt = conn.prepareStatement(sql)) {
            stmnt.setInt(1, vehicle.getNumeroBastidor());
            stmnt.setString(2, vehicle.getMatricula());
            stmnt.setString(3, vehicle.getMarca());
            stmnt.setString(4, vehicle.getModelo());
            stmnt.setString(5, vehicle.getColor());
            stmnt.setString(6, vehicle.getCombustible());
            stmnt.setString(7, vehicle.getEtiqueta());
            stmnt.setInt(8, vehicle.getnPlazas());
            stmnt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void removeVehicle(Vehicle vehicle) {
    String sql = "DELETE FROM vehiculos WHERE matricula = ? AND bastidor = ? AND marca = ? AND modelo = ? AND color = ? AND combustible = ? AND etiqueta = ? AND nPlazas = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicle.getMatricula());
            pstmt.setInt(2, vehicle.getNumeroBastidor());
            pstmt.setString(3, vehicle.getMarca());
            pstmt.setString(4, vehicle.getModelo());
            pstmt.setString(5, vehicle.getColor());
            pstmt.setString(6, vehicle.getCombustible());
            pstmt.setString(7, vehicle.getEtiqueta());
            pstmt.setInt(8, vehicle.getnPlazas());

            System.out.println("Consulta SQL: " + pstmt.toString());

            int affectedRows = pstmt.executeUpdate();
            System.out.println("Numero de registros eliminados: " + affectedRows);

            if (affectedRows > 0) {
                System.out.println("Vehículo eliminado correctamente de la base de datos.");
            } else {
                System.out.println("No se encontró ningún vehículo que coincida con los criterios de búsqueda.");
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void modifyVehicle(String matricula, String color, String combustible, String etiqueta) {
        String sql = "UPDATE vehiculos SET color = ?, combustible = ?, etiqueta = ? WHERE matricula = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, color);
            pstmt.setString(2, combustible);
            pstmt.setString(3, etiqueta);
            pstmt.setString(4, matricula);

            int affectedRows = pstmt.executeUpdate();
            System.out.println("Number of records updated: " + affectedRows);

            if (affectedRows > 0) {
                System.out.println("Vehículo actualizado correctamente en la base de datos.");
            } else {
                System.out.println("No se encontró ningún vehículo que coincida con la matrícula proporcionada.");
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Vehicle getVehicleByMatricula(String matricula) {
        Vehicle veh = null;
        String sql = "SELECT * FROM vehiculos WHERE matricula = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "");
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                veh = new Vehicle(
                        rs.getString("marca"),
                        rs.getString("matricula"),
                        rs.getString("modelo"),
                        rs.getString("color"),
                        rs.getString("combustible"),
                        rs.getString("etiqueta"),
                        rs.getInt("nPlazas")
                       
                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veh;
        
    }
    
    public void saveToDatabase(String content) {
    String sql = "INSERT INTO ficheros_importados (file_content) VALUES (?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto", "root", "");
             
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, content);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void exportTablesToSQLFile() throws IOException {
            try {
            ArrayList<Vehicle> vehicles = getVehicles();

            StringBuilder sqlContent = new StringBuilder();

            sqlContent.append("/* Archivo SQL generado automáticamente */\n\n");
            sqlContent.append("/* Insertar datos de vehículos */\n");

            for (Vehicle vehicle : vehicles) {
                sqlContent.append("INSERT INTO vehiculos (bastidor, matricula, marca, modelo, color, combustible, etiqueta, nPlazas) VALUES (")
                          .append(vehicle.getNumeroBastidor()).append(", '")
                          .append(vehicle.getMatricula()).append("', '")
                          .append(vehicle.getMarca()).append("', '")
                          .append(vehicle.getModelo()).append("', '")
                          .append(vehicle.getColor()).append("', '")
                          .append(vehicle.getCombustible()).append("', '")
                          .append(vehicle.getEtiqueta()).append("', ")
                          .append(vehicle.getnPlazas()).append(");\n");
            }

            String userHome = System.getProperty("user.home");
            File downloadsFolder = new File(userHome + "/Downloads");
            if (!downloadsFolder.exists()) {
                downloadsFolder.mkdirs();
            }
            File sqlFile = new File(downloadsFolder, "exportacion.sql");
            FileWriter writer = new FileWriter(sqlFile);
            writer.write(sqlContent.toString());
            writer.close();

            Export.showMessage("Se ha generado un archivo SQL en Descargas de tu PC", "Éxito");
        } catch (Exception e) {
            e.printStackTrace();
            Export.showMessage("Error al exportar los datos: " + e.getMessage(), "Error");
        }
    }   
}

  

   
  
