
package douglasperez;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Nombre de la clase: DouglasPerez
 * Fecha: 19/04/2018
 * CopyRight: Douglas
 * @author Balmore Perez
 */
public class DouglasPerez {

    public static void main(String[] args) {
        String nombre[] = new String[999];
        int cantidad[] = new int[999];
        double precioUnitario[] = new double[999];
        double iva[] = new double[999];
        double compraTotal[] = new double[999];
        double compraFinal[] = new double[999];
        double descuento[] = new double[999];
        int contador=0;
        int opcion=0;
        int i=0;
        
        DecimalFormat df = new DecimalFormat("##.##");
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer? \n1) Agregar compra \n2)Calcular total\n3) Salir"));
            
            while (opcion==1)
            {
                nombre[i] = JOptionPane.showInputDialog("Ingrese nombre de producto:");
                cantidad[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad:"));
                precioUnitario[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio unitario:"));
                             
                iva[i] = precioUnitario[i]*0.13;
                compraTotal[i] = precioUnitario[i]+iva[i];
                if(compraTotal[i]>200 && compraTotal[i]<=500)
                {
                    descuento[i] = compraTotal[i]*0.20;
                    compraFinal[i] = compraTotal[i]-descuento[i];
                }
                else if(compraTotal[i]>500 && compraTotal[i]<=800)
                {
                    descuento[i] = compraTotal[i]*0.22;
                    compraFinal[i] = compraTotal[i]-descuento[i];
                }
                else if(compraTotal[i]>800)
                {
                    descuento[i] = compraTotal[i]*0.30;
                    compraFinal[i] = compraTotal[i]-descuento[i];
                    
                    contador = contador + 1;

                }
                
                i=i+1;
                opcion = 0;
            }
            if(opcion==2)
            {
                for(int j=0; j<i; j++)
                {
                    JOptionPane.showMessageDialog(null, "Datos"
                            + "\n Nombre del producto: "+nombre[j]+""
                            + "\nCantidad: "+cantidad[j]+""
                            + "\nPrecio Unitario: "+precioUnitario[j]+""
                            + "\nTotal con IVA: "+nf.format(compraTotal[j])+""
                            + "\nTotal Final: "+nf.format(compraFinal[j]));
                }
                JOptionPane.showMessageDialog(null, "Cantidad de compras superiores a $800: "+contador);
            }            
        }while(opcion!=3);            
    }
    
}
