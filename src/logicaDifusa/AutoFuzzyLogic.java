package logicaDifusa;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;

public class AutoFuzzyLogic {
	 public static void main(String[] args) {
	    	
		    
	    	String fileName = "C:/Users/EdgarAstorga/eclipse-workspace/IA/src/auto_fuzzy_logic.fcl";


	        
	        try {
	            FIS fis = FIS.load(fileName, false);
	            if (fis == null) {
	                System.err.println("No se pudo cargar el archivo FCL: " + fileName);
	                return;
	            }

	        Scanner s = new Scanner(System.in);
	        System.out.println("Ingrese los datos del Auto");
	        System.out.println("(potencia, seguridad, precio)\n");
	        
	        System.out.print("Potencia (100 - 500) hp: ");
	        int potencia = s.nextInt();

	        System.out.print("Seguridad: (1 - 10) ");
	        int seguridad = s.nextInt();

	        System.out.print("Precio: (100000 - 1000000) $$: ");
	        double precio = s.nextDouble();
	        s.close();
	        
	        fis.setVariable("potencia", potencia);
	        fis.setVariable("seguridad", seguridad);
	        fis.setVariable("precio", precio);
	        System.out.println();

	        fis.evaluate();

	        double categoria = fis.getVariable("categoria").getValue();
	        System.out.print("La categoria del auto es: ");
	        
	        if (categoria < 30) {
	            System.out.println("baja gama");
	        } else if (categoria < 70) {
	            System.out.println("media gama");
	        } else {
	            System.out.println("alta gama");
	        }
	        
	    }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }}