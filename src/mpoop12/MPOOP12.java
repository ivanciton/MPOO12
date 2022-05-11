/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mpoop12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class MPOOP12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        File archivo=new File("archivo.txt"); //creacion del objeto al que se le hara referencia el archivo
        System.out.println(archivo.exists());//preguntando si el archivo existe
        
        try {
            boolean seCreo =archivo.createNewFile();
            System.out.println("Se creo="+seCreo);
            System.out.println(archivo.exists());
            
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        System.out.println("###########FileWriter######################################");   
        
        
        try {
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba el texto para el archivo: ");
            String texto=br.readLine();
            
            //FileWriter fw=new FileWriter("fw.csv");  
            FileWriter fw=new FileWriter("fw.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida =new PrintWriter(bw);
            salida.println(texto);
            
            for (int i = 0; i < 10; i++) {
                salida.println("linea del for "+i);
            }
            salida.close();
            
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("###########FileReader#####################");
        
        try {
           
            FileReader fr=new FileReader("fw.txt");
            BufferedReader br= new BufferedReader(fr);
            System.out.println("El texto del archivo es:");
            String linea=br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea=br.readLine();
                
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("#################StringTokenizer######################");
        
        Platillo platillo= new Platillo();
        float temp=0;
        String textoTemporal;
        String linea = "Enchiladas,70,Pollo/crema/queso";
        StringTokenizer tokenizador= new StringTokenizer(linea,",");
        
        while (tokenizador.hasMoreTokens()) {
            textoTemporal=tokenizador.nextToken();
            if(temp==0)
                platillo.setNombre(textoTemporal);
            else if (temp==1){
                platillo.setPrecio(Double.parseDouble(textoTemporal));
            }else if(temp==2){
                platillo.setIngredientes(textoTemporal);
            }
            System.out.println(textoTemporal);
            temp++;
        }
        System.out.println(platillo);
        System.out.println(temp);
        
        System.out.println("###############ejercico extra####################");
        System.out.println("###########creando el archivo platillos.txt#####################");
        try {
            BufferedReader br1= new BufferedReader(new InputStreamReader(System.in));  
            //FileWriter fw=new FileWriter("fw.csv");  
            FileWriter fw=new FileWriter("platillos.txt");
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter salida2 =new PrintWriter(bw);
            int j=1;
            for (int i = 0; i < 10; i++) {
               
               System.out.println("platillo "+j+":");
               String texto=br1.readLine();
               salida2.println(texto);
               j++;
            }
            salida2.close();
            
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("###########Leyendo el archivo platillos.txt#####################");
        
        try {
            
            ArrayList<Platillo> ListaPlatillos = new ArrayList<Platillo>();
            
            FileReader fr1=new FileReader("platillos.txt");
            BufferedReader br1= new BufferedReader(fr1);
            
            
            String linea2 = br1.readLine();
            
            int cont=0;
            int i=0;
            String auxiliar;
            
            while (linea2 != null) {
                StringTokenizer tokenizador1= new StringTokenizer(linea2,",");
                Platillo platilloNuevo = new Platillo();
                
                while(tokenizador1.hasMoreElements()){
                    //System.out.println(tokenizador1.nextElement());
                    auxiliar=tokenizador1.nextToken();
                    //System.out.println(auxiliar);
                    if(cont==0)
                        platilloNuevo.setNombre(auxiliar);
                    else if(cont==1)
                        platilloNuevo.setPrecio(Double.parseDouble(auxiliar));
                    else if(cont==2)
                        platilloNuevo.setIngredientes(auxiliar);
                    cont++;
                }
                ListaPlatillos.add(platilloNuevo);
                linea2= br1.readLine();
                cont=0;
               
            }
            br1.close();
            
            
            System.out.println("***********Lista de Platilos**************");
            
            for (Platillo ListaPlatillo : ListaPlatillos) {
                System.out.println(ListaPlatillo);
            }
            System.out.println("Cantidad de platillos: "+ListaPlatillos.size());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MPOOP12.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
}
