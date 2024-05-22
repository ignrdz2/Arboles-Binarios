package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        @SuppressWarnings("rawtypes")
        TArbolBB arbol = new TArbolBB<>();

        arbol.insertar(57, 57);
        arbol.insertar(28, 28);
        arbol.insertar(12, 12);
        arbol.insertar(35, 35);
        arbol.insertar(96, 96);
        arbol.insertar(76, 76);
        arbol.insertar(42, 42);
        arbol.insertar(7, 7);
        arbol.insertar(31, 31);
        arbol.insertar(53, 53);
        arbol.insertar(103, 103);
        arbol.insertar(30, 30);
        arbol.insertar(20, 20);
        arbol.insertar(61, 61);
        arbol.insertar(84, 84);
        arbol.insertar(87, 87);

        
        // System.out.println(arbol.preOrden());
        // System.out.println(arbol.inOrden());
        System.out.println(arbol.postOrden());

        System.out.println(arbol.buscar(34));

        // System.out.println("El nodo eliminado es: " + arbol.eliminar(5));
        // System.out.println(arbol.inOrden());

        System.out.println("altura: " + arbol.altura());
        System.out.println("tamano: " + arbol.size());
        System.out.println("cantidad hojas: " + arbol.contarHojas());

        int nivel;
        System.out.println((nivel = arbol.buscarNivel(4)) != -1 ? "La clave se encuentra en el nivel: " + nivel : "La clave no se encuentra en el árbol.");
        System.out.println("Menor clave: " + arbol.buscarMin());
        System.out.println("Mayor clave: " + arbol.buscarMax());
        System.out.println("Predecesor de 30 -> " + arbol.buscarPredecesor(30));
        System.out.println("Cantidad de nodos en el nivel 3: " + arbol.contarNodosNivel(3));
        System.out.println("Todas las hojas: ");
        arbol.listarHojasConNivel();
        System.out.println("Es ABB?: " + arbol.esABB());

        // String[] lineas = ManejadorArchivosGenerico.leerArchivo("./src/entrada.txt");

        // ArrayList<String> lineasEnArbol = new ArrayList<>();

        // for (String linea : lineas) {
        //     if (arbol.buscar(linea) != null) {
        //         // Si la línea está en el árbol, añádela a la lista
        //         lineasEnArbol.add(linea);
        //         System.out.println("Línea encontrada en el árbol: " + linea);
        //     }
        // }
    
        // // Verifica si hay líneas para escribir en el archivo
        // if (!lineasEnArbol.isEmpty()) {
        //     // Escribe las líneas que están en el árbol en un nuevo archivo
        //     ManejadorArchivosGenerico.escribirArchivo("archivoSalida.txt", lineasEnArbol.toArray(new String[0]));
        //     System.out.println("Archivo de salida escrito con éxito.");
        // } else {
        //     System.out.println("No se encontraron líneas en el árbol.");
        // }
        
    }
}
