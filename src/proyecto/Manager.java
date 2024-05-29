package proyecto;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;


public class Manager {
    private MySQL MySQL;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    
    public Manager(){
        MySQL = new MySQL();
    }

    public  void addVehicle(Vehicle vehicle) throws SQLException {
        vehicles.add(vehicle);
        MySQL.addVehicle(vehicle);
    }

    public  void deleteVehicle(Vehicle vehicle) {
        Iterator<Vehicle> iterator = vehicles.iterator();
        boolean delete = false;
        
        while (iterator.hasNext()) {
            Vehicle v = iterator.next();
            if (v.getMatricula().equals(vehicle.getMatricula())) {
                iterator.remove();
                delete = true;
                break;
            }
        }
        
        if(delete){
            MySQL.removeVehicle(vehicle);
            System.out.println("Vehículo eliminado de la lista y de la base de datos.");
        }else{
            System.err.println("Error: Vehículo con matrícula" +vehicle.getMatricula() + " no encontrado en la lista.");
        }
    }
    
    public void updateVehicle(String matricula, String color, String combustible, String etiqueta) {
     for (Vehicle vehicle : vehicles) {
        if (vehicle.getMatricula().equals(matricula)) {
            vehicle.setColor(color);
            vehicle.setCombustible(combustible);
            vehicle.setEtiqueta(etiqueta);
            MySQL.modifyVehicle(matricula, color, combustible, etiqueta);
            return;
        }
    }
    System.err.println("Error: No se encontró ningún vehículo con la matrícula proporcionada.");
   }
    
    public void ImportarDatos(File file){
        StringBuilder ficheroContenido = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                ficheroContenido.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       
       
        String fileContent = "Contenido del archivo...";
        MySQL.saveToDatabase(ficheroContenido.toString());
    }
    
    public void exportData() throws IOException {
        MySQL.exportTablesToSQLFile();
    }

    public ArrayList<Vehicle> getVehicles() {
        //return MySQL.getVehicles();
        return vehicles;
    }
    
     public void setVehicles(ArrayList vehicles) {
       this.vehicles=vehicles;
    }
}
