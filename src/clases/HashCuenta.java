
package Clases;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HashCuenta {

    int dato;
    int estado; //0 = Vacío, 1 = Eliminado, 2 = Ocupado
    int saldo;
    String cliente;

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public static int funcion(int n, int m) {
        return ((n) % m);
    }

    public static void insertaHash(HashCuenta[] h, int m, int n, String cli, int sal) {
        boolean i = false;
        int j = funcion(n, m);
        do {
            if (h[j].estado == 0 || h[j].estado == 1) {
                h[j].dato = n;
                h[j].saldo = sal;
                h[j].cliente = cli;
                h[j].estado = 2;
                i = true;
            } else {
                j++;
            }
        } while (j < m && !i);
        if (i) {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Elemento insertado con éxito!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "¡Tabla llena!");
        }
    }
    public static int buscaHash(HashCuenta[] h, int m, int n, JTable t) {
     
      DefaultTableModel modelo1=(DefaultTableModel)t.getModel();

        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                   modelo1.addRow(new Object[]{h[j].dato,h[j].cliente,h[j].saldo});
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;

    }
    public static int buscaHash(HashCuenta[] h, int m, int n) {
        int j = funcion(n, m);
        while (j < m) {
            if (h[j].estado == 0) {
                return -1;
            } else if (h[j].dato == n) {
                if (h[j].estado == 1) {
                    return -1;
                } else {
                    return j;
                }
            } else {
                j++;
            }
        }
        return -1;

    }

}
