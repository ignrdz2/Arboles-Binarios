package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TArbolBB<T> implements IArbolBB<T> {

    // private String inorden = "";
    // private String postorden = "";
    // private String preorden = "";

    TElementoAB<T> raiz;
    public TArbolBB(){
        raiz = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(@SuppressWarnings("rawtypes") Comparable etiqueta, T dato) {

        TElementoAB<T> n = new TElementoAB(etiqueta, dato);
        n.setDato(dato);

        if(raiz == null){
            raiz = n;
            return true;
        } else{
            TElementoAB<T> aux = raiz;
            while(aux != null){
                n.padre = aux;//
                if(n.getEtiqueta().compareTo(aux.getEtiqueta()) > 0){
                    aux = aux.getHijoDer();
                } else{
                    aux = aux.getHijoIzq();
                }
            }
        }

        if(n.getEtiqueta().compareTo(n.padre.getEtiqueta()) < 0){
            n.padre.setHijoIzq(n);
            return true;
        } else{
            n.padre.setHijoDer(n);
            return true;
        }

    }

    @Override
    public TElementoAB<T> buscar(Comparable id) {
        TElementoAB<T> aux = raiz;
        while(aux.getEtiqueta() != id){
            if(id.compareTo(aux.getEtiqueta()) < 0){
                aux = aux.getHijoIzq();
            } else{
                aux = aux.getHijoDer();
            }
            if(aux == null){
                return null;
            }
        }
        
        return new TElementoAB<T>(aux.getEtiqueta(), aux.getDato());   
    }

    @Override
    public String preOrden(){
        return preOrdenRecursivo(raiz, new StringBuilder()).toString();
    }

    private StringBuilder preOrdenRecursivo(TElementoAB<T> n, StringBuilder resultado){
        if(n != null){
            resultado.append(n.getEtiqueta()).append(" ");
            preOrdenRecursivo(n.getHijoIzq(), resultado);
            preOrdenRecursivo(n.getHijoDer(), resultado);
        }
        return resultado;
    }

    @Override
    public String inOrden() {
        return inOrdenRecursivo(raiz, new StringBuilder()).toString();
    }

    private StringBuilder inOrdenRecursivo(TElementoAB<T> n, StringBuilder resultado) {
        if (n != null) {
            inOrdenRecursivo(n.getHijoIzq(), resultado);
            resultado.append(n.getEtiqueta()).append(" ");
            inOrdenRecursivo(n.getHijoDer(), resultado);
        }
        return resultado;
    }

    @Override
    public String postOrden() {
        return postOrdenRecursivo(raiz, new StringBuilder()).toString();
    }
    
    private StringBuilder postOrdenRecursivo(TElementoAB<T> n, StringBuilder resultado){
        if(n != null){
            postOrdenRecursivo(n.getHijoIzq(), resultado);
            postOrdenRecursivo(n.getHijoDer(), resultado);
            resultado.append(n.getEtiqueta()).append(" ");
        }
        return resultado;
    }

    @Override
    public T eliminar(Comparable id) {
        TElementoAB<T> aux = raiz;
        TElementoAB<T> padre = raiz;
        boolean esIzq = true;
        T datoEliminado = null;

        while(aux.getEtiqueta() != id){
            padre = aux;
            if(id.compareTo(aux.getEtiqueta()) < 0){
                esIzq = true;
                aux = aux.getHijoIzq();
            } else{
                esIzq = false;
                aux = aux.getHijoDer();
            }
            // Llegó al final y no lo encontró
            if(aux == null){
                return null;
            }
        }

        datoEliminado = aux.getDato();
        //Caso que sea una hoja
        if(aux.getHijoIzq() == null && aux.getHijoDer() == null){
            if(aux == raiz){
                raiz = null;
            } else if(esIzq){
                padre.setHijoIzq(null);
            } else{
                padre.setHijoDer(null);;
            }
            //
        } else if(aux.getHijoDer() == null){
            if(aux == raiz){
                raiz = aux.getHijoIzq();
            } else if(esIzq){
                padre.setHijoIzq(aux.getHijoIzq());
            } else{
                padre.setHijoDer(aux.getHijoIzq());
            }
            //
        } else if(aux.getHijoIzq() == null){
            if(aux == raiz){
                raiz = aux.getHijoDer();
            } else if(esIzq){
                padre.setHijoDer(aux.getHijoDer());
            } else{
                padre.setHijoIzq(aux.getHijoDer());
            }
            //
        } else{
            TElementoAB<T> reemplazo = obtenerNodoReemplazo(aux);
            if(aux == raiz){
                raiz = reemplazo;
            } else if(esIzq){
                padre.setHijoIzq(reemplazo);
            } else{
                padre.setHijoDer(reemplazo);
            }
            reemplazo.setHijoIzq(aux.getHijoIzq());
        }

        
        return datoEliminado;
    }

    private TElementoAB<T> obtenerNodoReemplazo(TElementoAB<T> nodoReemp){
        TElementoAB<T> reemplazarPadre = nodoReemp;
        TElementoAB<T> reemplazo = nodoReemp;
        TElementoAB<T> aux = nodoReemp.getHijoDer();

        while(aux != null){
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.getHijoIzq();
        }
        if(reemplazo != nodoReemp.getHijoDer()){
            reemplazarPadre.setHijoIzq(reemplazo.getHijoDer());
            reemplazo.setHijoDer(nodoReemp.getHijoDer());
        }
        System.out.println("El nodo reemplazo es: " + reemplazo.getEtiqueta());
        return reemplazo;
    }

    public int altura(){
        return alturaRecursiva(raiz);
    }

    private int alturaRecursiva(TElementoAB<T> nodo){
        if(nodo == null){
            return 0;
        } else{
            int alturaIzquierda = alturaRecursiva(nodo.getHijoIzq());
            int alturaDerecha = alturaRecursiva(nodo.getHijoDer());
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }

    public int size(){
        return Tamano(raiz);
    }

    private int Tamano(TElementoAB<T> nodo){
        if(nodo == null) return 0;
        else{
            int tamanoIzquierdo = Tamano(nodo.getHijoIzq());
            int tamanoDerecho = Tamano(nodo.getHijoDer());
            return tamanoIzquierdo + tamanoDerecho + 1;
        }
    }

    public int contarHojas(){
        return contadorHojas(raiz);
    }

    private int contadorHojas(TElementoAB<T> nodo){
        if(nodo == null) return 0;
        if(nodo.getHijoIzq() == null && nodo.getHijoDer() == null) return 1;
        return contadorHojas(nodo.getHijoIzq()) + contadorHojas(nodo.getHijoDer());
    }

    public int buscarNivel(int clave){
        return buscarNivel(raiz, clave, 1);
    }

    private int buscarNivel(TElementoAB<T> nodo, Comparable clave, int nivel) {
        if (nodo == null) return -1;
        if (nodo.getEtiqueta().compareTo(clave) == 0) return nivel;
        int nivelIzquierdo = buscarNivel(nodo.getHijoIzq(), clave, nivel + 1);
        if (nivelIzquierdo != -1) return nivelIzquierdo;
        return buscarNivel(nodo.getHijoDer(), clave, nivel + 1);
    }

    public Comparable buscarMin(){
        if(raiz == null) return null;
        TElementoAB<T> nodo = raiz;
        while(nodo.getHijoIzq() != null){
            nodo = nodo.getHijoIzq();
        }
        return nodo.getEtiqueta();
    }

    public Comparable buscarMax(){
        if(raiz == null) return null;
        TElementoAB<T> nodo = raiz;
        while(nodo.getHijoDer() != null){
            nodo = nodo.getHijoDer();
        }

        return nodo.getEtiqueta();
    }

    public Comparable buscarPredecesor(Comparable clave){
        TElementoAB<T> nodo = this.buscar(clave);
        if(nodo == null) return null;
        if(nodo.getHijoIzq() != null){
            TArbolBB<T> subArbolIZquierdo = new TArbolBB<>();
            subArbolIZquierdo.raiz = nodo.getHijoIzq();
            return subArbolIZquierdo.buscarMax();
        }
        TElementoAB<T> predecesor = null;
        TElementoAB<T> ancestro = raiz;
        while(ancestro != null && ancestro != nodo){
            if(clave.compareTo(ancestro.getEtiqueta()) > 0){
                predecesor = ancestro;
                ancestro = ancestro.getHijoDer();
            }else{
               ancestro = ancestro.getHijoIzq(); 
            }
        }
        return (predecesor == null) ? null : predecesor.getEtiqueta();
    }

    public int contarNodosNivel(int nivel) {
        return contarNodosNivel(raiz, nivel);
    }
    private int contarNodosNivel(TElementoAB<T> nodo, int nivel) {
        if (nodo == null) {
            return 0;
        }
        if (nivel == 1) {
            return 1;
        } else if (nivel > 1) {
            return contarNodosNivel(nodo.getHijoIzq(), nivel - 1) + contarNodosNivel(nodo.getHijoDer(), nivel - 1);
        } else {
            return 0;
        }
    }

    public void listarHojasConNivel() {
        listarHojasConNivel(raiz, 1);
    }
    private void listarHojasConNivel(TElementoAB<T> nodo, int nivel) {
        if (nodo != null) {
            if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
                System.out.println("Etiqueta: " + nodo.getEtiqueta() + "| Nivel: " + nivel);
            } else {
                listarHojasConNivel(nodo.getHijoIzq(), nivel + 1);
                listarHojasConNivel(nodo.getHijoDer(), nivel + 1);
            }
        }
    }

    public boolean esABB() {
        return esABB(raiz, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean esABB(TElementoAB<T> nodo, int min, int max) {
        if (nodo == null) {
            return true;
        }
        if ((int) nodo.getEtiqueta() < min || (int) nodo.getEtiqueta() > max) {
            return false;
        }
        return esABB(nodo.getHijoIzq(), min, (int) nodo.getEtiqueta() - 1) &&
               esABB(nodo.getHijoDer(), (int) nodo.getEtiqueta() + 1, max);
    }

    public void generarDot() {
        try (PrintWriter out = new PrintWriter(new FileWriter("arbolBinario.dot"))) {
            out.println("digraph G {");
            generarDot(raiz, out);
            out.println("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generarDot(TElementoAB<T> nodo, PrintWriter out) {
        if (nodo != null) {
            if (nodo.getHijoIzq() != null) {
                out.println("\"" + nodo.getEtiqueta() + "\" -> \"" + nodo.getHijoIzq().getEtiqueta() + "\";");
                generarDot(nodo.getHijoIzq(), out);
            }
            if (nodo.getHijoDer() != null) {
                out.println("\"" + nodo.getEtiqueta() + "\" -> \"" + nodo.getHijoDer().getEtiqueta() + "\";");
                generarDot(nodo.getHijoDer(), out);
            }
        }
    }

    public int calcularLTI(TElementoAB<T> nodo, int nivel) {
        if (nodo == null) {
            return 0;
        } else {
            return nivel + calcularLTI(nodo.getHijoIzq(), nivel + 1) + calcularLTI(nodo.getHijoDer(), nivel + 1);
        }
    }
    
    public float calcularLTIM() {
        int lti = calcularLTI(raiz, 0);
        int tamaño = obtenerTamaño(raiz);
        return (float) lti / tamaño;
    }
    
    public int obtenerTamaño(TElementoAB<T> nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return 1 + obtenerTamaño(nodo.getHijoIzq()) + obtenerTamaño(nodo.getHijoDer());
        }
    }

    
}
