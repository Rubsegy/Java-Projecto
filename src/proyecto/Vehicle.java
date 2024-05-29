/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

/**
 *
 * @author segur
 */
public class Vehicle {
    private int numero;
    private int NumeroBastidor;
    private String Matricula;
    private String Marca;
    private String Modelo;
    private String Color;
    private String Combustible;
    private String Etiqueta;


   
    
    private static int nextBastidorNumber = 476159843;


  

    private synchronized int generateBastidor() {
        return nextBastidorNumber++;
    }

    
    private int nPlazas;
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
     public int getNumeroBastidor() {
        return NumeroBastidor;
    }

    public void setNumeroBastidor(int NumeroBastidor) {
        this.NumeroBastidor = NumeroBastidor;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getnPlazas() {
        return nPlazas;
    }

    public void setnPlazas(int nPlazas) {
        this.nPlazas = nPlazas;
    }
    
    
    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    public String getCombustible() {
        return Combustible;
    }

    public void setCombustible(String Combustible) {
        this.Combustible = Combustible;
    }

    public String getEtiqueta() {
        return Etiqueta;
    }

    public void setEtiqueta(String Etiqueta) {
        this.Etiqueta = Etiqueta;
    }
    
    public Vehicle(){
        this.NumeroBastidor = generateBastidor();
       
    }
    
 
    
    public Vehicle(String marca, String matricula, String modelo, String Color, String Combustible, String Etiqueta, int nPlazas){
        this.Marca = marca;
        this.Matricula = matricula;
        this.Modelo = modelo;
        this.Color = Color;
        this.Combustible = Combustible;
        this.Etiqueta = Etiqueta;
        this.nPlazas = nPlazas;
    }    
}
