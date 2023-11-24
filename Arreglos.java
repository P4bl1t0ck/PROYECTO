import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;

public class Arreglos {
    public static void ordenaArreglo(Object[] arreglo){
        /// Este metodo solo ordena las cadenas lo caul puedo usar
        //Para eliminar o guardar cosas mhhh se me ocurre algo
        int total = arreglo.length-1;
        int contador = 0;
        for (int i=0; i<total; i++){
            for(int j=0; j< total-i; j++){
                if(((Comparable)arreglo[j+1]).compareTo(arreglo[j])<0)
                {
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                }
                contador++;
            }
        }
    }
    public static void main(String[] args) {
        
        String[] productos = {"KP64GB","SGalS9","HD ssd San Ext",
                              "Asus NB","MacBook Air","Chromecast 4ta Gen",
                              "Moto Royal Enfield 650"};

        // Cadena de caractéres
        // Hallar la magnitud de la matriz productos
        int total = productos.length-1;

        //Bucle for
        System.out.println();
        for (int i=0; i<total; i++){
            System.out.println("Indice " + i + " : " + productos[i]);
        }
        ordenaArreglo(productos);
        
        System.out.println();
        for (int i=0; i<total; i++){
            System.out.println("Indice " + i + " : " + productos[i]);
        }
        
        
        // Con números
        int[] numeros = new int[4];

        numeros[0]=35;
        numeros[1]=7;
        numeros[2]=Integer.valueOf("4");
        numeros[3]=-1;

        System.out.println();
        int total1 = numeros.length-1;
        for(int i=0; i<total1; i++){
            System.out.println(numeros[i]);
        }

        
                
        for(int i=0; i<total; i++){
            System.out.println(productos[i]);
        }





    }
}
